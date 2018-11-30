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

import com.marklogic.client.type.ElementNodeExpr;
import com.marklogic.client.type.ItemExpr;
import com.marklogic.client.type.ItemSeqExpr;
import com.marklogic.client.type.NodeExpr;
import com.marklogic.client.type.XsAnyAtomicTypeExpr;
import com.marklogic.client.type.XsAnyAtomicTypeSeqExpr;
import com.marklogic.client.type.XsAnyURIExpr;
import com.marklogic.client.type.XsBooleanExpr;
import com.marklogic.client.type.XsDateExpr;
import com.marklogic.client.type.XsDateTimeExpr;
import com.marklogic.client.type.XsDayTimeDurationExpr;
import com.marklogic.client.type.XsDecimalExpr;
import com.marklogic.client.type.XsDoubleExpr;
import com.marklogic.client.type.XsDurationExpr;
import com.marklogic.client.type.XsIntegerExpr;
import com.marklogic.client.type.XsIntegerSeqExpr;
import com.marklogic.client.type.XsNCNameExpr;
import com.marklogic.client.type.XsNumericExpr;
import com.marklogic.client.type.XsNumericSeqExpr;
import com.marklogic.client.type.XsQNameExpr;
import com.marklogic.client.type.XsStringExpr;
import com.marklogic.client.type.XsStringSeqExpr;
import com.marklogic.client.type.XsTimeExpr;

import com.marklogic.client.type.ServerExpression;

import com.marklogic.client.expression.FnExpr;
import com.marklogic.client.impl.BaseTypeImpl;

// IMPORTANT: Do not edit. This file is generated.
class FnExprImpl implements FnExpr {

  final static XsExprImpl xs = XsExprImpl.xs;

  final static FnExprImpl fn = new FnExprImpl();

