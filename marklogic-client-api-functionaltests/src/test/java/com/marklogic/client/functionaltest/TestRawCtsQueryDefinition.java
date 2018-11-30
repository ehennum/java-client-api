/*
 * Copyright 2014-2018 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marklogic.client.functionaltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.admin.ServerConfigurationManager;
import com.marklogic.client.io.Format;
import com.marklogic.client.io.JacksonHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.io.ValuesHandle;
import com.marklogic.client.io.marker.CtsQueryWriteHandle;
import com.marklogic.client.query.CountedDistinctValue;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.RawCtsQueryDefinition;
import com.marklogic.client.query.ValuesDefinition;

/*
 * These tests are intended to verify the methods of RawCtsQueryDefinition class.
 * Much of query types have been functionally tested using RawCombinedQueryDefinition and RawStructuredQueryDefinition classes
 * Refer to Git Issue 720 for this feature's intent.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRawCtsQueryDefinition extends BasicJavaClientREST {
  private static String dbName = "TestRawCtsQueryDefinitionDB";
  private static String[] fNames = { "TestRawCtsQueryDefinitionDB-1" };
  private static DatabaseClient client = null;

  @BeforeClass
  public static void setUp() throws Exception
  {
    System.out.println("In setup");
    configureRESTServer(dbName, fNames);
    setupAppServicesConstraint(dbName);
    addRangeElementAttributeIndex(dbName, "decimal", "http://cloudbank.com", "price", "", "amt", "http://marklogic.com/collation/");
    addFieldExcludeRoot(dbName, "para");
    includeElementFieldWithWeight(dbName, "para", "", "p", 5, "", "", "");
    client = getDatabaseClient("rest-admin", "x", getConnType());
  }

  @After
  public void testCleanUp() throws Exception {
    clearDB();
    System.out.println("Running clear script");
  }
  
  @Test
  public void testRawCtsWordQuery() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException, TransformerException
  {
    System.out.println("Running testRawCtsWordQuery");

    String[] filenames = { "constraint1.xml", "constraint2.xml", "constraint3.xml", "constraint4.xml", "constraint5.xml" };

    // set query option validation to true
    ServerConfigurationManager srvMgr = client.newServerConfigManager();
    srvMgr.readConfiguration();
    srvMgr.setQueryOptionValidation(true);
    srvMgr.writeConfiguration();

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/raw-combined-query/", "XML");
    }

    QueryManager queryMgr = client.newQueryManager();

    // create a search definition
    String wordQuery = "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
                       "<cts:text>groundbreaking</cts:text></cts:word-query>";
    StringHandle handle = new StringHandle().with(wordQuery);
    RawCtsQueryDefinition querydef = queryMgr.newRawCtsQueryDefinition(handle);
    
     // create result handle
    JacksonHandle resultsHandle = new JacksonHandle();
    queryMgr.search(querydef, resultsHandle);

    // get the result
    JsonNode result = resultsHandle.get();
   
    String text = result.path("results").get(0).get("matches").get(0).get("match-text").get(0).asText().trim();
    String uri = result.path("results").get(0).path("uri").asText();
    System.out.println("Text " + text);
    System.out.println("URI " + uri);
    
    String expectedText = "For 1945, the thoughts expressed in The Atlantic Monthly were";
    String expectedUri = "/raw-combined-query/constraint3.xml";    
    assertTrue("URI not found", expectedUri.contains(uri));
    assertTrue("Highlight not found", expectedText.contains(text));   
  }
  
  @Test
  public void testRawCtsWordQueryWithOptions() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException
  {
    System.out.println("Running testRawCtsWordQueryWithOptions");

    String[] filenames = { "constraint1.xml", "constraint2.xml", "constraint3.xml", "constraint4.xml", "constraint5.xml" };
    String queryOptionName = "wordConstraintWithNormalWordQueryOpt.xml";

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/word-constraint/", "XML");
    }

    setQueryOption(client, queryOptionName);

    QueryManager queryMgr = client.newQueryManager();
    // create a search definition
    String wordQuery = "<cts:or-query xmlns:cts=\"http://marklogic.com/cts\">" + 
                         "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
                           "<cts:text>Memex</cts:text>" +
                           "</cts:word-query>" + 
                         "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
                           "<cts:text>inprice:.12</cts:text>" +
                         "</cts:word-query>" + 
                       "</cts:or-query>";
      
    StringHandle handle = new StringHandle().with(wordQuery);
    RawCtsQueryDefinition querydef = queryMgr.newRawCtsQueryDefinition(handle, queryOptionName);
    
    // create result handle
    JacksonHandle resultsHandle = new JacksonHandle();
    queryMgr.search(querydef, resultsHandle);

    // get the result
    JsonNode result = resultsHandle.get();
    String uri1 = result.path("results").get(0).path("uri").asText().trim();
    String uri2 = result.path("results").get(1).path("uri").asText().trim();
    
    assertTrue("Search results total incorrect", result.path("total").asInt() == 2);
    assertTrue("URI returned incorrect", uri1.contains("/word-constraint/constraint5.xml") || uri1.contains("/word-constraint/constraint2.xml"));
    assertTrue("URI returned incorrect", uri2.contains("/word-constraint/constraint5.xml") || uri2.contains("/word-constraint/constraint2.xml"));
    assertTrue("Content from search result 1 returned incorrect", result.path("results").get(0).path("content").asText().trim().contains("<title>The memex</title>"));
    assertTrue("Content from search result 2 returned incorrect", result.path("results").get(1).path("content").asText().trim().contains("price amt=\"0.12\""));
    String report = result.path("report").asText();    
    System.out.println("Report " + report);
    assertTrue("Report does not have CTS query", report.contains("cts:or-query((cts:word-query(\"Memex\", (\"lang=en\"), 1), cts:word-query(\"inprice:.12\", (\"lang=en\"), 1))"));
  }
  
  /*
   * Verify As method with cts-query being in JSON format and read from String
   */
  @Test
  public void testRawCtsWordQueryAsWithJSONFormat() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException, TransformerException
  {
    System.out.println("Running testRawCtsWordQueryAsWithJSONFormat");

    String[] filenames = { "constraint1.xml", "constraint2.xml", "constraint3.xml", "constraint4.xml", "constraint5.xml" };

    // set query option validation to true
    ServerConfigurationManager srvMgr = client.newServerConfigManager();
    srvMgr.readConfiguration();
    srvMgr.setQueryOptionValidation(true);
    srvMgr.writeConfiguration();

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/json-query/", "XML");
    }

    QueryManager queryMgr = client.newQueryManager();

    // create a search definition in JSON
    String wordQuery = "{" +
                         "\"query\": {" +
                           "\"queries\": [{" +
                             "\"term-query\": {" +
                               "\"text\": [ \"groundbreaking\", \"intellectual\" ]" +
                             "}" +
                           "}]" +
                         "}}";
    
    RawCtsQueryDefinition querydef = queryMgr.newRawCtsQueryDefinitionAs(Format.JSON, wordQuery);
    
     // create result handle
    JacksonHandle resultsHandle = new JacksonHandle();
    queryMgr.search(querydef, resultsHandle);

    // get the result
    JsonNode result = resultsHandle.get();
    assertTrue("Search results total incorrect", result.path("total").asInt() == 2);
    
    String uri1 = result.path("results").get(0).path("uri").asText().trim();
    String uri2 = result.path("results").get(1).path("uri").asText().trim();
    
    JsonNode highlightNode1 = result.path("results").get(0).path("matches").get(0).path("match-text");
    String txt1 = highlightNode1.get(0).toString().trim();
    assertTrue("Highlight text 1 returned incorrect", highlightNode1.toString().contains("groundbreaking"));
    assertTrue("Highlight text 1 returned incorrect", txt1.contains("For 1945, the thoughts expressed in The Atlantic Monthly were"));
    
    JsonNode highlightNode2 = result.path("results").get(1).path("matches").get(0).path("match-text");
    String txt2 = highlightNode2.get(0).toString().trim();
    assertTrue("Highlight text 2 returned incorrect", highlightNode2.toString().contains("intellectual"));
    assertTrue("Highlight text 2 returned incorrect", txt2.contains("Vannevar served as a prominent policymaker and public"));
   
    assertTrue("URI returned incorrect", uri1.contains("/json-query/constraint3.xml") || uri1.contains("/json-query/constraint4.xml"));
    assertTrue("URI returned incorrect", uri2.contains("/json-query/constraint3.xml") || uri2.contains("/json-query/constraint4.xml"));
  }
  
  /*
   * Verify that RawCtsQueryDefinition can set and get handles with diff queries. 
   */
  
  @Test
  public void testRawCtsSetGetHandle() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException, TransformerException
  {
    System.out.println("Running testRawCtsSetGetHandle");

    String[] filenames = { "constraint1.xml", "constraint2.xml", "constraint3.xml", "constraint4.xml", "constraint5.xml" };

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/setget/", "XML");
    }

    QueryManager queryMgr = client.newQueryManager();

    // create a search definition
    String wordQuery = "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
                       "<cts:text>groundbreaking</cts:text></cts:word-query>";
    StringHandle handle = new StringHandle().with(wordQuery);
    RawCtsQueryDefinition querydef = queryMgr.newRawCtsQueryDefinition(handle).withCriteria("Memex");
   
    // create a search definition in JSON
    String wordQuery2 = "{" +
                         "\"query\": {" +
                           "\"queries\": [{" +
                             "\"term-query\": {" +
                               "\"text\": [ \"groundbreaking\", \"intellectual\" ]" +
                             "}" +
                           "}]" +
                         "}}";
        
    CtsQueryWriteHandle hdl = querydef.getHandle();
    String hdlStr = hdl.toString().trim();
    assertTrue("Get Handle incorrect", hdlStr.contains(wordQuery));
     // create result handle
    JacksonHandle resultsHandle = new JacksonHandle();
    queryMgr.search(querydef, resultsHandle);
    
    StringHandle handle2 = new StringHandle(wordQuery2);
    querydef.setHandle(handle2.withFormat(Format.JSON));
    CtsQueryWriteHandle hd2 = querydef.getHandle();
    String hdlStr2 = hd2.toString().trim();
    assertTrue("Get Handle incorrect", hdlStr2.contains(wordQuery2));
    
    // create result handle
    JacksonHandle resultsHandle2 = new JacksonHandle();
    queryMgr.search(querydef, resultsHandle2);

    // get the result - Should be 0.
    JsonNode result2 = resultsHandle2.get();
    assertTrue("Search results total incorrect", result2.path("total").asInt() == 0);
    
    JacksonHandle jacksonHandle2 = new JacksonHandle();
    RawCtsQueryDefinition querydef2 = queryMgr.newRawCtsQueryDefinition(handle);
    querydef2.setHandle(handle2.withFormat(Format.JSON));
    queryMgr.search(querydef2, jacksonHandle2);
    
    result2 = jacksonHandle2.get();
    JsonNode highlightNode1 = result2.path("results").get(0).path("matches").get(0).path("match-text");
    String txt1 = highlightNode1.get(0).toString().trim();
    assertTrue("Highlight text 1 returned incorrect", highlightNode1.toString().contains("groundbreaking"));
    assertTrue("Highlight text 1 returned incorrect", txt1.contains("For 1945, the thoughts expressed in The Atlantic Monthly were"));
    
    JsonNode highlightNode2 = result2.path("results").get(1).path("matches").get(0).path("match-text");
    String txt2 = highlightNode2.get(0).toString().trim();
    assertTrue("Highlight text 2 returned incorrect", highlightNode2.toString().contains("intellectual"));
    assertTrue("Highlight text 2 returned incorrect", txt2.contains("Vannevar served as a prominent policymaker and public"));
  }
  
  @Test
  public void testValuesWithRawCtsQueryDefinition() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException,
      TransformerException
  {
    System.out.println("Running testValuesWithRawCtsQueryDefinition");

    String[] filenames = { "aggr1.xml", "aggr2.xml", "aggr3.xml", "aggr4.xml" };
    String queryOptionName = "aggregatesOpt5Occ.xml";

    DatabaseClient client = getDatabaseClient("rest-admin", "x", getConnType());

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/raw-cts-query/", "XML");
    }

    setQueryOption(client, queryOptionName);
    QueryManager queryMgr = client.newQueryManager();

    // create ValuesDefinition def
    ValuesDefinition valuesDef = queryMgr.newValuesDefinition("title-val", "aggregatesOpt5Occ.xml");
    // create a search definition
    String wordQuery = "<cts:or-query xmlns:cts=\"http://marklogic.com/cts\">" + 
            "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
            "<cts:text>Bush</cts:text>" +
            "</cts:word-query>" + 
            "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
            "<cts:text>1945</cts:text>" +
            "</cts:word-query>" + 
            "</cts:or-query>";
     StringHandle handle = new StringHandle().with(wordQuery).withFormat(Format.XML);
    // create query def
    RawCtsQueryDefinition queryRawDef = queryMgr.newRawCtsQueryDefinition(handle);
    valuesDef.setQueryDefinition(queryRawDef);
   
   // create handle
    ValuesHandle vHandle = queryMgr.values(valuesDef, new ValuesHandle());
    CountedDistinctValue distinctValues[] = vHandle.getValues();
    ArrayList<String> arr = new ArrayList<String>();
    arr.add(distinctValues[0].get("value", String.class));
    arr.add(distinctValues[1].get("value", String.class));
    arr.add(distinctValues[2].get("value", String.class));
    arr.sort(null);
    
    System.out.println("ValuesHandle name is " + vHandle.getName().toString());
    System.out.println("ValuesHandle length is " + vHandle.getValues().length);
    assertTrue("ValuesHandle name is incorrect", vHandle.getName().toString().trim().contains("title-val"));
    assertEquals("ValuesHandle length is incorrect", 3, vHandle.getValues().length);
    assertTrue("ValuesHandle element 1 is incorrect", arr.get(0).contains("For 1945"));
    assertTrue("ValuesHandle element 2 is incorrect", arr.get(1).contains("The Bush article"));
    assertTrue("ValuesHandle element 3 is incorrect", arr.get(2).contains("Vannevar Bush"));
    // release client
    client.release();
  }
  
  @Test
  public void testValuesWithRawCtsQueryCombinedDefinition() throws KeyManagementException, NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException, XpathException,
      TransformerException
  {
    System.out.println("Running testValuesWithRawCtsQueryCombinedDefinition");

    String[] filenames = { "aggr1.xml", "aggr2.xml", "aggr3.xml", "aggr4.xml" };
    DatabaseClient client = getDatabaseClient("rest-admin", "x", getConnType());

    // write docs
    for (String filename : filenames) {
      writeDocumentUsingInputStreamHandle(client, filename, "/rew-cts-combined-query/", "XML");
    }

    QueryManager queryMgr = client.newQueryManager();
    // create a search definition
    String options = "<options xmlns=\"http://marklogic.com/appservices/search\">" +
            "<values name=\"Combined-title-val\">" +
            "<range type=\"xs:string\">" +
            "<element ns=\"\" name=\"title\"/>" +
            "</range>" +
            "</values>" +
            "</options>";
    
    String wordQuery = "<search:search xmlns:search=\"http://marklogic.com/appservices/search\">" +
            "<cts:or-query xmlns:cts=\"http://marklogic.com/cts\">" + 
            "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
            "<cts:text>Bush</cts:text>" +
            "</cts:word-query>" + 
            "<cts:word-query xmlns:cts=\"http://marklogic.com/cts\">" +
            "<cts:text>1945</cts:text>" +
            "</cts:word-query>" + 
            "</cts:or-query>" +
            options +
            "</search:search>";
     StringHandle handle = new StringHandle().with(wordQuery).withFormat(Format.XML);
    // create query def
    RawCtsQueryDefinition queryRawDef = queryMgr.newRawCtsQueryDefinition(handle);
    // create ValuesDefinition def
    ValuesDefinition valuesDef = queryMgr.newValuesDefinition("Combined-title-val");
    valuesDef.setQueryDefinition(queryRawDef);
   
   // create handle
    ValuesHandle vHandle = queryMgr.values(valuesDef, new ValuesHandle());
    CountedDistinctValue distinctValues[] = vHandle.getValues();
    ArrayList<String> arr = new ArrayList<String>();
    arr.add(distinctValues[0].get("value", String.class));
    arr.add(distinctValues[1].get("value", String.class));
    arr.add(distinctValues[2].get("value", String.class));
    arr.sort(null);
    
    System.out.println("ValuesHandle name is " + vHandle.getName().toString());
    System.out.println("ValuesHandle length is " + vHandle.getValues().length);
    assertTrue("ValuesHandle name is incorrect", vHandle.getName().toString().trim().contains("Combined-title-val"));
    assertEquals("ValuesHandle length is incorrect", 3, vHandle.getValues().length);
    assertTrue("ValuesHandle element 1 is incorrect", arr.get(0).contains("For 1945"));
    assertTrue("ValuesHandle element 2 is incorrect", arr.get(1).contains("The Bush article"));
    assertTrue("ValuesHandle element 3 is incorrect", arr.get(2).contains("Vannevar Bush"));
    // release client
    client.release();
  }
  
  @AfterClass
  public static void tearDown() throws Exception
  {
    System.out.println("In tear down");
    client.release();
    cleanupRESTServer(dbName, fNames);
  }
}
