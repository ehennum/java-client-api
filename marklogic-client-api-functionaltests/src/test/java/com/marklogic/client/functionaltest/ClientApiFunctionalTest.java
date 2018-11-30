package com.marklogic.client.functionaltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.stream.Stream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.DatabaseClientFactory.SecurityContext;
import com.marklogic.client.FailedRequestException;
import com.marklogic.client.SessionState;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.impl.BaseProxy;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.DocumentMetadataHandle.Capability;
import com.marklogic.client.io.FileHandle;
import com.marklogic.client.io.Format;
import com.marklogic.client.io.JacksonHandle;

public class ClientApiFunctionalTest extends BasicJavaClientREST {
	private static String dbName = "TestClientAPIOneDB";
	private static String[] fNames = { "TestClientAPIOneDB-1" };

	private static String dbNameMod = "TestClientAPIOneDBModules";
	private static String[] fNamesMod = { "TestClientAPIOneDBModules-1" };

	private static String serverName = "TestClientQAServer";
	private static String modServerName = "App-Services";
	private static String user = "admin";
	private static String host = null;

	private static int modulesPort = 8000;
	private static int admin_Port = 8002;
	private static int port = 8007;
	private static int restTestport = 8006;

	private static DatabaseClient dbclient = null;
	private static DatabaseClient schemaDBclient = null;

	// Create an identifier for modules document - Client API call will be to endpoint
	private static String endPointURI_1 = "/ext/TestE2EIntegerParamReturnDouble/TestE2EIntegerParamReturnDouble";
	private static String endPointURI_2 = "/ext/TestE2EIntegerParamReturnDouble/TestE2EIntegerParamReturnDoubleErrorCond";
	private static String endPointURI_3 = "/ext/TestE2EIntegerParamReturnDouble/TestRequiredParam";
	
	private static String endPointURI_5 = "/ext/TestE2EMultiStringsInStringsOut/TestE2EJsonStringsInStringsOut";
	private static String endPointURI_6 = "/ext/TestE2EModuleNotFound/TestE2EModuleNotFound";
	private static String endPointURI_7 = "/ext/TestE2ESession/TestE2ESession";	
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("In setup");
		loadGradleProperties();

		host = getServer();
		// Configure App-Services server so that we can write the (sjs or xqy) modules into modules DB.
		associateRESTServerWithDB(modServerName, dbNameMod);

		// Create an REST App Server to validate inserts
		/*if (IsSecurityEnabled())
			setupJavaRESTServer(dbName, fNames[0], restSslServerName, getRestServerPort());
		else*/
			setupJavaRESTServer(dbName, fNames[0], "TestRESTServerOnAPI", restTestport);
		createDB(dbName);
		createForest(fNames[0], dbName);

		createDB(dbNameMod);
		createForest(fNamesMod[0], dbNameMod);
		createAppServer(serverName, port);

		createUserRolesWithPrevilages("apiRole", "xdbc:eval", "xdbc:eval-in", "xdmp:eval-in", "any-uri", "xdbc:invoke", "xdmp:eval", "xdmp:eval-in");
		createRESTUser("apiUser", "ap1U53r", "apiRole", "rest-admin", "rest-writer", "rest-reader",
				"rest-extension-user", "manage-user");
		createRESTUser("secondApiUser", "ap1U53r", "apiRole", "rest-admin", "rest-writer", "rest-reader",
				"rest-extension-user", "manage-user");
		createUserRolesWithPrevilages("ForbiddenRole", "any-uri");
		createRESTUser("ForbiddenUser", "ap1U53r", "apiRole", "rest-admin", "rest-writer", "rest-reader",
				"manage-user");
		SecurityContext secContext = new DatabaseClientFactory.DigestAuthContext("apiUser", "ap1U53r"); 
		dbclient = DatabaseClientFactory.newClient(host, port, secContext, getConnType());		
		schemaDBclient = getDatabaseClientOnDatabase(host, modulesPort, dbNameMod, user, "admin",
				getConnType());	