  FnExprImpl() {
  }

    
  @Override
  public XsNumericExpr abs(ServerExpression arg) {
    return new XsExprImpl.NumericCallImpl("fn", "abs", new Object[]{ arg });
  }

  
  @Override
  public XsDateExpr adjustDateToTimezone(ServerExpression arg) {
    return new XsExprImpl.DateCallImpl("fn", "adjust-date-to-timezone", new Object[]{ arg });
  }

  
  @Override
  public XsDateExpr adjustDateToTimezone(ServerExpression arg, String timezone) {
    return adjustDateToTimezone(arg, (timezone == null) ? (XsDayTimeDurationExpr) null : xs.dayTimeDuration(timezone));
  }

  
  @Override
  public XsDateExpr adjustDateToTimezone(ServerExpression arg, ServerExpression timezone) {
    return new XsExprImpl.DateCallImpl("fn", "adjust-date-to-timezone", new Object[]{ arg, timezone });
  }

  
  @Override
  public XsDateTimeExpr adjustDateTimeToTimezone(ServerExpression arg) {
    return new XsExprImpl.DateTimeCallImpl("fn", "adjust-dateTime-to-timezone", new Object[]{ arg });
  }

  
  @Override
  public XsDateTimeExpr adjustDateTimeToTimezone(ServerExpression arg, String timezone) {
    return adjustDateTimeToTimezone(arg, (timezone == null) ? (XsDayTimeDurationExpr) null : xs.dayTimeDuration(timezone));
  }

  
  @Override
  public XsDateTimeExpr adjustDateTimeToTimezone(ServerExpression arg, ServerExpression timezone) {
    return new XsExprImpl.DateTimeCallImpl("fn", "adjust-dateTime-to-timezone", new Object[]{ arg, timezone });
  }

  
  @Override
  public XsTimeExpr adjustTimeToTimezone(ServerExpression arg) {
    return new XsExprImpl.TimeCallImpl("fn", "adjust-time-to-timezone", new Object[]{ arg });
  }

  
  @Override
  public XsTimeExpr adjustTimeToTimezone(ServerExpression arg, String timezone) {
    return adjustTimeToTimezone(arg, (timezone == null) ? (XsDayTimeDurationExpr) null : xs.dayTimeDuration(timezone));
  }

  
  @Override
  public XsTimeExpr adjustTimeToTimezone(ServerExpression arg, ServerExpression timezone) {
    return new XsExprImpl.TimeCallImpl("fn", "adjust-time-to-timezone", new Object[]{ arg, timezone });
  }

  
  @Override
  public ElementNodeExpr analyzeString(String in, String regex) {
    return analyzeString((in == null) ? (XsStringExpr) null : xs.string(in), (regex == null) ? (XsStringExpr) null : xs.string(regex));
  }

  
  @Override
  public ElementNodeExpr analyzeString(ServerExpression in, ServerExpression regex) {
    if (regex == null) {
      throw new IllegalArgumentException("regex parameter for analyzeString() cannot be null");
    }
    return new BaseTypeImpl.ElementNodeCallImpl("fn", "analyze-string", new Object[]{ in, regex });
  }

  
  @Override
  public ElementNodeExpr analyzeString(String in, String regex, String flags) {
    return analyzeString((in == null) ? (XsStringExpr) null : xs.string(in), (regex == null) ? (XsStringExpr) null : xs.string(regex), (flags == null) ? (XsStringExpr) null : xs.string(flags));
  }

  
  @Override
  public ElementNodeExpr analyzeString(ServerExpression in, ServerExpression regex, ServerExpression flags) {
    if (regex == null) {
      throw new IllegalArgumentException("regex parameter for analyzeString() cannot be null");
    }
    if (flags == null) {
      throw new IllegalArgumentException("flags parameter for analyzeString() cannot be null");
    }
    return new BaseTypeImpl.ElementNodeCallImpl("fn", "analyze-string", new Object[]{ in, regex, flags });
  }

  
  @Override
  public XsAnyAtomicTypeExpr avg(ServerExpression arg) {
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "avg", new Object[]{ arg });
  }

  
  @Override
  public XsAnyURIExpr baseUri(ServerExpression arg) {
    return new XsExprImpl.AnyURICallImpl("fn", "base-uri", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr booleanExpr(ServerExpression arg) {
    return new XsExprImpl.BooleanCallImpl("fn", "boolean", new Object[]{ arg });
  }

  
  @Override
  public XsNumericExpr ceiling(ServerExpression arg) {
    return new XsExprImpl.NumericCallImpl("fn", "ceiling", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr codepointEqual(ServerExpression comparand1, String comparand2) {
    return codepointEqual(comparand1, (comparand2 == null) ? (XsStringExpr) null : xs.string(comparand2));
  }

  
  @Override
  public XsBooleanExpr codepointEqual(ServerExpression comparand1, ServerExpression comparand2) {
    return new XsExprImpl.BooleanCallImpl("fn", "codepoint-equal", new Object[]{ comparand1, comparand2 });
  }

  
  @Override
  public XsStringExpr codepointsToString(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("fn", "codepoints-to-string", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr compare(ServerExpression comparand1, String comparand2) {
    return compare(comparand1, (comparand2 == null) ? (XsStringExpr) null : xs.string(comparand2));
  }

  
  @Override
  public XsIntegerExpr compare(ServerExpression comparand1, ServerExpression comparand2) {
    return new XsExprImpl.IntegerCallImpl("fn", "compare", new Object[]{ comparand1, comparand2 });
  }

  
  @Override
  public XsIntegerExpr compare(ServerExpression comparand1, String comparand2, String collation) {
    return compare(comparand1, (comparand2 == null) ? (XsStringExpr) null : xs.string(comparand2), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsIntegerExpr compare(ServerExpression comparand1, ServerExpression comparand2, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for compare() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("fn", "compare", new Object[]{ comparand1, comparand2, collation });
  }

  
  @Override
  public XsStringExpr concat(ServerExpression... parameter1) {
    return new XsExprImpl.StringCallImpl("fn", "concat", parameter1);
  }

  
  @Override
  public XsBooleanExpr contains(ServerExpression parameter1, String parameter2) {
    return contains(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2));
  }

  
  @Override
  public XsBooleanExpr contains(ServerExpression parameter1, ServerExpression parameter2) {
    return new XsExprImpl.BooleanCallImpl("fn", "contains", new Object[]{ parameter1, parameter2 });
  }

  
  @Override
  public XsBooleanExpr contains(ServerExpression parameter1, String parameter2, String collation) {
    return contains(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsBooleanExpr contains(ServerExpression parameter1, ServerExpression parameter2, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for contains() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "contains", new Object[]{ parameter1, parameter2, collation });
  }

  
  @Override
  public XsIntegerExpr count(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "count", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr count(ServerExpression arg, double maximum) {
    return count(arg, xs.doubleVal(maximum));
  }

  
  @Override
  public XsIntegerExpr count(ServerExpression arg, ServerExpression maximum) {
    return new XsExprImpl.IntegerCallImpl("fn", "count", new Object[]{ arg, maximum });
  }

  
  @Override
  public XsDateExpr currentDate() {
    return new XsExprImpl.DateCallImpl("fn", "current-date", new Object[]{  });
  }

  
  @Override
  public XsDateTimeExpr currentDateTime() {
    return new XsExprImpl.DateTimeCallImpl("fn", "current-dateTime", new Object[]{  });
  }

  
  @Override
  public XsTimeExpr currentTime() {
    return new XsExprImpl.TimeCallImpl("fn", "current-time", new Object[]{  });
  }

  
  @Override
  public XsIntegerExpr dayFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "day-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr dayFromDateTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "day-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr daysFromDuration(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "days-from-duration", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr deepEqual(ServerExpression parameter1, ServerExpression parameter2) {
    return new XsExprImpl.BooleanCallImpl("fn", "deep-equal", new Object[]{ parameter1, parameter2 });
  }

  
  @Override
  public XsBooleanExpr deepEqual(ServerExpression parameter1, ServerExpression parameter2, String collation) {
    return deepEqual(parameter1, parameter2, (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsBooleanExpr deepEqual(ServerExpression parameter1, ServerExpression parameter2, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for deepEqual() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "deep-equal", new Object[]{ parameter1, parameter2, collation });
  }

  
  @Override
  public XsStringExpr defaultCollation() {
    return new XsExprImpl.StringCallImpl("fn", "default-collation", new Object[]{  });
  }

  
  @Override
  public XsAnyAtomicTypeSeqExpr distinctValues(ServerExpression arg) {
    return new XsExprImpl.AnyAtomicTypeSeqCallImpl("fn", "distinct-values", new Object[]{ arg });
  }

  
  @Override
  public XsAnyAtomicTypeSeqExpr distinctValues(ServerExpression arg, String collation) {
    return distinctValues(arg, (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsAnyAtomicTypeSeqExpr distinctValues(ServerExpression arg, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for distinctValues() cannot be null");
    }
    return new XsExprImpl.AnyAtomicTypeSeqCallImpl("fn", "distinct-values", new Object[]{ arg, collation });
  }

  
  @Override
  public XsAnyURIExpr documentUri(ServerExpression arg) {
    return new XsExprImpl.AnyURICallImpl("fn", "document-uri", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr empty(ServerExpression arg) {
    return new XsExprImpl.BooleanCallImpl("fn", "empty", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr encodeForUri(ServerExpression uriPart) {
    return new XsExprImpl.StringCallImpl("fn", "encode-for-uri", new Object[]{ uriPart });
  }

  
  @Override
  public XsBooleanExpr endsWith(ServerExpression parameter1, String parameter2) {
    return endsWith(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2));
  }

  
  @Override
  public XsBooleanExpr endsWith(ServerExpression parameter1, ServerExpression parameter2) {
    return new XsExprImpl.BooleanCallImpl("fn", "ends-with", new Object[]{ parameter1, parameter2 });
  }

  
  @Override
  public XsBooleanExpr endsWith(ServerExpression parameter1, String parameter2, String collation) {
    return endsWith(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsBooleanExpr endsWith(ServerExpression parameter1, ServerExpression parameter2, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for endsWith() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "ends-with", new Object[]{ parameter1, parameter2, collation });
  }

  
  @Override
  public XsStringExpr escapeHtmlUri(ServerExpression uriPart) {
    return new XsExprImpl.StringCallImpl("fn", "escape-html-uri", new Object[]{ uriPart });
  }

  
  @Override
  public XsBooleanExpr exists(ServerExpression arg) {
    return new XsExprImpl.BooleanCallImpl("fn", "exists", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr falseExpr() {
    return new XsExprImpl.BooleanCallImpl("fn", "false", new Object[]{  });
  }

  
  @Override
  public XsNumericExpr floor(ServerExpression arg) {
    return new XsExprImpl.NumericCallImpl("fn", "floor", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, String picture) {
    return formatDate(value, (picture == null) ? (XsStringExpr) null : xs.string(picture));
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, ServerExpression picture) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDate() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-date", new Object[]{ value, picture });
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, String picture, String language) {
    return formatDate(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, ServerExpression picture, ServerExpression language) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDate() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-date", new Object[]{ value, picture, language });
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, String picture, String language, String calendar) {
    return formatDate(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar));
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDate() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-date", new Object[]{ value, picture, language, calendar });
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, String picture, String language, String calendar, String country) {
    return formatDate(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar), (country == null) ? (XsStringExpr) null : xs.string(country));
  }

  
  @Override
  public XsStringExpr formatDate(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar, ServerExpression country) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDate() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-date", new Object[]{ value, picture, language, calendar, country });
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, String picture) {
    return formatDateTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture));
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, ServerExpression picture) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDateTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-dateTime", new Object[]{ value, picture });
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, String picture, String language) {
    return formatDateTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, ServerExpression picture, ServerExpression language) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDateTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-dateTime", new Object[]{ value, picture, language });
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, String picture, String language, String calendar) {
    return formatDateTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar));
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDateTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-dateTime", new Object[]{ value, picture, language, calendar });
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, String picture, String language, String calendar, String country) {
    return formatDateTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar), (country == null) ? (XsStringExpr) null : xs.string(country));
  }

  
  @Override
  public XsStringExpr formatDateTime(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar, ServerExpression country) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatDateTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-dateTime", new Object[]{ value, picture, language, calendar, country });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatNumber() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-number", new Object[]{ value, picture });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String decimalFormatName) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (decimalFormatName == null) ? (XsStringExpr) null : xs.string(decimalFormatName));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression decimalFormatName) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatNumber() cannot be null");
    }
    if (decimalFormatName == null) {
      throw new IllegalArgumentException("decimalFormatName parameter for formatNumber() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-number", new Object[]{ value, picture, decimalFormatName });
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, String picture) {
    return formatTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture));
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, ServerExpression picture) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-time", new Object[]{ value, picture });
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, String picture, String language) {
    return formatTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, ServerExpression picture, ServerExpression language) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-time", new Object[]{ value, picture, language });
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, String picture, String language, String calendar) {
    return formatTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar));
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-time", new Object[]{ value, picture, language, calendar });
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, String picture, String language, String calendar, String country) {
    return formatTime(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar), (country == null) ? (XsStringExpr) null : xs.string(country));
  }

  
  @Override
  public XsStringExpr formatTime(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression calendar, ServerExpression country) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for formatTime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "format-time", new Object[]{ value, picture, language, calendar, country });
  }

  
  @Override
  public XsStringExpr generateId(ServerExpression node) {
    return new XsExprImpl.StringCallImpl("fn", "generate-id", new Object[]{ node });
  }

  
  @Override
  public ItemExpr head(ServerExpression seq) {
    return new BaseTypeImpl.ItemCallImpl("fn", "head", new Object[]{ seq });
  }

  
  @Override
  public XsIntegerExpr hoursFromDateTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "hours-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr hoursFromDuration(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "hours-from-duration", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr hoursFromTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "hours-from-time", new Object[]{ arg });
  }

  
  @Override
  public XsDayTimeDurationExpr implicitTimezone() {
    return new XsExprImpl.DayTimeDurationCallImpl("fn", "implicit-timezone", new Object[]{  });
  }

  
  @Override
  public XsStringSeqExpr inScopePrefixes(ServerExpression element) {
    if (element == null) {
      throw new IllegalArgumentException("element parameter for inScopePrefixes() cannot be null");
    }
    return new XsExprImpl.StringSeqCallImpl("fn", "in-scope-prefixes", new Object[]{ element });
  }

  
  @Override
  public XsIntegerSeqExpr indexOf(ServerExpression seqParam, String srchParam) {
    return indexOf(seqParam, (srchParam == null) ? (XsAnyAtomicTypeExpr) null : xs.string(srchParam));
  }

  
  @Override
  public XsIntegerSeqExpr indexOf(ServerExpression seqParam, ServerExpression srchParam) {
    if (srchParam == null) {
      throw new IllegalArgumentException("srchParam parameter for indexOf() cannot be null");
    }
    return new XsExprImpl.IntegerSeqCallImpl("fn", "index-of", new Object[]{ seqParam, srchParam });
  }

  
  @Override
  public XsIntegerSeqExpr indexOf(ServerExpression seqParam, String srchParam, String collationLiteral) {
    return indexOf(seqParam, (srchParam == null) ? (XsAnyAtomicTypeExpr) null : xs.string(srchParam), (collationLiteral == null) ? (XsStringExpr) null : xs.string(collationLiteral));
  }

  
  @Override
  public XsIntegerSeqExpr indexOf(ServerExpression seqParam, ServerExpression srchParam, ServerExpression collationLiteral) {
    if (srchParam == null) {
      throw new IllegalArgumentException("srchParam parameter for indexOf() cannot be null");
    }
    if (collationLiteral == null) {
      throw new IllegalArgumentException("collationLiteral parameter for indexOf() cannot be null");
    }
    return new XsExprImpl.IntegerSeqCallImpl("fn", "index-of", new Object[]{ seqParam, srchParam, collationLiteral });
  }

  
  @Override
  public ItemSeqExpr insertBefore(ServerExpression target, long position, ServerExpression inserts) {
    return insertBefore(target, xs.integer(position), inserts);
  }

  
  @Override
  public ItemSeqExpr insertBefore(ServerExpression target, ServerExpression position, ServerExpression inserts) {
    if (position == null) {
      throw new IllegalArgumentException("position parameter for insertBefore() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "insert-before", new Object[]{ target, position, inserts });
  }

  
  @Override
  public XsStringExpr iriToUri(ServerExpression uriPart) {
    return new XsExprImpl.StringCallImpl("fn", "iri-to-uri", new Object[]{ uriPart });
  }

  
  @Override
  public XsBooleanExpr lang(ServerExpression testlang, ServerExpression node) {
    return new XsExprImpl.BooleanCallImpl("fn", "lang", new Object[]{ testlang, node });
  }

  
  @Override
  public XsStringExpr localName(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("fn", "local-name", new Object[]{ arg });
  }

  
  @Override
  public XsNCNameExpr localNameFromQName(ServerExpression arg) {
    return new XsExprImpl.NCNameCallImpl("fn", "local-name-from-QName", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr lowerCase(ServerExpression string) {
    return new XsExprImpl.StringCallImpl("fn", "lower-case", new Object[]{ string });
  }

  
  @Override
  public XsBooleanExpr matches(ServerExpression input, String pattern) {
    return matches(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern));
  }

  
  @Override
  public XsBooleanExpr matches(ServerExpression input, ServerExpression pattern) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for matches() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "matches", new Object[]{ input, pattern });
  }

  
  @Override
  public XsBooleanExpr matches(ServerExpression input, String pattern, String flags) {
    return matches(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern), (flags == null) ? (XsStringExpr) null : xs.string(flags));
  }

  
  @Override
  public XsBooleanExpr matches(ServerExpression input, ServerExpression pattern, ServerExpression flags) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for matches() cannot be null");
    }
    if (flags == null) {
      throw new IllegalArgumentException("flags parameter for matches() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "matches", new Object[]{ input, pattern, flags });
  }

  
  @Override
  public XsAnyAtomicTypeExpr max(ServerExpression arg) {
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "max", new Object[]{ arg });
  }

  
  @Override
  public XsAnyAtomicTypeExpr max(ServerExpression arg, String collation) {
    return max(arg, (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsAnyAtomicTypeExpr max(ServerExpression arg, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for max() cannot be null");
    }
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "max", new Object[]{ arg, collation });
  }

  
  @Override
  public XsAnyAtomicTypeExpr min(ServerExpression arg) {
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "min", new Object[]{ arg });
  }

  
  @Override
  public XsAnyAtomicTypeExpr min(ServerExpression arg, String collation) {
    return min(arg, (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsAnyAtomicTypeExpr min(ServerExpression arg, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for min() cannot be null");
    }
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "min", new Object[]{ arg, collation });
  }

  
  @Override
  public XsIntegerExpr minutesFromDateTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "minutes-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr minutesFromDuration(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "minutes-from-duration", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr minutesFromTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "minutes-from-time", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr monthFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "month-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr monthFromDateTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "month-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr monthsFromDuration(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "months-from-duration", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr name(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("fn", "name", new Object[]{ arg });
  }

  
  @Override
  public XsAnyURIExpr namespaceUri(ServerExpression arg) {
    return new XsExprImpl.AnyURICallImpl("fn", "namespace-uri", new Object[]{ arg });
  }

  
  @Override
  public XsAnyURIExpr namespaceUriForPrefix(ServerExpression prefix, ServerExpression element) {
    if (element == null) {
      throw new IllegalArgumentException("element parameter for namespaceUriForPrefix() cannot be null");
    }
    return new XsExprImpl.AnyURICallImpl("fn", "namespace-uri-for-prefix", new Object[]{ prefix, element });
  }

  
  @Override
  public XsAnyURIExpr namespaceUriFromQName(ServerExpression arg) {
    return new XsExprImpl.AnyURICallImpl("fn", "namespace-uri-from-QName", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr nilled(ServerExpression arg) {
    return new XsExprImpl.BooleanCallImpl("fn", "nilled", new Object[]{ arg });
  }

  
  @Override
  public XsQNameExpr nodeName(ServerExpression arg) {
    return new XsExprImpl.QNameCallImpl("fn", "node-name", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr normalizeSpace(ServerExpression input) {
    return new XsExprImpl.StringCallImpl("fn", "normalize-space", new Object[]{ input });
  }

  
  @Override
  public XsStringExpr normalizeUnicode(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("fn", "normalize-unicode", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr normalizeUnicode(ServerExpression arg, String normalizationForm) {
    return normalizeUnicode(arg, (normalizationForm == null) ? (XsStringExpr) null : xs.string(normalizationForm));
  }

  
  @Override
  public XsStringExpr normalizeUnicode(ServerExpression arg, ServerExpression normalizationForm) {
    if (normalizationForm == null) {
      throw new IllegalArgumentException("normalizationForm parameter for normalizeUnicode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "normalize-unicode", new Object[]{ arg, normalizationForm });
  }

  
  @Override
  public XsBooleanExpr not(ServerExpression arg) {
    return new XsExprImpl.BooleanCallImpl("fn", "not", new Object[]{ arg });
  }

  
  @Override
  public XsDoubleExpr number(ServerExpression arg) {
    return new XsExprImpl.DoubleCallImpl("fn", "number", new Object[]{ arg });
  }

  
  @Override
  public XsNCNameExpr prefixFromQName(ServerExpression arg) {
    return new XsExprImpl.NCNameCallImpl("fn", "prefix-from-QName", new Object[]{ arg });
  }

  
  @Override
  public XsQNameExpr QName(ServerExpression paramURI, String paramQName) {
    return QName(paramURI, (paramQName == null) ? (XsStringExpr) null : xs.string(paramQName));
  }

  
  @Override
  public XsQNameExpr QName(ServerExpression paramURI, ServerExpression paramQName) {
    if (paramQName == null) {
      throw new IllegalArgumentException("paramQName parameter for QName() cannot be null");
    }
    return new XsExprImpl.QNameCallImpl("fn", "QName", new Object[]{ paramURI, paramQName });
  }

  
  @Override
  public ItemSeqExpr remove(ServerExpression target, long position) {
    return remove(target, xs.integer(position));
  }

  
  @Override
  public ItemSeqExpr remove(ServerExpression target, ServerExpression position) {
    if (position == null) {
      throw new IllegalArgumentException("position parameter for remove() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "remove", new Object[]{ target, position });
  }

  
  @Override
  public XsStringExpr replace(ServerExpression input, String pattern, String replacement) {
    return replace(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern), (replacement == null) ? (XsStringExpr) null : xs.string(replacement));
  }

  
  @Override
  public XsStringExpr replace(ServerExpression input, ServerExpression pattern, ServerExpression replacement) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for replace() cannot be null");
    }
    if (replacement == null) {
      throw new IllegalArgumentException("replacement parameter for replace() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "replace", new Object[]{ input, pattern, replacement });
  }

  
  @Override
  public XsStringExpr replace(ServerExpression input, String pattern, String replacement, String flags) {
    return replace(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern), (replacement == null) ? (XsStringExpr) null : xs.string(replacement), (flags == null) ? (XsStringExpr) null : xs.string(flags));
  }

  
  @Override
  public XsStringExpr replace(ServerExpression input, ServerExpression pattern, ServerExpression replacement, ServerExpression flags) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for replace() cannot be null");
    }
    if (replacement == null) {
      throw new IllegalArgumentException("replacement parameter for replace() cannot be null");
    }
    if (flags == null) {
      throw new IllegalArgumentException("flags parameter for replace() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "replace", new Object[]{ input, pattern, replacement, flags });
  }

  
  @Override
  public XsQNameExpr resolveQName(ServerExpression qname, ServerExpression element) {
    if (element == null) {
      throw new IllegalArgumentException("element parameter for resolveQName() cannot be null");
    }
    return new XsExprImpl.QNameCallImpl("fn", "resolve-QName", new Object[]{ qname, element });
  }

  
  @Override
  public XsAnyURIExpr resolveUri(ServerExpression relative, String base) {
    return resolveUri(relative, (base == null) ? (XsStringExpr) null : xs.string(base));
  }

  
  @Override
  public XsAnyURIExpr resolveUri(ServerExpression relative, ServerExpression base) {
    if (base == null) {
      throw new IllegalArgumentException("base parameter for resolveUri() cannot be null");
    }
    return new XsExprImpl.AnyURICallImpl("fn", "resolve-uri", new Object[]{ relative, base });
  }

  
  @Override
  public ItemSeqExpr reverse(ServerExpression target) {
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "reverse", new Object[]{ target });
  }

  
  @Override
  public NodeExpr root(ServerExpression arg) {
    return new BaseTypeImpl.NodeCallImpl("fn", "root", new Object[]{ arg });
  }

  
  @Override
  public XsNumericExpr round(ServerExpression arg) {
    return new XsExprImpl.NumericCallImpl("fn", "round", new Object[]{ arg });
  }

  
  @Override
  public XsNumericExpr roundHalfToEven(ServerExpression arg) {
    return new XsExprImpl.NumericCallImpl("fn", "round-half-to-even", new Object[]{ arg });
  }

  
  @Override
  public XsNumericExpr roundHalfToEven(ServerExpression arg, long precision) {
    return roundHalfToEven(arg, xs.integer(precision));
  }

  
  @Override
  public XsNumericExpr roundHalfToEven(ServerExpression arg, ServerExpression precision) {
    if (precision == null) {
      throw new IllegalArgumentException("precision parameter for roundHalfToEven() cannot be null");
    }
    return new XsExprImpl.NumericCallImpl("fn", "round-half-to-even", new Object[]{ arg, precision });
  }

  
  @Override
  public XsDecimalExpr secondsFromDateTime(ServerExpression arg) {
    return new XsExprImpl.DecimalCallImpl("fn", "seconds-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsDecimalExpr secondsFromDuration(ServerExpression arg) {
    return new XsExprImpl.DecimalCallImpl("fn", "seconds-from-duration", new Object[]{ arg });
  }

  
  @Override
  public XsDecimalExpr secondsFromTime(ServerExpression arg) {
    return new XsExprImpl.DecimalCallImpl("fn", "seconds-from-time", new Object[]{ arg });
  }

  
  @Override
  public XsBooleanExpr startsWith(ServerExpression parameter1, String parameter2) {
    return startsWith(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2));
  }

  
  @Override
  public XsBooleanExpr startsWith(ServerExpression parameter1, ServerExpression parameter2) {
    return new XsExprImpl.BooleanCallImpl("fn", "starts-with", new Object[]{ parameter1, parameter2 });
  }

  
  @Override
  public XsBooleanExpr startsWith(ServerExpression parameter1, String parameter2, String collation) {
    return startsWith(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsBooleanExpr startsWith(ServerExpression parameter1, ServerExpression parameter2, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for startsWith() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("fn", "starts-with", new Object[]{ parameter1, parameter2, collation });
  }

  
  @Override
  public XsStringExpr string(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("fn", "string", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr stringJoin(ServerExpression parameter1, String parameter2) {
    return stringJoin(parameter1, (parameter2 == null) ? (XsStringExpr) null : xs.string(parameter2));
  }

  
  @Override
  public XsStringExpr stringJoin(ServerExpression parameter1, ServerExpression parameter2) {
    if (parameter2 == null) {
      throw new IllegalArgumentException("parameter2 parameter for stringJoin() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "string-join", new Object[]{ parameter1, parameter2 });
  }

  
  @Override
  public XsIntegerExpr stringLength(ServerExpression sourceString) {
    return new XsExprImpl.IntegerCallImpl("fn", "string-length", new Object[]{ sourceString });
  }

  
  @Override
  public XsIntegerSeqExpr stringToCodepoints(ServerExpression arg) {
    return new XsExprImpl.IntegerSeqCallImpl("fn", "string-to-codepoints", new Object[]{ arg });
  }

  
  @Override
  public ItemSeqExpr subsequence(ServerExpression sourceSeq, double startingLoc) {
    return subsequence(sourceSeq, xs.doubleVal(startingLoc));
  }

  
  @Override
  public ItemSeqExpr subsequence(ServerExpression sourceSeq, ServerExpression startingLoc) {
    if (startingLoc == null) {
      throw new IllegalArgumentException("startingLoc parameter for subsequence() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "subsequence", new Object[]{ sourceSeq, startingLoc });
  }

  
  @Override
  public ItemSeqExpr subsequence(ServerExpression sourceSeq, double startingLoc, double length) {
    return subsequence(sourceSeq, xs.doubleVal(startingLoc), xs.doubleVal(length));
  }

  
  @Override
  public ItemSeqExpr subsequence(ServerExpression sourceSeq, ServerExpression startingLoc, ServerExpression length) {
    if (startingLoc == null) {
      throw new IllegalArgumentException("startingLoc parameter for subsequence() cannot be null");
    }
    if (length == null) {
      throw new IllegalArgumentException("length parameter for subsequence() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "subsequence", new Object[]{ sourceSeq, startingLoc, length });
  }

  
  @Override
  public XsStringExpr substring(ServerExpression sourceString, double startingLoc) {
    return substring(sourceString, xs.doubleVal(startingLoc));
  }

  
  @Override
  public XsStringExpr substring(ServerExpression sourceString, ServerExpression startingLoc) {
    if (startingLoc == null) {
      throw new IllegalArgumentException("startingLoc parameter for substring() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "substring", new Object[]{ sourceString, startingLoc });
  }

  
  @Override
  public XsStringExpr substring(ServerExpression sourceString, double startingLoc, double length) {
    return substring(sourceString, xs.doubleVal(startingLoc), xs.doubleVal(length));
  }

  
  @Override
  public XsStringExpr substring(ServerExpression sourceString, ServerExpression startingLoc, ServerExpression length) {
    if (startingLoc == null) {
      throw new IllegalArgumentException("startingLoc parameter for substring() cannot be null");
    }
    if (length == null) {
      throw new IllegalArgumentException("length parameter for substring() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "substring", new Object[]{ sourceString, startingLoc, length });
  }

  
  @Override
  public XsStringExpr substringAfter(ServerExpression input, String after) {
    return substringAfter(input, (after == null) ? (XsStringExpr) null : xs.string(after));
  }

  
  @Override
  public XsStringExpr substringAfter(ServerExpression input, ServerExpression after) {
    return new XsExprImpl.StringCallImpl("fn", "substring-after", new Object[]{ input, after });
  }

  
  @Override
  public XsStringExpr substringAfter(ServerExpression input, String after, String collation) {
    return substringAfter(input, (after == null) ? (XsStringExpr) null : xs.string(after), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsStringExpr substringAfter(ServerExpression input, ServerExpression after, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for substringAfter() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "substring-after", new Object[]{ input, after, collation });
  }

  
  @Override
  public XsStringExpr substringBefore(ServerExpression input, String before) {
    return substringBefore(input, (before == null) ? (XsStringExpr) null : xs.string(before));
  }

  
  @Override
  public XsStringExpr substringBefore(ServerExpression input, ServerExpression before) {
    return new XsExprImpl.StringCallImpl("fn", "substring-before", new Object[]{ input, before });
  }

  
  @Override
  public XsStringExpr substringBefore(ServerExpression input, String before, String collation) {
    return substringBefore(input, (before == null) ? (XsStringExpr) null : xs.string(before), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsStringExpr substringBefore(ServerExpression input, ServerExpression before, ServerExpression collation) {
    if (collation == null) {
      throw new IllegalArgumentException("collation parameter for substringBefore() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "substring-before", new Object[]{ input, before, collation });
  }

  
  @Override
  public XsAnyAtomicTypeExpr sum(ServerExpression arg) {
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "sum", new Object[]{ arg });
  }

  
  @Override
  public XsAnyAtomicTypeExpr sum(ServerExpression arg, String zero) {
    return sum(arg, (zero == null) ? (XsAnyAtomicTypeExpr) null : xs.string(zero));
  }

  
  @Override
  public XsAnyAtomicTypeExpr sum(ServerExpression arg, ServerExpression zero) {
    return new XsExprImpl.AnyAtomicTypeCallImpl("fn", "sum", new Object[]{ arg, zero });
  }

  
  @Override
  public ItemSeqExpr tail(ServerExpression seq) {
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "tail", new Object[]{ seq });
  }

  
  @Override
  public XsDayTimeDurationExpr timezoneFromDate(ServerExpression arg) {
    return new XsExprImpl.DayTimeDurationCallImpl("fn", "timezone-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsDayTimeDurationExpr timezoneFromDateTime(ServerExpression arg) {
    return new XsExprImpl.DayTimeDurationCallImpl("fn", "timezone-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsDayTimeDurationExpr timezoneFromTime(ServerExpression arg) {
    return new XsExprImpl.DayTimeDurationCallImpl("fn", "timezone-from-time", new Object[]{ arg });
  }

  
  @Override
  public XsStringSeqExpr tokenize(ServerExpression input, String pattern) {
    return tokenize(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern));
  }

  
  @Override
  public XsStringSeqExpr tokenize(ServerExpression input, ServerExpression pattern) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for tokenize() cannot be null");
    }
    return new XsExprImpl.StringSeqCallImpl("fn", "tokenize", new Object[]{ input, pattern });
  }

  
  @Override
  public XsStringSeqExpr tokenize(ServerExpression input, String pattern, String flags) {
    return tokenize(input, (pattern == null) ? (XsStringExpr) null : xs.string(pattern), (flags == null) ? (XsStringExpr) null : xs.string(flags));
  }

  
  @Override
  public XsStringSeqExpr tokenize(ServerExpression input, ServerExpression pattern, ServerExpression flags) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern parameter for tokenize() cannot be null");
    }
    if (flags == null) {
      throw new IllegalArgumentException("flags parameter for tokenize() cannot be null");
    }
    return new XsExprImpl.StringSeqCallImpl("fn", "tokenize", new Object[]{ input, pattern, flags });
  }

  
  @Override
  public XsStringExpr translate(ServerExpression src, String mapString, String transString) {
    return translate(src, (mapString == null) ? (XsStringExpr) null : xs.string(mapString), (transString == null) ? (XsStringExpr) null : xs.string(transString));
  }

  
  @Override
  public XsStringExpr translate(ServerExpression src, ServerExpression mapString, ServerExpression transString) {
    if (mapString == null) {
      throw new IllegalArgumentException("mapString parameter for translate() cannot be null");
    }
    if (transString == null) {
      throw new IllegalArgumentException("transString parameter for translate() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("fn", "translate", new Object[]{ src, mapString, transString });
  }

  
  @Override
  public XsBooleanExpr trueExpr() {
    return new XsExprImpl.BooleanCallImpl("fn", "true", new Object[]{  });
  }

  
  @Override
  public ItemSeqExpr unordered(ServerExpression sourceSeq) {
    return new BaseTypeImpl.ItemSeqCallImpl("fn", "unordered", new Object[]{ sourceSeq });
  }

  
  @Override
  public XsStringExpr upperCase(ServerExpression string) {
    return new XsExprImpl.StringCallImpl("fn", "upper-case", new Object[]{ string });
  }

  
  @Override
  public XsIntegerExpr yearFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "year-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr yearFromDateTime(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "year-from-dateTime", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr yearsFromDuration(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("fn", "years-from-duration", new Object[]{ arg });
  }

  }
