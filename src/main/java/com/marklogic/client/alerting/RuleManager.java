/*
 * Copyright 2013 MarkLogic Corporation
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
package com.marklogic.client.alerting;

import com.marklogic.client.FailedRequestException;
import com.marklogic.client.ForbiddenUserException;
import com.marklogic.client.ResourceNotFoundException;
import com.marklogic.client.io.marker.RuleReadHandle;
import com.marklogic.client.io.marker.RuleWriteHandle;
import com.marklogic.client.io.marker.StructureWriteHandle;
import com.marklogic.client.query.QueryDefinition;

/**
 * Manages CRUD of rules for the REST API alerting capability, as well as match
 * operations against installed rules.
 */
public interface RuleManager {

	/**
	 * Tests for existence of rule on the REST server.
	 * 
	 * @param ruleName
	 *            Name of the rule
	 * @return true if rule exists, false otherwise.
	 */
	public boolean exists(String ruleName);

	/**
	 * Reads a rule from the server into the provided handle.
	 * 
	 * @param ruleName
	 *            Name of rule on REST server.
	 * @param readHandle
	 *            Handle that will accept the rule payload. Often will be an
	 *            instance of RuleDefinition.
	 * @return Handle or object that models the rule.
	 */
	public <T extends RuleReadHandle> T readRule(String ruleName, T readHandle)
			throws ResourceNotFoundException, ForbiddenUserException,
			FailedRequestException;

	/**
	 * Writes a rule to the server from the provided handle.
	 * 
	 * @param readHandle
	 *            Handle that contains the rule payload. Must be a
	 *            RuleDefinition object to use this method, which
	 *            has no ruleName.
	 */
	public void writeRule(RuleDefinition writeHandle)
			throws ResourceNotFoundException, ForbiddenUserException,
			FailedRequestException;
	
	/**
	 * Writes a rule to the server from the provided handle.
	 * 
	 * @param ruleName
	 *            Name of rule on REST server.
	 * @param readHandle
	 *            Handle that contains the rule payload. Often will be an
	 *            instance of RuleDefinition.
     */	
	public void writeRule(String string, RuleWriteHandle ruleHandle);

	/**
	 * Removes a rule from the server.
	 * 
	 * @param ruleName
	 *            Name of rule on REST server.
	 */
	public void delete(String ruleName) throws ForbiddenUserException,
			FailedRequestException;

	/**
	 * Matches server rules based on the results of a search.
	 * @param docQuery A query definition to qualify documents to match
	 * @return The List of rules matched by the documents returned by this query.
	 */
	public RuleDefinitionList match(QueryDefinition docQuery);

	/**
	 * Matches server rules based on results of a search, with pagination applied to search.
	 * Use this method to match, say, a page or search results against rules.
	 * @param docQuery A query definition to qualify documents to match
	 * @param start The start position in query results to match.
	 * @param candidateRules
	 * @return The list of rules matched by the documents returned by the query.
	 */
	public RuleDefinitionList match(QueryDefinition docQuery,
			long start, String[] candidateRules);

	/**
	 * Matches server rules based on an array of document IDS
	 * @param docIds An array of document IDs to match against.
	 * @return The union of all rules matched by the document ids provided.
	 */
	public RuleDefinitionList match(String[] docIds);

	/**
	 * Matches server rules based on an array of document IDs and an array of rule names
	 * @param docIds An array of document IDs to match against.
	 * @param candidateRules An array of rule names to match
	 * @return The union of rules in candidateRules matched by the document ids provided.
	 */
	public RuleDefinitionList match(String[] docIds, String[] candidateRules);

	/**
	 * Matches server rules based on a document supplied in a write handle.
	 * @param document A document payload to match against rules.
	 * @return The union of rules in candidateRules matched by the document ids provided.
	 */
	public RuleDefinitionList match(StructureWriteHandle document);

	/**
	 * Matches server rules based on a document supplied in a write handle.
	 * @param document A document payload to match against rules.
	 * @param candidateRules An array of rule names to match
	 * @return The union of rules in candidateRules matched by the document.
	 */
	public RuleDefinitionList match(StructureWriteHandle document,
			String[] candidateRules);

	

}