		TextDocumentManager docMgr = schemaDBclient.newTextDocumentManager();
		File file = new File(
				"src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EIntegerParamReturnDouble.sjs");
				
		// create a handle on the content
		FileHandle handle = new FileHandle(file);
		DocumentMetadataHandle metadataHandle = new DocumentMetadataHandle();
		metadataHandle.getPermissions().add("apiRole", Capability.UPDATE, Capability.READ, Capability.EXECUTE);
		
		// write the document content
		docMgr.write(endPointURI_1+".sjs", metadataHandle, handle);
		file = null;
		handle = null;
		file = new File(
					"src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EIntegerParamReturnDouble.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_1+".api", metadataHandle, handle);
		file = null;
		handle = null;		

		file = new File(
				"src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EIntegerParamReturnDoubleErrorCond.sjs");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_2+".sjs", metadataHandle, handle);
		file = null;
		handle = null;
		file = new File(
				"src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EIntegerParamReturnDoubleErrorCond.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_2+".api", metadataHandle, handle);
		file = null;
		handle = null;

		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestRequiredParam.sjs");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_3+".sjs", metadataHandle, handle);
		file = null;
		handle = null;
		
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestRequiredParam.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_3+".api", metadataHandle, handle);
		file = null;
		handle = null;		
		
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EJsonStringsInStringsOut.sjs");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_5+".sjs", metadataHandle, handle);
		file = null;
		handle = null;
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EJsonStringsInStringsOut.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_5+".api", metadataHandle, handle);
		file = null;
		handle = null;
		
		// Do not add the SJS module to DB
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EModuleNotFound.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_6+".api", metadataHandle, handle);
		file = null;
		handle = null;
		
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2ESession.sjs");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_7+".sjs", metadataHandle, handle);
		file = null;
		handle = null;
		file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2ESession.api");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_7+".api", metadataHandle, handle);
		file = null;
		handle = null;	
		
		/*file = new File("src/test/java/com/marklogic/client/functionaltest/data/api/TestE2EJsonDocsInStringsOut.sjs");
		handle = new FileHandle(file);
		docMgr.write(endPointURI_4, metadataHandle, handle);
		file = null;
		handle = null;*/
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In tear down");

		deleteUserRole("apiRole");
		deleteRESTUser("apiUser");
		deleteRESTUser("secondApiUser");
		deleteUserRole("ForbiddenRole");
		deleteRESTUser("ForbiddenUser");

		associateRESTServerWithDB(modServerName, "Documents");
		// release client
		dbclient.release();
	}

	public static void createAppServer(String appServerName, int restPort) {
		DefaultHttpClient client = null;
		int admin_port = getAdminPort();
		try {
			client = new DefaultHttpClient();

			client.getCredentialsProvider().setCredentials(new AuthScope(host, getAdminPort()),
					new UsernamePasswordCredentials("admin", "admin"));
			HttpPost post = new HttpPost("http://" + host + ":" + admin_port
					+ "/manage/v2/servers?group-id=Default&server-type=http&format=json");		
			String JSONString = "{\"server-name\":\"" + serverName + "\",\"port\":\"" + port + "\"," + "\"root\":\"/\""
					+ ", \"content-database\":\"" + dbName + "\"," + "\"modules-database\":\"" + dbNameMod + "\"" + "}";

			post.addHeader("Content-type", "application/json");
			post.setEntity(new StringEntity(JSONString));

			HttpResponse response = client.execute(post);
			HttpEntity respEntity = response.getEntity();

			if (respEntity != null) {
				// EntityUtils to get the response content
				String content = EntityUtils.toString(respEntity);
				System.out.println(content);
			}
		} catch (Exception e) {
			// writing error to Log
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	public static void enableRewriterOnRESTServer(String restServerName, String dbName) throws Exception {
		DefaultHttpClient client = null;
		try {
			client = new DefaultHttpClient();

			client.getCredentialsProvider().setCredentials(new AuthScope(host, getAdminPort()),
					new UsernamePasswordCredentials("admin", "admin"));
			String body = "{\"group-name\": \"Default\",\"url-rewriter\":\"/ext/ClientAPIrewrter.xml\"}";

			HttpPut put = new HttpPut("http://" + host + ":" + getAdminPort() + "/manage/v2/servers/" + restServerName
					+ "/properties?server-type=http");
			put.addHeader("Content-type", "application/json");
			put.setEntity(new StringEntity(body));

			HttpResponse response2 = client.execute(put);
			HttpEntity respEntity = response2.getEntity();
			if (respEntity != null) {
				String content = EntityUtils.toString(respEntity);
				System.out.println(content);
			}
		} catch (Exception e) {
			// writing error to Log
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	@Test
	public void TestE2EItemPrice() throws Exception {

		System.out.println("Running TestE2EItemPrice");
		// Invoke the function
		Double responseBack1 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(new Integer(0));
		System.out.println("Expected 1.0. Response from the Client API call is " + responseBack1);
		assertEquals(1.0, responseBack1, 0.00);

		Double responseBack2 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(new Integer(-1));
		System.out.println("Expected 0.0.  Response from the Client API call is " + responseBack2);
		assertEquals(0.0, responseBack2, 0.00);

		Double responseBack3 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(new Integer(1));
		System.out.println("Expected 2.0. Response from the Client API call is " + responseBack3);
		assertEquals(2.0, responseBack3, 0.00);

		Double responseBack4 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(0);
		System.out.println("Expected 1.0.  Response from the Client API call is " + responseBack4);
		assertEquals(1.0, responseBack4, 0.00);

		short srt = 12;
		Double responseBack5 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice((int) srt);
		System.out.println("Expected 13.0.  Response from the Client API call is " + responseBack5);
		assertEquals(13.0, responseBack5, 0.00);
		// Integer.MAX_VALUE
		double responseBack6 = TestE2EIntegerParaReturnDouble.on(dbclient)
				.TestE2EItemPrice(new Integer(Integer.MAX_VALUE));
		System.out.println("Expected Integer.MAX_VALUE.  Response from the Client API call is " + responseBack6);
		assertTrue("Expected value not returned", String.valueOf(responseBack6).contains("2.147483648E9"));

		// Integer.MIN_VALUE
		double responseBack7 = TestE2EIntegerParaReturnDouble.on(dbclient)
				.TestE2EItemPrice(new Integer(Integer.MIN_VALUE));
		System.out.println("Expected Integer.MIN_VALUE.  Response from the Client API call is " + responseBack7);
		assertTrue("Expected value not returned", String.valueOf(responseBack7).contains("-2.147483647E9"));

		// Expecting incorrect data type from module
		double responseBack8 = 0.0;
		try {
			responseBack8 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(new Integer(10));
		} catch (Exception ex) {
			System.out.println("Expecting 0. Response from the Client API call is " + responseBack8);
			System.out.println("Exception response from the Client API call is " + ex.toString());
			assertTrue("Exception message incorrect", ex.toString().contains("java.lang.IllegalArgumentException: Could not convert to double: String10"));
			assertEquals(0.0, responseBack8, 0.00);
		}

		// Null input. Expect 55555.00 as the return from API module so that we know
		// passing null works
		Double responseBack9 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPrice(null);
		System.out.println("Expected 55555.00.  Response from the Client API call is " + responseBack9);
		assertEquals(55555.00, responseBack9, 0.00);

		// Verify calls with two parameters - both nulls
		float responseBack11 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPriceErrorCond(null, null);
		System.out.println("Expected 30000.0.  Response from the Client API call is " + responseBack11);
		assertEquals(35000.0, responseBack11, 0.00);

		// Verify calls with two parameters - second null parameter
		float responseBack12 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPriceErrorCond(10, null);
		System.out.println("Expected 20000.0.  Response from the Client API call is " + responseBack12);
		assertEquals(20000.0, responseBack12, 0.00);
	}

	// This test requires TestE2ERequiredParam.api Fn Decl file
	@Test
	public void TestE2ERequiredParam() throws Exception {

		System.out.println("Running TestE2ERequiredParam");
		// Invoke the function with no Params - API decl states params as required
		String msg;
		try {
			Float responseBack1 = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2ERequiredParam(null, null);
		} catch (Exception ex) {
			msg = ex.toString();
			System.out.println("Exception response from the Client API call is " + ex.toString());
			assertTrue("Expected exception type not returned", msg.contains("RequiredParamException"));
			assertTrue("Expected exception returned", msg.contains("null value for required parameter: items"));
		}
	}

	// This test sets the App Server Default user to some one else and then DBClient
	// uses another one to login. Expect to see ResourceNotFoundException.
	@Test
	public void TestE2EUnAuthorizedUser() throws Exception {

		System.out.println("Running TestE2EUnAuthorizedUser");
		associateRESTServerWithDefaultUser(serverName, "security", "digest");
		SecurityContext secContext = new DatabaseClientFactory.DigestAuthContext("ForbiddenUser", "ap1U53r");
		DatabaseClient dbForbiddenclient = DatabaseClientFactory.newClient(host, port, secContext, getConnType()); 				
		String msg;
		try {
			Float responseBack1 = TestE2EIntegerParaReturnDouble.on(dbForbiddenclient).TestE2EItemPriceErrorCond(10, 50);
		} catch (Exception ex) {
			msg = ex.toString();
			System.out.println("Exception response from the Client API call is " + ex.toString());
			assertTrue("Expected exception type not returned",
					msg.contains("com.marklogic.client.FailedRequestException"));
			assertTrue("Expected exception returned", msg.contains(
					"failed to POST at /ext/TestE2EIntegerParamReturnDouble/TestE2EIntegerParamReturnDoubleErrorCond.sjs"));
		} finally {
			associateRESTServerWithDefaultUser(serverName, "nobody", "digest");
		}
	}
	
	// No module installed for test.
	@Test
	public void TestE2EModuleNotFound() throws Exception {

		System.out.println("Running TestE2EModuleNotFound");
		DatabaseClient dbForbiddenclient = getDatabaseClientOnDatabase(host, port, dbName, "ForbiddenUser", "ap1U53r",
				getConnType());
		String msg;
		try {
			String responseBack1 = TestE2EModuleNotFound.on(dbclient).ModuleNotFound("a", "b");
		} catch (Exception ex) {
			msg = ex.toString();
			System.out.println("Exception response from the Client API call is " + ex.toString());
			assertTrue("Expected exception type not returned",
					msg.contains("com.marklogic.client.FailedRequestException"));
			assertTrue("Expected exception returned", msg.contains(
					"failed to POST at /ext/TestE2EModuleNotFound/TestE2EModuleNotFound.sjs"));
		} finally {
		}
	}

	// This test sets the App Server concurrent users to be 1 instead of 0
	// (default). Expect to see ForbiddenUser when same user logins multiple times.
	@Test
	public void TestE2ENumberOfConcurrentUsers() throws Exception {
		StringBuilder msgEx = new StringBuilder();
		Thread w1, w2, w3;

		System.out.println("Running TestE2ENumberOfConcurrentUsers");
		modifyConcurrentUsersOnHttpServer(serverName, 1);

		class MultipleApiUsers implements Runnable {

			String msg;
			Float f;

			public void run() {
				try {
					f = TestE2EIntegerParaReturnDouble.on(dbclient).TestE2EItemPriceErrorCond(1000, 1000);
				} catch (FailedRequestException ex) {
					System.out.println("Exception is from Thread " + msg);
					ex.printStackTrace();
					msgEx.append(msg);
					msgEx.append("******");
					msgEx.append(ex.getMessage());
				}
			}

			MultipleApiUsers(String in) {
				msg = in;
			}
		}

		// Setup 3 API calls
		try {
			MultipleApiUsers m1 = new MultipleApiUsers("m1");
			w1 = new Thread(m1);

			MultipleApiUsers m2 = new MultipleApiUsers("m2");
			w2 = new Thread(m2);

			MultipleApiUsers m3 = new MultipleApiUsers("m3");
			w3 = new Thread(m3);

			w1.start();
			w2.start();
			w3.start();
		} catch (FailedRequestException ex) {
			msgEx.append(ex.toString());

		} finally {
			// revert back to 0.
			modifyConcurrentUsersOnHttpServer(serverName, 0);
			System.out.println("Exception from API responses of call are " + msgEx.toString());

			assertTrue("Expected exception not returned", msgEx.toString().contains(
					"Local message: failed to POST at /ext/TestE2EIntegerParamReturnDouble/TestE2EIntegerParamReturnDoubleErrorCond.sjs"));
		}
	}

	// Test users with invalid roles	
	@Test
	public void TestE2EuserWithInvalidRole() throws Exception {
		// Used this test to verify ResourceNotFoundException when sjs module is installed with incorrect doc URI

		System.out.println("Running TestE2EuserWithInvalidRole");
		SecurityContext secContext = new DatabaseClientFactory.DigestAuthContext("secondApiUser", "ap1U53r");
		DatabaseClient dbSecondClient = DatabaseClientFactory.newClient(host, port, secContext, getConnType());
		String msg;
		try {
			Float responseBack1 = TestE2EIntegerParaReturnDouble.on(dbSecondClient).TestE2EItemPriceErrorCond(10, 50);
		} catch (Exception ex) {
			msg = ex.toString();
			System.out.println("Exception response from the Client API call is " + ex.toString());
			assertTrue("Expected exception type not returned",
					msg.contains("com.marklogic.client.ResourceNotFoundException"));
			assertTrue("Expected exception returned", msg.contains(
					"Could not POST at /ext/TestE2EIntegerParaReturnDouble/TestE2EIntegerParamReturnDoubleErrorCond.sjs"));
		} finally {
		
		}
	}
	
	// This test requires TestE2EJsonDocsInStringsOut.api Fn Decl file
	@Test
	public void TestE2EJsonDocsInStringsOut() throws Exception {

		System.out.println("Running TestE2EJsonDocsInStringsOut");
		String dirName = "src/test/java/com/marklogic/client/functionaltest/data/";
		String[] filenames = { "constraint1", "constraint2"/*, "constraint3.json", "constraint4.json", "constraint5.json" */};
		// Invoke the function with no Params - API decl states params as required
		String msg;
		// Holder for module function's output
		ArrayNode outputStrSeq = null;

		String s1 = "Vannevar Bush wrote an article for The Atlantic Monthly";
		String s2 = "Lisa wrote an article for The Strait Times";

		Stream<String> inputFiles = Stream.of(s1,s2);	

		Stream<java.lang.String> uris = Stream.of(filenames);
		Stream<java.lang.String> searchItem =  Stream.of("Bush");

		try {				
			outputStrSeq = TestE2EMultipleStringsInMultipleStringsout.on(dbclient).stringsInAndStringOutAsArray(inputFiles, uris, searchItem);
			System.out.println("outputStrSeq " + outputStrSeq.toString());
			assertTrue("Correct URI not returned", outputStrSeq.get(0).asText().contains("constraint1.json"));;
		} catch (Exception ex) {
			msg = ex.toString();
			System.out.println("Exception response from the Client API call is " + ex.toString());				
		}
	}
	
	// Tests API calls with session data-type.
	@Test
	public void TestE2ESessions() throws Exception {

		System.out.println("Running TestE2ESessions");
		SessionState apiSession1 = TestE2ESession.on(dbclient).newSessionState();

		try {
			TestE2ESession.on(dbclient).SessionChecks(apiSession1, "/session1.json", "{\"value\":\"Checking first sessions\"}");;
			//assertTrue("Server module returned false. session1.json not inserted? See Logs", responseBack1);
		} catch (Exception ex) {
			System.out.println("Exception - session1.json first Client API call is " + ex.toString());
		}
		// Try multiple calls sequentially  - different session
		try {
			SessionState apiSession2 = TestE2ESession.on(dbclient).newSessionState();
			TestE2ESession.on(dbclient).SessionChecks(apiSession2, "/session2.json", "{\"value\":\"Checking sessions 2\"}");
			Thread.sleep(5000);
			SessionState apiSession3 = TestE2ESession.on(dbclient).newSessionState();
			TestE2ESession.on(dbclient).SessionChecks(apiSession3, "/session3.json", "{\"value\":\"Checking sessions 3\"}");
			
		} catch (Exception ex) {
			System.out.println("Exception - session2.json / session3.json - Client API call is " + ex.toString());
		}
		SecurityContext secContext = new DatabaseClientFactory.DigestAuthContext("apiUser", "ap1U53r");
		DatabaseClient dbclientRest = DatabaseClientFactory.newClient(host, restTestport, secContext, getConnType());
		this.waitForPropertyPropagate();
		JSONDocumentManager docMgr = dbclientRest.newJSONDocumentManager();
		 JacksonHandle jh = new JacksonHandle();
	    // Validate the content
	    docMgr.read("/session1.json", jh);
	    String nodeStr = jh.get().get("value").asText();
	    System.out.println("JacksonHandle 1: " + jh.toString());
		assertTrue("Server module returned false. session1.json not inserted? See Logs", nodeStr.contains("Checking first sessions") );
		
		// Try multiple calls sequentially - same session
		try {
			SessionState apiSession4 = TestE2ESession.on(dbclient).newSessionState();
			TestE2ESession.on(dbclient).SessionChecks(apiSession4, "/session4.json",
					"{\"value\":\"Checking sessions 4\"}");
			Thread.sleep(5000);
			TestE2ESession.on(dbclient).SessionChecks(apiSession4, "/session5.json",
					"{\"value\":\"Checking sessions 5\"}");

		} catch (Exception ex) {
			System.out.println("Exception - session4.json / session5.json - Client API call is " + ex.toString());
		}
		// Validate the content
		jh = new JacksonHandle();
		nodeStr = null;
		docMgr.read("/session5.json", jh);
		nodeStr = jh.get().get("value").asText();
		System.out.println("JacksonHandle 5 " + jh.toString());
		assertTrue("Server module returned false. session5.json not inserted? See Logs",
				nodeStr.contains("Checking sessions 5"));
		
		// Use null session
		try {
			TestE2ESession.on(dbclient).SessionChecks(null, "/session6.json",
					"{\"value\":\"Checking sessions 6\"}");

		} catch (Exception ex) {
			String msg = ex.toString();
			System.out.println("Exception - session6.json - Client API call is " + msg);
			assertTrue("Exception incorrect - when sessions is null",msg.contains("RequiredParamException"));
			assertTrue("Exception incorrect - when sessions is null",msg.contains("null value for required session parameter: api_session"));
		}
		
		// Use session with cleared cookies
		SessionState apiSession7 = TestE2ESession.on(dbclient).newSessionState();				
		
		try {			
			TestE2ESession.on(dbclient).SessionChecks(apiSession7, "/session7.json",
					"{\"value\":\"Checking sessions 7\"}");

		} catch (Exception ex) {
			String msg = ex.toString();
			System.out.println("Exception - session6.json - Client API call is " + msg);		
		}
		jh = new JacksonHandle();
		nodeStr = null;
		docMgr.read("/session7.json", jh);
		nodeStr = jh.get().get("value").asText();
		System.out.println("JacksonHandle 7 " + jh.toString());
		assertTrue("Server module returned false. session7.json not inserted? See Logs",
				nodeStr.contains("Checking sessions 7"));
	}
// TODO Tests API calls to multiple endpoints with same DBClient and different client
	
	public static void modifyConcurrentUsersOnHttpServer(String restServerName, int numberOfUsers) throws Exception {
		DefaultHttpClient client = new DefaultHttpClient();
		client.getCredentialsProvider().setCredentials(new AuthScope(host, getAdminPort()),
				new UsernamePasswordCredentials("admin", "admin"));
		String extSecurityrName = "";
		String body = "{\"group-name\": \"Default\", \"concurrent-request-limit\":\"" + numberOfUsers + "\"}";

		HttpPut put = new HttpPut("http://" + host + ":" + admin_Port + "/manage/v2/servers/" + restServerName
				+ "/properties?server-type=http");
		put.addHeader("Content-type", "application/json");
		put.setEntity(new StringEntity(body));
		HttpResponse response2 = client.execute(put);
		HttpEntity respEntity = response2.getEntity();
		if (respEntity != null) {
			String content = EntityUtils.toString(respEntity);
			System.out.println(content);
		}
		client.getConnectionManager().shutdown();
	}
}
	
/**
 * Provides a set of operations on the database server
 */
interface TestE2EIntegerParaReturnDouble {
    /**
     * Creates a TestE2EIntegerParaReturnDouble object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for session state
     */
    static TestE2EIntegerParaReturnDouble on(DatabaseClient db) {
        final class TestE2EIntegerParaReturnDoubleImpl implements TestE2EIntegerParaReturnDouble {
            private BaseProxy baseProxy;

            private TestE2EIntegerParaReturnDoubleImpl(DatabaseClient dbClient) {
                baseProxy = new BaseProxy(dbClient, "/ext/TestE2EIntegerParamReturnDouble/");
            }

            @Override
            public Double TestE2EItemPrice(Integer itemId) {
              return BaseProxy.DoubleType.toDouble(
                baseProxy
                .request("TestE2EIntegerParamReturnDouble.sjs", BaseProxy.ParameterValuesKind.SINGLE_ATOMIC)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("itemId", true, BaseProxy.IntegerType.fromInteger(itemId)))
                .withMethod("POST")
                .responseSingle(true, null)
                );
            }


            @Override
            public java.lang.Float TestE2EItemPriceErrorCond(Integer items, java.lang.Integer price) {
              return BaseProxy.FloatType.toFloat(
                baseProxy
                .request("TestE2EIntegerParamReturnDoubleErrorCond.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("items", true, BaseProxy.IntegerType.fromInteger(items)),
                    BaseProxy.atomicParam("price", true, BaseProxy.IntegerType.fromInteger(price)))
                .withMethod("POST")
                .responseSingle(true, null)
                );
            }


            @Override
            public java.lang.Float TestE2ERequiredParam(Integer items, java.lang.Integer price) {
              return BaseProxy.FloatType.toFloat(
                baseProxy
                .request("TestRequiredParam.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("items", false, BaseProxy.IntegerType.fromInteger(items)),
                    BaseProxy.atomicParam("price", false, BaseProxy.IntegerType.fromInteger(price)))
                .withMethod("POST")
                .responseSingle(true, null)
                );
            }

        }

        return new TestE2EIntegerParaReturnDoubleImpl(db);
    }

  /**
   * Invokes the TestE2EItemPrice operation on the database server
   *
   * @param itemId	provides input
   * @return	as output
   */
    Double TestE2EItemPrice(Integer itemId);

  /**
   * Invokes the TestE2EItemPriceErrorCond operation on the database server
   *
   * @param items	provides input
   * @param price	provides input
   * @return	as output
   */
    java.lang.Float TestE2EItemPriceErrorCond(Integer items, java.lang.Integer price);

  /**
   * Invokes the TestE2ERequiredParam operation on the database server
   *
   * @param items	provides input
   * @param price	provides input
   * @return	as output
   */
    java.lang.Float TestE2ERequiredParam(Integer items, java.lang.Integer price);

}

/**
 *  This class verifies the stream of Json documents written into DB and accepts a string query. REturns URIs
 */
interface TestE2EMultipleStringsInMultipleStringsout {
    /**
     * Creates a TestE2EMultipleStringsInMultipleStringsout object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for session state
     */
    static TestE2EMultipleStringsInMultipleStringsout on(DatabaseClient db) {
        final class TestE2EMultipleStringsInMultipleStringsoutImpl implements TestE2EMultipleStringsInMultipleStringsout {
            private BaseProxy baseProxy;

            private TestE2EMultipleStringsInMultipleStringsoutImpl(DatabaseClient dbClient) {
                baseProxy = new BaseProxy(dbClient, "/ext/TestE2EMultiStringsInStringsOut/");
            }

            @Override
            public com.fasterxml.jackson.databind.node.ArrayNode stringsInAndStringOutAsArray(Stream<String> inputFiles, Stream<String> uris, Stream<String> searchItem) {
              return BaseProxy.ArrayType.toArrayNode(
                baseProxy
                .request("TestE2EJsonStringsInStringsOut.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("inputFiles", false, BaseProxy.StringType.fromString(inputFiles)),
                    BaseProxy.atomicParam("uris", false, BaseProxy.StringType.fromString(uris)),
                    BaseProxy.atomicParam("searchItem", false, BaseProxy.StringType.fromString(searchItem)))
                .withMethod("POST")
                .responseSingle(false, Format.JSON)
                );
            }

        }

        return new TestE2EMultipleStringsInMultipleStringsoutImpl(db);
    }

  /**
   * Invokes the stringsInAndStringOutAsArray operation on the database server
   *
   * @param inputFiles	A sequence of strings that need to be written to Database
   * @param uris	A sequence of document uris for docs written to Database
   * @param searchItem	Search string with 1 word or multiples
   * @return	Module to return array of doc Ids
   */
    com.fasterxml.jackson.databind.node.ArrayNode stringsInAndStringOutAsArray(Stream<String> inputFiles, Stream<String> uris, Stream<String> searchItem);

}

/**
 * This class verifies the error message when module is not available
 */
interface TestE2EModuleNotFound {
	/**
     * Creates a TestE2EModuleNotFound object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for session state
     */
    static TestE2EModuleNotFound on(DatabaseClient db) {
        final class TestE2EModuleNotFoundImpl implements TestE2EModuleNotFound {
            private BaseProxy baseProxy;

            private TestE2EModuleNotFoundImpl(DatabaseClient dbClient) {
                baseProxy = new BaseProxy(dbClient, "/ext/TestE2EModuleNotFound/");
            }

            @Override
            public java.lang.String ModuleNotFound(String count, String starttime) {
              return BaseProxy.TextDocumentType.toString(
                baseProxy
                .request("TestE2EModuleNotFound.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession()
                .withParams(
                    BaseProxy.atomicParam("count", false, BaseProxy.DecimalType.fromString(count)),
                    BaseProxy.atomicParam("starttime", false, BaseProxy.TimeType.fromString(starttime)))
                .withMethod("POST")
                .responseSingle(false, Format.TEXT)
                );
            }

        }

        return new TestE2EModuleNotFoundImpl(db);
    }

  /**
   * Invokes the ModuleNotFound operation on the database server
   *
   * @param count	Big Decimal numbers
   * @param starttime	Java Local time
   * @return	Module to return text document
   */
    java.lang.String ModuleNotFound(String count, String starttime);

}

/**
 * This class verifies the sessions
 */
interface TestE2ESession {
	 /**
     * Creates a TestE2ESession object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for session state
     */
    static TestE2ESession on(DatabaseClient db) {
        final class TestE2ESessionImpl implements TestE2ESession {
            private BaseProxy baseProxy;

            private TestE2ESessionImpl(DatabaseClient dbClient) {
                baseProxy = new BaseProxy(dbClient, "/ext/TestE2ESession/");
            }
            @Override
            public SessionState newSessionState() {
              return baseProxy.newSessionState();
            }

            @Override
            public void SessionChecks(SessionState api_session, String uri, String content) {
              baseProxy
                .request("TestE2ESession.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS)
                .withSession("api_session", api_session, false)
                .withParams(
                    BaseProxy.atomicParam("uri", false, BaseProxy.StringType.fromString(uri)),
                    BaseProxy.atomicParam("content", false, BaseProxy.StringType.fromString(content)))
                .withMethod("POST")
                .responseNone();
            }

        }

        return new TestE2ESessionImpl(db);
    }
    /**
     * Creates an object to track a session for a set of operations
     * that require session state on the database server.
     *
     * @return	an object for session state
     */
    SessionState newSessionState();

  /**
   * Invokes the SessionChecks operation on the database server
   *
   * @param api_session	Holds the session object
   * @param uri	Doc Id of the inserted document
   * @param content	Doc contents of the inserted document
   * 
   */
    void SessionChecks(SessionState api_session, String uri, String content);

}
