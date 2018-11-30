/*
 * Copyright 2016-2018 MarkLogic Corporation
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
package com.marklogic.client.impl;

import com.marklogic.client.type.CtsQueryExpr;
import com.marklogic.client.type.ItemSeqExpr;
import com.marklogic.client.type.XsAnyAtomicTypeExpr;
import com.marklogic.client.type.XsAnyAtomicTypeVal;
import com.marklogic.client.type.XsBooleanExpr;
import com.marklogic.client.type.XsBooleanVal;
import com.marklogic.client.type.XsDateTimeExpr;
import com.marklogic.client.type.XsDateTimeVal;
import com.marklogic.client.type.XsDoubleExpr;
import com.marklogic.client.type.XsDoubleVal;
import com.marklogic.client.type.XsQNameExpr;
import com.marklogic.client.type.XsQNameVal;
import com.marklogic.client.type.XsStringExpr;
import com.marklogic.client.type.XsStringSeqExpr;
import com.marklogic.client.type.XsStringSeqVal;
import com.marklogic.client.type.XsStringVal;

import com.marklogic.client.type.ServerExpression;
import com.marklogic.client.type.SemBlankExpr;
import com.marklogic.client.type.SemBlankSeqExpr;
import com.marklogic.client.type.SemInvalidExpr;
import com.marklogic.client.type.SemInvalidSeqExpr;
import com.marklogic.client.type.SemIriExpr;
import com.marklogic.client.type.SemIriSeqExpr;
import com.marklogic.client.type.SemStoreExpr;
import com.marklogic.client.type.SemStoreSeqExpr;
import com.marklogic.client.type.SemUnknownExpr;
import com.marklogic.client.type.SemUnknownSeqExpr;

import com.marklogic.client.expression.SemExpr;
import com.marklogic.client.impl.BaseTypeImpl;

// IMPORTANT: Do not edit. This file is generated.
class SemExprImpl extends SemValueImpl implements SemExpr {

  final static XsExprImpl xs = XsExprImpl.xs;

  final static SemExprImpl sem = new SemExprImpl();

  SemExprImpl() {
  }

    
  @Override
  public SemBlankExpr bnode() {
    return new BlankCallImpl("sem", "bnode", new Object[]{  });
  }

  
  @Override
  public SemBlankExpr bnode(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for bnode() cannot be null");
    }
    return new BlankCallImpl("sem", "bnode", new Object[]{ value });
  }

  
  @Override
  public ItemSeqExpr coalesce(ServerExpression... parameter1) {
    return new BaseTypeImpl.ItemSeqCallImpl("sem", "coalesce", parameter1);
  }

  
  @Override
  public SemIriExpr datatype(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for datatype() cannot be null");
    }
    return new IriCallImpl("sem", "datatype", new Object[]{ value });
  }

  
  @Override
  public ItemSeqExpr ifExpr(ServerExpression condition, ServerExpression then, ServerExpression elseExpr) {
    if (condition == null) {
      throw new IllegalArgumentException("condition parameter for ifExpr() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("sem", "if", new Object[]{ condition, then, elseExpr });
  }

  
  @Override
  public SemInvalidExpr invalid(ServerExpression string, String datatype) {
    return invalid(string, (datatype == null) ? (SemIriExpr) null : iri(datatype));
  }

  
  @Override
  public SemInvalidExpr invalid(ServerExpression string, ServerExpression datatype) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for invalid() cannot be null");
    }
    if (datatype == null) {
      throw new IllegalArgumentException("datatype parameter for invalid() cannot be null");
    }
    return new InvalidCallImpl("sem", "invalid", new Object[]{ string, datatype });
  }

  
  @Override
  public SemIriExpr invalidDatatype(ServerExpression val) {
    if (val == null) {
      throw new IllegalArgumentException("val parameter for invalidDatatype() cannot be null");
    }
    return new IriCallImpl("sem", "invalid-datatype", new Object[]{ val });
  }

  
  @Override
  public SemIriExpr iri(ServerExpression stringIri) {
    return new IriCallImpl("sem", "iri", new Object[]{ stringIri });
  }

  
  @Override
  public XsQNameExpr iriToQName(ServerExpression arg1) {
    if (arg1 == null) {
      throw new IllegalArgumentException("arg1 parameter for iriToQName() cannot be null");
    }
    return new XsExprImpl.QNameCallImpl("sem", "iri-to-QName", new Object[]{ arg1 });
  }

  
  @Override
  public XsBooleanExpr isBlank(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for isBlank() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "isBlank", new Object[]{ value });
  }

  
  @Override
  public XsBooleanExpr isIRI(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for isIRI() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "isIRI", new Object[]{ value });
  }

  
  @Override
  public XsBooleanExpr isLiteral(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for isLiteral() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "isLiteral", new Object[]{ value });
  }

  
  @Override
  public XsBooleanExpr isNumeric(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for isNumeric() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "isNumeric", new Object[]{ value });
  }

  
  @Override
  public XsStringExpr lang(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for lang() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sem", "lang", new Object[]{ value });
  }

  
  @Override
  public XsBooleanExpr langMatches(ServerExpression langTag, String langRange) {
    return langMatches(langTag, (langRange == null) ? (XsStringExpr) null : xs.string(langRange));
  }

  
  @Override
  public XsBooleanExpr langMatches(ServerExpression langTag, ServerExpression langRange) {
    if (langTag == null) {
      throw new IllegalArgumentException("langTag parameter for langMatches() cannot be null");
    }
    if (langRange == null) {
      throw new IllegalArgumentException("langRange parameter for langMatches() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "langMatches", new Object[]{ langTag, langRange });
  }

  
  @Override
  public SemIriExpr QNameToIri(ServerExpression arg1) {
    if (arg1 == null) {
      throw new IllegalArgumentException("arg1 parameter for QNameToIri() cannot be null");
    }
    return new IriCallImpl("sem", "QName-to-iri", new Object[]{ arg1 });
  }

  
  @Override
  public XsDoubleExpr random() {
    return new XsExprImpl.DoubleCallImpl("sem", "random", new Object[]{  });
  }

  
  @Override
  public SemStoreExpr rulesetStore(String locations) {
    return rulesetStore((locations == null) ? (XsStringVal) null : xs.string(locations));
  }

  
  @Override
  public SemStoreExpr rulesetStore(XsStringSeqVal locations) {
    return new StoreCallImpl("sem", "ruleset-store", new Object[]{ locations });
  }

  
  @Override
  public SemStoreExpr rulesetStore(String locations, SemStoreExpr... store) {
    return rulesetStore((locations == null) ? (XsStringVal) null : xs.string(locations), new StoreSeqListImpl(store));
  }

  
  @Override
  public SemStoreExpr rulesetStore(XsStringSeqVal locations, SemStoreSeqExpr store) {
    return new StoreCallImpl("sem", "ruleset-store", new Object[]{ locations, store });
  }

  
  @Override
  public SemStoreExpr rulesetStore(String locations, SemStoreSeqExpr store, String options) {
    return rulesetStore((locations == null) ? (XsStringVal) null : xs.string(locations), store, (options == null) ? (XsStringVal) null : xs.string(options));
  }

  
  @Override
  public SemStoreExpr rulesetStore(XsStringSeqVal locations, SemStoreSeqExpr store, XsStringSeqVal options) {
    return new StoreCallImpl("sem", "ruleset-store", new Object[]{ locations, store, options });
  }

  
  @Override
  public XsBooleanExpr sameTerm(ServerExpression a, String b) {
    return sameTerm(a, (b == null) ? (XsAnyAtomicTypeExpr) null : xs.string(b));
  }

  
  @Override
  public XsBooleanExpr sameTerm(ServerExpression a, ServerExpression b) {
    if (a == null) {
      throw new IllegalArgumentException("a parameter for sameTerm() cannot be null");
    }
    if (b == null) {
      throw new IllegalArgumentException("b parameter for sameTerm() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("sem", "sameTerm", new Object[]{ a, b });
  }

  
  @Override
  public SemStoreExpr store() {
    return new StoreCallImpl("sem", "store", new Object[]{  });
  }

  
  @Override
  public SemStoreExpr store(String options) {
    return store((options == null) ? (XsStringVal) null : xs.string(options));
  }

  
  @Override
  public SemStoreExpr store(XsStringSeqVal options) {
    return new StoreCallImpl("sem", "store", new Object[]{ options });
  }

  
  @Override
  public SemStoreExpr store(String options, CtsQueryExpr query) {
    return store((options == null) ? (XsStringVal) null : xs.string(options), query);
  }

  
  @Override
  public SemStoreExpr store(XsStringSeqVal options, CtsQueryExpr query) {
    return new StoreCallImpl("sem", "store", new Object[]{ options, query });
  }

  
  @Override
  public XsStringExpr timezoneString(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for timezoneString() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sem", "timezone-string", new Object[]{ value });
  }

  
  @Override
  public XsAnyAtomicTypeExpr typedLiteral(ServerExpression value, String datatype) {
    return typedLiteral(value, (datatype == null) ? (SemIriExpr) null : iri(datatype));
  }

  
  @Override
  public XsAnyAtomicTypeExpr typedLiteral(ServerExpression value, ServerExpression datatype) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for typedLiteral() cannot be null");
    }
    if (datatype == null) {
      throw new IllegalArgumentException("datatype parameter for typedLiteral() cannot be null");
    }
    return new XsExprImpl.AnyAtomicTypeCallImpl("sem", "typed-literal", new Object[]{ value, datatype });
  }

  
  @Override
  public SemUnknownExpr unknown(ServerExpression string, String datatype) {
    return unknown(string, (datatype == null) ? (SemIriExpr) null : iri(datatype));
  }

  
  @Override
  public SemUnknownExpr unknown(ServerExpression string, ServerExpression datatype) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for unknown() cannot be null");
    }
    if (datatype == null) {
      throw new IllegalArgumentException("datatype parameter for unknown() cannot be null");
    }
    return new UnknownCallImpl("sem", "unknown", new Object[]{ string, datatype });
  }

  
  @Override
  public SemIriExpr unknownDatatype(ServerExpression val) {
    if (val == null) {
      throw new IllegalArgumentException("val parameter for unknownDatatype() cannot be null");
    }
    return new IriCallImpl("sem", "unknown-datatype", new Object[]{ val });
  }

  
  @Override
  public SemIriExpr uuid() {
    return new IriCallImpl("sem", "uuid", new Object[]{  });
  }

  
  @Override
  public XsStringExpr uuidString() {
    return new XsExprImpl.StringCallImpl("sem", "uuid-string", new Object[]{  });
  }

  @Override
  public SemBlankSeqExpr blankSeq(SemBlankExpr... items) {
    return new BlankSeqListImpl(items);
  }
  static class BlankSeqListImpl extends BaseTypeImpl.ServerExpressionListImpl implements SemBlankSeqExpr {
    BlankSeqListImpl(Object[] items) {
      super(items);
    }
  }
  static class BlankSeqCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemBlankSeqExpr {
    BlankSeqCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
  static class BlankCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemBlankExpr {
    BlankCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
 
  @Override
  public SemInvalidSeqExpr invalidSeq(SemInvalidExpr... items) {
    return new InvalidSeqListImpl(items);
  }
  static class InvalidSeqListImpl extends BaseTypeImpl.ServerExpressionListImpl implements SemInvalidSeqExpr {
    InvalidSeqListImpl(Object[] items) {
      super(items);
    }
  }
  static class InvalidSeqCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemInvalidSeqExpr {
    InvalidSeqCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
  static class InvalidCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemInvalidExpr {
    InvalidCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
 
  @Override
  public SemIriSeqExpr iriSeq(SemIriExpr... items) {
    return new IriSeqListImpl(items);
  }
  static class IriSeqListImpl extends BaseTypeImpl.ServerExpressionListImpl implements SemIriSeqExpr {
    IriSeqListImpl(Object[] items) {
      super(items);
    }
  }
  static class IriSeqCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemIriSeqExpr {
    IriSeqCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
  static class IriCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemIriExpr {
    IriCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
 
  @Override
  public SemStoreSeqExpr storeSeq(SemStoreExpr... items) {
    return new StoreSeqListImpl(items);
  }
  static class StoreSeqListImpl extends BaseTypeImpl.ServerExpressionListImpl implements SemStoreSeqExpr {
    StoreSeqListImpl(Object[] items) {
      super(items);
    }
  }
  static class StoreSeqCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemStoreSeqExpr {
    StoreSeqCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
  static class StoreCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemStoreExpr {
    StoreCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
 
  @Override
  public SemUnknownSeqExpr unknownSeq(SemUnknownExpr... items) {
    return new UnknownSeqListImpl(items);
  }
  static class UnknownSeqListImpl extends BaseTypeImpl.ServerExpressionListImpl implements SemUnknownSeqExpr {
    UnknownSeqListImpl(Object[] items) {
      super(items);
    }
  }
  static class UnknownSeqCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemUnknownSeqExpr {
    UnknownSeqCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }
  static class UnknownCallImpl extends BaseTypeImpl.ServerExpressionCallImpl implements SemUnknownExpr {
    UnknownCallImpl(String fnPrefix, String fnName, Object[] fnArgs) {
      super(fnPrefix, fnName, fnArgs);
    }
  }

  }
