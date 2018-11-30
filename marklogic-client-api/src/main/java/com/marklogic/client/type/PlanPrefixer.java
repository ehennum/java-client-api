/*
 * Copyright 2017-2018 MarkLogic Corporation
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
package com.marklogic.client.type;

//IMPORTANT: Do not edit. This file is generated.

/**
 * An instance of a convenience that can prepend a base URL
 * when creating iteral semantic IRI values for use in triple
 * patterns for a row pipeline.
 */
public interface PlanPrefixer extends PlanPrefixerSeq {
    public SemIriVal iri(String name);
    public SemIriVal iri(XsStringVal name);
}
