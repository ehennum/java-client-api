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
package com.marklogic.client.expression;

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

// IMPORTANT: Do not edit. This file is generated. 

/**
 * Builds expressions to call functions in the sql server library for a row
 * pipeline.
 */
public interface SqlExpr {
    /**
  * Returns the length of the string "str" in bits.
  *
  * <a name="ml-server-type-bit-length"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:bit-length" target="mlserverdoc">sql:bit-length</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr bitLength(ServerExpression str);
/**
  * Returns an rdf:collatedString value with the given value and collation tag. The rdf:collatedString type extends xs:string , and represents a collation tagged string in RDF. 
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:collated-string" target="mlserverdoc">sql:collated-string</a> server function.
  * @param string  The lexical value.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param collationURI  The collation URI.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr collatedString(ServerExpression string, String collationURI);
/**
  * Returns an rdf:collatedString value with the given value and collation tag. The rdf:collatedString type extends xs:string , and represents a collation tagged string in RDF. 
  *
  * <a name="ml-server-type-collated-string"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:collated-string" target="mlserverdoc">sql:collated-string</a> server function.
  * @param string  The lexical value.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param collationURI  The collation URI.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr collatedString(ServerExpression string, ServerExpression collationURI);
/**
  * Returns a specified date with the specified number interval (signed integer) added to a specified datepart of that date 
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:dateadd" target="mlserverdoc">sql:dateadd</a> server function.
  * @param datepart  Is the part of date where the number will be added. The following table lists all valid datepart arguments. User-defined variable equivalents are not valid. The return data type is the data type of the date argument. Options: datepart parameter abbreviation includes:  "year","yyyy","yy" The year part of the date "quarter","qq","q" The quarter part of the date "month","mm","m" The month part of the date "dayofyear","dy","y" The day of the year from the date "day","dd","d" The day of the month from the date "week","wk","ww" The week of the year from the date "weekday","dw" The day of the week from the date "hour","hh" The hour of the day from the date "minute","mi","n" The minute of the hour from the date "second","ss","s" The second of the minute from the date "millisecond","ms" The millisecond of the minute from the date "microsecond","msc" The microsecond of the minute from the date "nanosecond","ns" The nanosecond of the minute from the date   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param number  This number will be added to the datepart of the given date.  (of <a href="{@docRoot}/doc-files/types/xs_int.html">xs:int</a>)
  * @param date  Is an expression that can be resolved to a time, date or datetime, value. date can be an expression, column expression, user-defined variable or string literal. startdate is subtracted from enddate.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/item.html">item</a> server data type
  */
  public ItemExpr dateadd(ServerExpression datepart, int number, ServerExpression date);
/**
  * Returns a specified date with the specified number interval (signed integer) added to a specified datepart of that date 
  *
  * <a name="ml-server-type-dateadd"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:dateadd" target="mlserverdoc">sql:dateadd</a> server function.
  * @param datepart  Is the part of date where the number will be added. The following table lists all valid datepart arguments. User-defined variable equivalents are not valid. The return data type is the data type of the date argument. Options: datepart parameter abbreviation includes:  "year","yyyy","yy" The year part of the date "quarter","qq","q" The quarter part of the date "month","mm","m" The month part of the date "dayofyear","dy","y" The day of the year from the date "day","dd","d" The day of the month from the date "week","wk","ww" The week of the year from the date "weekday","dw" The day of the week from the date "hour","hh" The hour of the day from the date "minute","mi","n" The minute of the hour from the date "second","ss","s" The second of the minute from the date "millisecond","ms" The millisecond of the minute from the date "microsecond","msc" The microsecond of the minute from the date "nanosecond","ns" The nanosecond of the minute from the date   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param number  This number will be added to the datepart of the given date.  (of <a href="{@docRoot}/doc-files/types/xs_int.html">xs:int</a>)
  * @param date  Is an expression that can be resolved to a time, date or datetime, value. date can be an expression, column expression, user-defined variable or string literal. startdate is subtracted from enddate.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/item.html">item</a> server data type
  */
  public ItemExpr dateadd(ServerExpression datepart, ServerExpression number, ServerExpression date);
/**
  * Returns the count (signed integer) of the specified datepart boundaries crossed between the specified startdate and enddate. 
  *
  * <a name="ml-server-type-datediff"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:datediff" target="mlserverdoc">sql:datediff</a> server function.
  * @param datepart  Is the part of startdate and enddate that specifies the type of boundary crossed. The following table lists all valid datepart arguments. User-defined variable equivalents are not valid. Options: datepart parameter abbreviation includes:  "year","yyyy","yy" The year part of the date "quarter","qq","q" The quarter part of the date "month","mm","m" The month part of the date "dayofyear","dy","y" The day of the year from the date "day","dd","d" The day of the month from the date "week","wk","ww" The week of the year from the date "weekday","dw" The day of the week from the date "hour","hh" The hour of the day from the date "minute","mi","n" The minute of the hour from the date "second","ss","s" The second of the minute from the date "millisecond","ms" The millisecond of the minute from the date "microsecond","msc" The microsecond of the minute from the date "nanosecond","ns" The nanosecond of the minute from the date   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param startdate  Is an expression that can be resolved to a time, date, datetime or value. date can be an expression, column expression, user-defined variable or string literal. startdate is subtracted from enddate.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param enddate  Same as startdate.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr datediff(ServerExpression datepart, ServerExpression startdate, ServerExpression enddate);
/**
  * Returns an integer that represents the specified datepart of the specified date. 
  *
  * <a name="ml-server-type-datepart"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:datepart" target="mlserverdoc">sql:datepart</a> server function.
  * @param datepart  The part of date that to be returned. Options: datepart parameter abbreviation includes:  "year","yyyy","yy" The year part of the date "quarter","qq","q" The quarter part of the date "month","mm","m" The month part of the date "dayofyear","dy","y" The day of the year from the date "day","dd","d" The day of the month from the date "week","wk","ww" The week of the year from the date "weekday","dw" The day of the week from the date "hour","hh" The hour of the day from the date "minute","mi","n" The minute of the hour from the date "second","ss","s" The second of the minute from the date "millisecond","ms" The millisecond of the minute from the date "microsecond","msc" The microsecond of the minute from the date "nanosecond","ns" The nanosecond of the minute from the date "TZoffset","tz" The timezone offset from the date   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param date  Is an expression that can be resolved to a xs:date, xs:time, xs:dateTime. date can be an expression, column expression,user-defined variable, or string literal.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr datepart(ServerExpression datepart, ServerExpression date);
/**
  * Returns an xs:integer between 1 and 31, both inclusive, representing the day component in the localized value of arg. 
  *
  * <a name="ml-server-type-day"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:day" target="mlserverdoc">sql:day</a> server function.
  * @param arg  The xs:genericDateTimeArg whose day component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr day(ServerExpression arg);
/**
  * Returns an xs:string representing the dayname value in the localized value of arg. 
  *
  * <a name="ml-server-type-dayname"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:dayname" target="mlserverdoc">sql:dayname</a> server function.
  * @param arg  The date whose dayname value will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr dayname(ServerExpression arg);
/**
  * Returns an xs:integer between 0 and 23, both inclusive, representing the value of the hours component in the localized value of arg. 
  *
  * <a name="ml-server-type-hours"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:hours" target="mlserverdoc">sql:hours</a> server function.
  * @param arg  The genericDateTime whose hours component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr hours(ServerExpression arg);
/**
  * Returns a string that that is the first argument with length characters removed starting at start and the second string has been inserted beginning at start.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:insert" target="mlserverdoc">sql:insert</a> server function.
  * @param str  The string to manipulate.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param start  The starting position where characters will be inserted.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @param length  The number of characters to be removed.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @param str2  The string to insert.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr insert(ServerExpression str, double start, double length, String str2);
/**
  * Returns a string that that is the first argument with length characters removed starting at start and the second string has been inserted beginning at start.
  *
  * <a name="ml-server-type-insert"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:insert" target="mlserverdoc">sql:insert</a> server function.
  * @param str  The string to manipulate.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param start  The starting position where characters will be inserted.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @param length  The number of characters to be removed.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @param str2  The string to insert.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr insert(ServerExpression str, ServerExpression start, ServerExpression length, ServerExpression str2);
/**
  * Find the starting location of a pattern in a string.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:instr" target="mlserverdoc">sql:instr</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param n  The pattern to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_unsignedInt.html">xs:unsignedInt</a> server data type
  */
  public XsUnsignedIntExpr instr(ServerExpression str, String n);
/**
  * Find the starting location of a pattern in a string.
  *
  * <a name="ml-server-type-instr"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:instr" target="mlserverdoc">sql:instr</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param n  The pattern to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_unsignedInt.html">xs:unsignedInt</a> server data type
  */
  public XsUnsignedIntExpr instr(ServerExpression str, ServerExpression n);
/**
  * Returns a string that is the leftmost characters of the target string. The number of characters to return is specified by the second argument.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:left" target="mlserverdoc">sql:left</a> server function.
  * @param str  The base string. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of leftmost characters of the string to return.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr left(ServerExpression str, double n);
/**
  * Returns a string that is the leftmost characters of the target string. The number of characters to return is specified by the second argument.
  *
  * <a name="ml-server-type-left"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:left" target="mlserverdoc">sql:left</a> server function.
  * @param str  The base string. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of leftmost characters of the string to return.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr left(ServerExpression str, ServerExpression n);
/**
  * Return a string that removes leading empty spaces in the input string.
  *
  * <a name="ml-server-type-ltrim"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:ltrim" target="mlserverdoc">sql:ltrim</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr ltrim(ServerExpression str);
/**
  * Returns an xs:integer value between 0 to 59, both inclusive, representing the value of the minutes component in the localized value of arg. 
  *
  * <a name="ml-server-type-minutes"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:minutes" target="mlserverdoc">sql:minutes</a> server function.
  * @param arg  The genericDateTime whose minutes component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr minutes(ServerExpression arg);
/**
  * Returns an xs:integer between 1 and 12, both inclusive, representing the month component in the localized value of arg. 
  *
  * <a name="ml-server-type-month"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:month" target="mlserverdoc">sql:month</a> server function.
  * @param arg  The genericDateTime whose month component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr month(ServerExpression arg);
/**
  * Returns month name, calculated from the localized value of arg. 
  *
  * <a name="ml-server-type-monthname"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:monthname" target="mlserverdoc">sql:monthname</a> server function.
  * @param arg  The date whose month-name will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr monthname(ServerExpression arg);
/**
  * Returns the length of the string "str" in bits.
  *
  * <a name="ml-server-type-octet-length"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:octet-length" target="mlserverdoc">sql:octet-length</a> server function.
  * @param x  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr octetLength(ServerExpression x);
/**
  * Returns an xs:integer between 1 and 4, both inclusive, calculating the quarter component in the localized value of arg. 
  *
  * <a name="ml-server-type-quarter"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:quarter" target="mlserverdoc">sql:quarter</a> server function.
  * @param arg  The genericDateTime whose quarter component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr quarter(ServerExpression arg);
/**
  * Return a random number. This differs from xdmp:random in that the argument is a seed.
  *
  * <a name="ml-server-type-rand"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:rand" target="mlserverdoc">sql:rand</a> server function.
  * @param n  The random seed. Currently this parameter is ignored.  (of <a href="{@docRoot}/doc-files/types/xs_unsignedLong.html">xs:unsignedLong</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_unsignedLong.html">xs:unsignedLong</a> server data type
  */
  public XsUnsignedLongExpr rand(ServerExpression n);
/**
  * Returns a string that concatenates the first argument as many times as specified by the second argument.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:repeat" target="mlserverdoc">sql:repeat</a> server function.
  * @param str  The string to duplicate. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of times to repeat the string.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr repeat(ServerExpression str, double n);
/**
  * Returns a string that concatenates the first argument as many times as specified by the second argument.
  *
  * <a name="ml-server-type-repeat"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:repeat" target="mlserverdoc">sql:repeat</a> server function.
  * @param str  The string to duplicate. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of times to repeat the string.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr repeat(ServerExpression str, ServerExpression n);
/**
  * Returns a string that is the rightmost characters of the target string. The number of characters to return is specified by the second argument.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:right" target="mlserverdoc">sql:right</a> server function.
  * @param str  The base string. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of rightmost characters of the string to return.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr right(ServerExpression str, double n);
/**
  * Returns a string that is the rightmost characters of the target string. The number of characters to return is specified by the second argument.
  *
  * <a name="ml-server-type-right"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:right" target="mlserverdoc">sql:right</a> server function.
  * @param str  The base string. If the value is not a string, its string value will be used.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param n  The number of rightmost characters of the string to return.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr right(ServerExpression str, ServerExpression n);
/**
  * Return a string that removes trailing empty spaces in the input string.
  *
  * <a name="ml-server-type-rtrim"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:rtrim" target="mlserverdoc">sql:rtrim</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr rtrim(ServerExpression str);
/**
  * Returns an xs:decimal value between 0 and 60.999..., both inclusive, representing the seconds and fractional seconds in the localized value of arg. Note that the value can be greater than 60 seconds to accommodate occasional leap seconds used to keep human time synchronized with the rotation of the planet. 
  *
  * <a name="ml-server-type-seconds"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:seconds" target="mlserverdoc">sql:seconds</a> server function.
  * @param arg  The time whose seconds component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_decimal.html">xs:decimal</a> server data type
  */
  public XsDecimalExpr seconds(ServerExpression arg);
/**
  * Returns the sign of number x.
  *
  * <a name="ml-server-type-sign"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:sign" target="mlserverdoc">sql:sign</a> server function.
  * @param x  The number to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/item.html">item</a> server data type
  */
  public ItemSeqExpr sign(ServerExpression x);
/**
  * Returns a string that is the given number of spaces.
  *
  * <a name="ml-server-type-space"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:space" target="mlserverdoc">sql:space</a> server function.
  * @param n  The number of spaces to return as a string.  (of <a href="{@docRoot}/doc-files/types/xs_numeric.html">xs:numeric</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr space(ServerExpression n);
/**
  * Returns a xs:string? timestamp created by adding a number to the given dateTimeType field of a given timestamp.
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:timestampadd" target="mlserverdoc">sql:timestampadd</a> server function.
  * @param dateTimeType  The dateTimeType of the timestamp where addition should take place. Available types are:  SQL_TSI_FRAC_SECOND nano seconds SQL_TSI_SECOND seconds SQL_TSI_MINUTE minute SQL_TSI_HOUR hour SQL_TSI_DAY day SQL_TSI_WEEK week SQL_TSI_MONTH month SQL_TSI_QUARTER quarter SQL_TSI_YEAR year   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param value  The integer to add to the given dateTimeType field of the third parameter.  (of <a href="{@docRoot}/doc-files/types/xs_int.html">xs:int</a>)
  * @param timestamp  The xs:dateTime timestamp to which addition has to take place.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/item.html">item</a> server data type
  */
  public ItemExpr timestampadd(ServerExpression dateTimeType, int value, ServerExpression timestamp);
/**
  * Returns a xs:string? timestamp created by adding a number to the given dateTimeType field of a given timestamp.
  *
  * <a name="ml-server-type-timestampadd"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:timestampadd" target="mlserverdoc">sql:timestampadd</a> server function.
  * @param dateTimeType  The dateTimeType of the timestamp where addition should take place. Available types are:  SQL_TSI_FRAC_SECOND nano seconds SQL_TSI_SECOND seconds SQL_TSI_MINUTE minute SQL_TSI_HOUR hour SQL_TSI_DAY day SQL_TSI_WEEK week SQL_TSI_MONTH month SQL_TSI_QUARTER quarter SQL_TSI_YEAR year   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param value  The integer to add to the given dateTimeType field of the third parameter.  (of <a href="{@docRoot}/doc-files/types/xs_int.html">xs:int</a>)
  * @param timestamp  The xs:dateTime timestamp to which addition has to take place.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/item.html">item</a> server data type
  */
  public ItemExpr timestampadd(ServerExpression dateTimeType, ServerExpression value, ServerExpression timestamp);
/**
  * Returns the difference in dateTimeType field of two given timestamps.
  *
  * <a name="ml-server-type-timestampdiff"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:timestampdiff" target="mlserverdoc">sql:timestampdiff</a> server function.
  * @param dateTimeType  The dateTimeType of the timestamp where addition should take place. Available types are:  SQL_TSI_FRAC_SECOND nano seconds SQL_TSI_SECOND seconds SQL_TSI_MINUTE minute SQL_TSI_HOUR hour SQL_TSI_DAY day SQL_TSI_WEEK week SQL_TSI_MONTH month SQL_TSI_QUARTER quarter SQL_TSI_YEAR year   (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @param timestamp1  The integer to add to the given dateTimeType field of the third parameter.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @param timestamp2  The xs:dateTime timestamp to which addition has to take place.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr timestampdiff(ServerExpression dateTimeType, ServerExpression timestamp1, ServerExpression timestamp2);
/**
  * Return a string that removes leading empty spaces in the input string.
  *
  * <a name="ml-server-type-trim"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:trim" target="mlserverdoc">sql:trim</a> server function.
  * @param str  The string to be evaluated.  (of <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_string.html">xs:string</a> server data type
  */
  public XsStringExpr trim(ServerExpression str);
/**
  * Returns an xs:integer between 1 and 53, both inclusive, representing the week value in the localized value of arg. 
  *
  * <a name="ml-server-type-week"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:week" target="mlserverdoc">sql:week</a> server function.
  * @param arg  The dateTime/date/string whose day component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr week(ServerExpression arg);
public XsIntegerExpr weekday(ServerExpression arg1);
/**
  * Returns an xs:integer representing the year component in the localized value of arg. The result may be negative. 
  *
  * <a name="ml-server-type-year"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:year" target="mlserverdoc">sql:year</a> server function.
  * @param arg  The dateTime/date/string whose day component will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr year(ServerExpression arg);
/**
  * Returns an xs:integer between 1 and 366, both inclusive, representing the yearday value in the localized value of arg. 
  *
  * <a name="ml-server-type-yearday"></a>
  
  * <p>
  * Provides a client interface to the <a href="http://docs.marklogic.com/sql:yearday" target="mlserverdoc">sql:yearday</a> server function.
  * @param arg  The xs:genericDateTimeArg whose days of the year will be returned.  (of <a href="{@docRoot}/doc-files/types/item.html">item</a>)
  * @return  a server expression with the <a href="{@docRoot}/doc-files/types/xs_integer.html">xs:integer</a> server data type
  */
  public XsIntegerExpr yearday(ServerExpression arg);
}
