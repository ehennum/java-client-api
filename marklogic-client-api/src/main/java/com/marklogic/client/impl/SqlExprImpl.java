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

import com.marklogic.client.type.ItemExpr;
import com.marklogic.client.type.ItemSeqExpr;
import com.marklogic.client.type.XsDecimalExpr;
import com.marklogic.client.type.XsIntegerExpr;
import com.marklogic.client.type.XsIntExpr;
import com.marklogic.client.type.XsNumericExpr;
import com.marklogic.client.type.XsStringExpr;
import com.marklogic.client.type.XsUnsignedIntExpr;
import com.marklogic.client.type.XsUnsignedLongExpr;

import com.marklogic.client.type.ServerExpression;

import com.marklogic.client.expression.SqlExpr;
import com.marklogic.client.impl.BaseTypeImpl;

// IMPORTANT: Do not edit. This file is generated.
class SqlExprImpl implements SqlExpr {

  final static XsExprImpl xs = XsExprImpl.xs;

  final static SqlExprImpl sql = new SqlExprImpl();

  SqlExprImpl() {
  }

    
  @Override
  public XsIntegerExpr bitLength(ServerExpression str) {
    return new XsExprImpl.IntegerCallImpl("sql", "bit-length", new Object[]{ str });
  }

  
  @Override
  public XsStringExpr collatedString(ServerExpression string, String collationURI) {
    return collatedString(string, (collationURI == null) ? (XsStringExpr) null : xs.string(collationURI));
  }

  
  @Override
  public XsStringExpr collatedString(ServerExpression string, ServerExpression collationURI) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for collatedString() cannot be null");
    }
    if (collationURI == null) {
      throw new IllegalArgumentException("collationURI parameter for collatedString() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "collated-string", new Object[]{ string, collationURI });
  }

  
  @Override
  public ItemExpr dateadd(ServerExpression datepart, int number, ServerExpression date) {
    return dateadd(datepart, xs.intVal(number), date);
  }

  
  @Override
  public ItemExpr dateadd(ServerExpression datepart, ServerExpression number, ServerExpression date) {
    if (datepart == null) {
      throw new IllegalArgumentException("datepart parameter for dateadd() cannot be null");
    }
    if (number == null) {
      throw new IllegalArgumentException("number parameter for dateadd() cannot be null");
    }
    if (date == null) {
      throw new IllegalArgumentException("date parameter for dateadd() cannot be null");
    }
    return new BaseTypeImpl.ItemCallImpl("sql", "dateadd", new Object[]{ datepart, number, date });
  }

  
  @Override
  public XsIntegerExpr datediff(ServerExpression datepart, ServerExpression startdate, ServerExpression enddate) {
    if (datepart == null) {
      throw new IllegalArgumentException("datepart parameter for datediff() cannot be null");
    }
    if (startdate == null) {
      throw new IllegalArgumentException("startdate parameter for datediff() cannot be null");
    }
    if (enddate == null) {
      throw new IllegalArgumentException("enddate parameter for datediff() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("sql", "datediff", new Object[]{ datepart, startdate, enddate });
  }

  
  @Override
  public XsIntegerExpr datepart(ServerExpression datepart, ServerExpression date) {
    if (datepart == null) {
      throw new IllegalArgumentException("datepart parameter for datepart() cannot be null");
    }
    if (date == null) {
      throw new IllegalArgumentException("date parameter for datepart() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("sql", "datepart", new Object[]{ datepart, date });
  }

  
  @Override
  public XsIntegerExpr day(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "day", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr dayname(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("sql", "dayname", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr hours(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "hours", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr insert(ServerExpression str, double start, double length, String str2) {
    return insert(str, xs.doubleVal(start), xs.doubleVal(length), (str2 == null) ? (XsStringExpr) null : xs.string(str2));
  }

  
  @Override
  public XsStringExpr insert(ServerExpression str, ServerExpression start, ServerExpression length, ServerExpression str2) {
    if (str == null) {
      throw new IllegalArgumentException("str parameter for insert() cannot be null");
    }
    if (start == null) {
      throw new IllegalArgumentException("start parameter for insert() cannot be null");
    }
    if (length == null) {
      throw new IllegalArgumentException("length parameter for insert() cannot be null");
    }
    if (str2 == null) {
      throw new IllegalArgumentException("str2 parameter for insert() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "insert", new Object[]{ str, start, length, str2 });
  }

  
  @Override
  public XsUnsignedIntExpr instr(ServerExpression str, String n) {
    return instr(str, (n == null) ? (XsStringExpr) null : xs.string(n));
  }

  
  @Override
  public XsUnsignedIntExpr instr(ServerExpression str, ServerExpression n) {
    if (str == null) {
      throw new IllegalArgumentException("str parameter for instr() cannot be null");
    }
    if (n == null) {
      throw new IllegalArgumentException("n parameter for instr() cannot be null");
    }
    return new XsExprImpl.UnsignedIntCallImpl("sql", "instr", new Object[]{ str, n });
  }

  
  @Override
  public XsStringExpr left(ServerExpression str, double n) {
    return left(str, xs.doubleVal(n));
  }

  
  @Override
  public XsStringExpr left(ServerExpression str, ServerExpression n) {
    if (n == null) {
      throw new IllegalArgumentException("n parameter for left() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "left", new Object[]{ str, n });
  }

  
  @Override
  public XsStringExpr ltrim(ServerExpression str) {
    if (str == null) {
      throw new IllegalArgumentException("str parameter for ltrim() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "ltrim", new Object[]{ str });
  }

  
  @Override
  public XsIntegerExpr minutes(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "minutes", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr month(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "month", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr monthname(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("sql", "monthname", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr octetLength(ServerExpression x) {
    return new XsExprImpl.IntegerCallImpl("sql", "octet-length", new Object[]{ x });
  }

  
  @Override
  public XsIntegerExpr quarter(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "quarter", new Object[]{ arg });
  }

  
  @Override
  public XsUnsignedLongExpr rand(ServerExpression n) {
    if (n == null) {
      throw new IllegalArgumentException("n parameter for rand() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("sql", "rand", new Object[]{ n });
  }

  
  @Override
  public XsStringExpr repeat(ServerExpression str, double n) {
    return repeat(str, xs.doubleVal(n));
  }

  
  @Override
  public XsStringExpr repeat(ServerExpression str, ServerExpression n) {
    if (n == null) {
      throw new IllegalArgumentException("n parameter for repeat() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "repeat", new Object[]{ str, n });
  }

  
  @Override
  public XsStringExpr right(ServerExpression str, double n) {
    return right(str, xs.doubleVal(n));
  }

  
  @Override
  public XsStringExpr right(ServerExpression str, ServerExpression n) {
    if (n == null) {
      throw new IllegalArgumentException("n parameter for right() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "right", new Object[]{ str, n });
  }

  
  @Override
  public XsStringExpr rtrim(ServerExpression str) {
    if (str == null) {
      throw new IllegalArgumentException("str parameter for rtrim() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "rtrim", new Object[]{ str });
  }

  
  @Override
  public XsDecimalExpr seconds(ServerExpression arg) {
    return new XsExprImpl.DecimalCallImpl("sql", "seconds", new Object[]{ arg });
  }

  
  @Override
  public ItemSeqExpr sign(ServerExpression x) {
    return new BaseTypeImpl.ItemSeqCallImpl("sql", "sign", new Object[]{ x });
  }

  
  @Override
  public XsStringExpr space(ServerExpression n) {
    if (n == null) {
      throw new IllegalArgumentException("n parameter for space() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "space", new Object[]{ n });
  }

  
  @Override
  public ItemExpr timestampadd(ServerExpression dateTimeType, int value, ServerExpression timestamp) {
    return timestampadd(dateTimeType, xs.intVal(value), timestamp);
  }

  
  @Override
  public ItemExpr timestampadd(ServerExpression dateTimeType, ServerExpression value, ServerExpression timestamp) {
    if (dateTimeType == null) {
      throw new IllegalArgumentException("dateTimeType parameter for timestampadd() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for timestampadd() cannot be null");
    }
    if (timestamp == null) {
      throw new IllegalArgumentException("timestamp parameter for timestampadd() cannot be null");
    }
    return new BaseTypeImpl.ItemCallImpl("sql", "timestampadd", new Object[]{ dateTimeType, value, timestamp });
  }

  
  @Override
  public XsIntegerExpr timestampdiff(ServerExpression dateTimeType, ServerExpression timestamp1, ServerExpression timestamp2) {
    if (dateTimeType == null) {
      throw new IllegalArgumentException("dateTimeType parameter for timestampdiff() cannot be null");
    }
    if (timestamp1 == null) {
      throw new IllegalArgumentException("timestamp1 parameter for timestampdiff() cannot be null");
    }
    if (timestamp2 == null) {
      throw new IllegalArgumentException("timestamp2 parameter for timestampdiff() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("sql", "timestampdiff", new Object[]{ dateTimeType, timestamp1, timestamp2 });
  }

  
  @Override
  public XsStringExpr trim(ServerExpression str) {
    if (str == null) {
      throw new IllegalArgumentException("str parameter for trim() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("sql", "trim", new Object[]{ str });
  }

  
  @Override
  public XsIntegerExpr week(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "week", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr weekday(ServerExpression arg1) {
    return new XsExprImpl.IntegerCallImpl("sql", "weekday", new Object[]{ arg1 });
  }

  
  @Override
  public XsIntegerExpr year(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "year", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr yearday(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("sql", "yearday", new Object[]{ arg });
  }

  }
