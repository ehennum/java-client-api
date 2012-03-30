package com.marklogic.client.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;

import com.marklogic.client.DocumentIdentifier;
import com.marklogic.client.RequestLogger;
import com.marklogic.client.XMLDocumentManager;
import com.marklogic.client.impl.OutputStreamTee;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.StringHandle;

public class RequestLoggerTest {
	@BeforeClass
	public static void beforeClass() {
		Common.connect();
	}
	@AfterClass
	public static void afterClass() {
		Common.release();
	}

	@Test
	public void testCopyTee() throws IOException {
		String expectedString = "first line\nsecond line\n";

		ByteArrayOutputStream out = null;
		RequestLogger logger = null;
		String outString = null;

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);

		StringReader mainReader = new StringReader(expectedString);
		Reader copyReader = logger.copyContent(mainReader);
		String copyString = Common.readerToString(copyReader);
		assertEquals("Copy reader failed to read", expectedString, copyString);
		outString = new String(out.toByteArray());
		assertEquals("Out failed to read", expectedString, outString);

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);

		ByteArrayInputStream mainInputStream =
			new ByteArrayInputStream(expectedString.getBytes());
		InputStream copyInputStream = logger.copyContent(mainInputStream);
		byte[] copyBytes = Common.streamToBytes(copyInputStream);
		assertEquals("Copy input stream failed to read", expectedString, new String(copyBytes));
		outString = new String(out.toByteArray());
		assertEquals("Out failed to read", expectedString, outString);

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);

		ByteArrayOutputStream mainOutputStream = new ByteArrayOutputStream();
		OutputStream tee = new OutputStreamTee(mainOutputStream, out, Long.MAX_VALUE);
		tee.write(expectedString.getBytes());
		byte[] mainBytes = mainOutputStream.toByteArray();
		assertEquals("Main output stream failed to read", expectedString, new String(mainBytes));
		outString = new String(out.toByteArray());
		assertEquals("Out failed to read", expectedString, outString);
	}

	@Test
	public void testWriteReadLog() throws IOException, ParserConfigurationException {
		String uri = "/test/testWrite1.xml";

		DocumentIdentifier docId = Common.client.newDocId(uri);

		Document domDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element root = domDocument.createElement("root");
		root.setAttribute("xml:lang", "en");
		root.setAttribute("foo", "bar");
		root.appendChild(domDocument.createElement("child"));
		root.appendChild(domDocument.createTextNode("mixed"));
		domDocument.appendChild(root);

		String domString = ((DOMImplementationLS) DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.getDOMImplementation()).createLSSerializer().writeToString(domDocument)
				.replaceFirst("^<\\?xml(\\s+version=\"[^\"]*\"|\\s+encoding=\"[^\"]*\")*\\s*\\?>\\s*", "");

		ByteArrayOutputStream out = null;
		RequestLogger logger = null;
		String outString = null;

		XMLDocumentManager docMgr = Common.client.newXMLDocumentManager();

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);
		docMgr.startLogging(logger);

		docMgr.write(docId, new DOMHandle().with(domDocument));
		outString = new String(out.toByteArray());
		assertTrue("Write failed to log output", outString.contains(domString));

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);
		docMgr.startLogging(logger);

		String docText = docMgr.read(docId, new StringHandle()).get();
		outString = new String(out.toByteArray());
		assertTrue("Read failed to log output", outString.contains(docText));

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);
		docMgr.startLogging(logger);

		boolean isDoc = docMgr.exists(docId);
		outString = new String(out.toByteArray());
		assertTrue("Exists failed to log output", outString != null && outString.length() > 0);

		out = new ByteArrayOutputStream();
		logger = Common.client.newLogger(out);
		logger.setContentMax(RequestLogger.ALL_CONTENT);
		docMgr.startLogging(logger);

		docMgr.delete(docId);
		outString = new String(out.toByteArray());
		assertTrue("Delete failed to log output", outString != null && outString.length() > 0);
	}

}
