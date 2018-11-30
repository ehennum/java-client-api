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
import com.marklogic.client.type.MapMapExpr;
import com.marklogic.client.type.NodeExpr;
import com.marklogic.client.type.XsAnyAtomicTypeExpr;
import com.marklogic.client.type.XsAnyURIExpr;
import com.marklogic.client.type.XsBooleanExpr;
import com.marklogic.client.type.XsDateExpr;
import com.marklogic.client.type.XsDateTimeExpr;
import com.marklogic.client.type.XsIntegerExpr;
import com.marklogic.client.type.XsLongExpr;
import com.marklogic.client.type.XsNumericExpr;
import com.marklogic.client.type.XsNumericSeqExpr;
import com.marklogic.client.type.XsQNameExpr;
import com.marklogic.client.type.XsStringExpr;
import com.marklogic.client.type.XsStringSeqExpr;
import com.marklogic.client.type.XsUnsignedIntExpr;
import com.marklogic.client.type.XsUnsignedLongExpr;

import com.marklogic.client.type.ServerExpression;

import com.marklogic.client.expression.XdmpExpr;
import com.marklogic.client.impl.BaseTypeImpl;

// IMPORTANT: Do not edit. This file is generated.
class XdmpExprImpl implements XdmpExpr {

  final static XsExprImpl xs = XsExprImpl.xs;

  final static XdmpExprImpl xdmp = new XdmpExprImpl();

  XdmpExprImpl() {
  }

    
  @Override
  public XsUnsignedLongExpr add64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for add64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for add64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "add64", new Object[]{ x, y });
  }

  
  @Override
  public XsUnsignedLongExpr and64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for and64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for and64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "and64", new Object[]{ x, y });
  }

  
  @Override
  public XsStringExpr base64Decode(ServerExpression encoded) {
    if (encoded == null) {
      throw new IllegalArgumentException("encoded parameter for base64Decode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "base64-decode", new Object[]{ encoded });
  }

  
  @Override
  public XsStringExpr base64Encode(ServerExpression plaintext) {
    if (plaintext == null) {
      throw new IllegalArgumentException("plaintext parameter for base64Encode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "base64-encode", new Object[]{ plaintext });
  }

  
  @Override
  public XsBooleanExpr castableAs(ServerExpression namespaceUri, String localName, ServerExpression item) {
    return castableAs(namespaceUri, (localName == null) ? (XsStringExpr) null : xs.string(localName), item);
  }

  
  @Override
  public XsBooleanExpr castableAs(ServerExpression namespaceUri, ServerExpression localName, ServerExpression item) {
    if (namespaceUri == null) {
      throw new IllegalArgumentException("namespaceUri parameter for castableAs() cannot be null");
    }
    if (localName == null) {
      throw new IllegalArgumentException("localName parameter for castableAs() cannot be null");
    }
    return new XsExprImpl.BooleanCallImpl("xdmp", "castable-as", new Object[]{ namespaceUri, localName, item });
  }

  
  @Override
  public XsStringExpr crypt(ServerExpression password, String salt) {
    return crypt(password, (salt == null) ? (XsStringExpr) null : xs.string(salt));
  }

  
  @Override
  public XsStringExpr crypt(ServerExpression password, ServerExpression salt) {
    if (password == null) {
      throw new IllegalArgumentException("password parameter for crypt() cannot be null");
    }
    if (salt == null) {
      throw new IllegalArgumentException("salt parameter for crypt() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "crypt", new Object[]{ password, salt });
  }

  
  @Override
  public XsStringExpr crypt2(ServerExpression password) {
    if (password == null) {
      throw new IllegalArgumentException("password parameter for crypt2() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "crypt2", new Object[]{ password });
  }

  
  @Override
  public XsStringExpr daynameFromDate(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("xdmp", "dayname-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr decodeFromNCName(ServerExpression name) {
    if (name == null) {
      throw new IllegalArgumentException("name parameter for decodeFromNCName() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "decode-from-NCName", new Object[]{ name });
  }

  
  @Override
  public XsStringExpr describe(ServerExpression item) {
    return new XsExprImpl.StringCallImpl("xdmp", "describe", new Object[]{ item });
  }

  
  @Override
  public XsStringExpr describe(ServerExpression item, ServerExpression maxSequenceLength) {
    return new XsExprImpl.StringCallImpl("xdmp", "describe", new Object[]{ item, maxSequenceLength });
  }

  
  @Override
  public XsStringExpr describe(ServerExpression item, ServerExpression maxSequenceLength, ServerExpression maxItemLength) {
    return new XsExprImpl.StringCallImpl("xdmp", "describe", new Object[]{ item, maxSequenceLength, maxItemLength });
  }

  
  @Override
  public XsStringExpr diacriticLess(ServerExpression string) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for diacriticLess() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "diacritic-less", new Object[]{ string });
  }

  
  @Override
  public XsStringExpr elementContentType(ServerExpression element) {
    if (element == null) {
      throw new IllegalArgumentException("element parameter for elementContentType() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "element-content-type", new Object[]{ element });
  }

  
  @Override
  public XsStringExpr encodeForNCName(ServerExpression name) {
    if (name == null) {
      throw new IllegalArgumentException("name parameter for encodeForNCName() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "encode-for-NCName", new Object[]{ name });
  }

  
  @Override
  public XsStringExpr formatNumber(XsNumericExpr... value) {
    return formatNumber(new XsExprImpl.NumericSeqListImpl(value));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language, String letterValue) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (letterValue == null) ? (XsStringExpr) null : xs.string(letterValue));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression letterValue) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language, letterValue });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language, String letterValue, String ordchar) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (letterValue == null) ? (XsStringExpr) null : xs.string(letterValue), (ordchar == null) ? (XsStringExpr) null : xs.string(ordchar));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression letterValue, ServerExpression ordchar) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language, letterValue, ordchar });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language, String letterValue, String ordchar, String zeroPadding) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (letterValue == null) ? (XsStringExpr) null : xs.string(letterValue), (ordchar == null) ? (XsStringExpr) null : xs.string(ordchar), (zeroPadding == null) ? (XsStringExpr) null : xs.string(zeroPadding));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression letterValue, ServerExpression ordchar, ServerExpression zeroPadding) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language, letterValue, ordchar, zeroPadding });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language, String letterValue, String ordchar, String zeroPadding, String groupingSeparator) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (letterValue == null) ? (XsStringExpr) null : xs.string(letterValue), (ordchar == null) ? (XsStringExpr) null : xs.string(ordchar), (zeroPadding == null) ? (XsStringExpr) null : xs.string(zeroPadding), (groupingSeparator == null) ? (XsStringExpr) null : xs.string(groupingSeparator));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression letterValue, ServerExpression ordchar, ServerExpression zeroPadding, ServerExpression groupingSeparator) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language, letterValue, ordchar, zeroPadding, groupingSeparator });
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, String picture, String language, String letterValue, String ordchar, String zeroPadding, String groupingSeparator, long groupingSize) {
    return formatNumber(value, (picture == null) ? (XsStringExpr) null : xs.string(picture), (language == null) ? (XsStringExpr) null : xs.string(language), (letterValue == null) ? (XsStringExpr) null : xs.string(letterValue), (ordchar == null) ? (XsStringExpr) null : xs.string(ordchar), (zeroPadding == null) ? (XsStringExpr) null : xs.string(zeroPadding), (groupingSeparator == null) ? (XsStringExpr) null : xs.string(groupingSeparator), xs.integer(groupingSize));
  }

  
  @Override
  public XsStringExpr formatNumber(ServerExpression value, ServerExpression picture, ServerExpression language, ServerExpression letterValue, ServerExpression ordchar, ServerExpression zeroPadding, ServerExpression groupingSeparator, ServerExpression groupingSize) {
    return new XsExprImpl.StringCallImpl("xdmp", "format-number", new Object[]{ value, picture, language, letterValue, ordchar, zeroPadding, groupingSeparator, groupingSize });
  }

  
  @Override
  public ItemSeqExpr fromJson(ServerExpression arg) {
    if (arg == null) {
      throw new IllegalArgumentException("arg parameter for fromJson() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("xdmp", "from-json", new Object[]{ arg });
  }

  
  @Override
  public XsStringExpr getCurrentUser() {
    return new XsExprImpl.StringCallImpl("xdmp", "get-current-user", new Object[]{  });
  }

  
  @Override
  public XsUnsignedIntExpr hash32(ServerExpression string) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for hash32() cannot be null");
    }
    return new XsExprImpl.UnsignedIntCallImpl("xdmp", "hash32", new Object[]{ string });
  }

  
  @Override
  public XsUnsignedLongExpr hash64(ServerExpression string) {
    if (string == null) {
      throw new IllegalArgumentException("string parameter for hash64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "hash64", new Object[]{ string });
  }

  
  @Override
  public XsIntegerExpr hexToInteger(ServerExpression hex) {
    if (hex == null) {
      throw new IllegalArgumentException("hex parameter for hexToInteger() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("xdmp", "hex-to-integer", new Object[]{ hex });
  }

  
  @Override
  public XsStringExpr hmacMd5(ServerExpression secretkey, ServerExpression message) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacMd5() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacMd5() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-md5", new Object[]{ secretkey, message });
  }

  
  @Override
  public XsStringExpr hmacMd5(ServerExpression secretkey, ServerExpression message, String encoding) {
    return hmacMd5(secretkey, message, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr hmacMd5(ServerExpression secretkey, ServerExpression message, ServerExpression encoding) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacMd5() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacMd5() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for hmacMd5() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-md5", new Object[]{ secretkey, message, encoding });
  }

  
  @Override
  public XsStringExpr hmacSha1(ServerExpression secretkey, ServerExpression message) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha1() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha1() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha1", new Object[]{ secretkey, message });
  }

  
  @Override
  public XsStringExpr hmacSha1(ServerExpression secretkey, ServerExpression message, String encoding) {
    return hmacSha1(secretkey, message, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr hmacSha1(ServerExpression secretkey, ServerExpression message, ServerExpression encoding) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha1() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha1() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for hmacSha1() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha1", new Object[]{ secretkey, message, encoding });
  }

  
  @Override
  public XsStringExpr hmacSha256(ServerExpression secretkey, ServerExpression message) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha256() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha256() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha256", new Object[]{ secretkey, message });
  }

  
  @Override
  public XsStringExpr hmacSha256(ServerExpression secretkey, ServerExpression message, String encoding) {
    return hmacSha256(secretkey, message, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr hmacSha256(ServerExpression secretkey, ServerExpression message, ServerExpression encoding) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha256() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha256() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for hmacSha256() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha256", new Object[]{ secretkey, message, encoding });
  }

  
  @Override
  public XsStringExpr hmacSha512(ServerExpression secretkey, ServerExpression message) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha512() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha512() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha512", new Object[]{ secretkey, message });
  }

  
  @Override
  public XsStringExpr hmacSha512(ServerExpression secretkey, ServerExpression message, String encoding) {
    return hmacSha512(secretkey, message, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr hmacSha512(ServerExpression secretkey, ServerExpression message, ServerExpression encoding) {
    if (secretkey == null) {
      throw new IllegalArgumentException("secretkey parameter for hmacSha512() cannot be null");
    }
    if (message == null) {
      throw new IllegalArgumentException("message parameter for hmacSha512() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for hmacSha512() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "hmac-sha512", new Object[]{ secretkey, message, encoding });
  }

  
  @Override
  public XsStringExpr initcap(ServerExpression string) {
    return new XsExprImpl.StringCallImpl("xdmp", "initcap", new Object[]{ string });
  }

  
  @Override
  public XsStringExpr integerToHex(ServerExpression val) {
    if (val == null) {
      throw new IllegalArgumentException("val parameter for integerToHex() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "integer-to-hex", new Object[]{ val });
  }

  
  @Override
  public XsStringExpr integerToOctal(ServerExpression val) {
    if (val == null) {
      throw new IllegalArgumentException("val parameter for integerToOctal() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "integer-to-octal", new Object[]{ val });
  }

  
  @Override
  public XsStringExpr keyFromQName(ServerExpression name) {
    if (name == null) {
      throw new IllegalArgumentException("name parameter for keyFromQName() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "key-from-QName", new Object[]{ name });
  }

  
  @Override
  public XsUnsignedLongExpr lshift64(ServerExpression x, long y) {
    return lshift64(x, xs.longVal(y));
  }

  
  @Override
  public XsUnsignedLongExpr lshift64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for lshift64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for lshift64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "lshift64", new Object[]{ x, y });
  }

  
  @Override
  public XsStringExpr md5(ServerExpression data) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for md5() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "md5", new Object[]{ data });
  }

  
  @Override
  public XsStringExpr md5(ServerExpression data, String encoding) {
    return md5(data, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr md5(ServerExpression data, ServerExpression encoding) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for md5() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for md5() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "md5", new Object[]{ data, encoding });
  }

  
  @Override
  public XsStringExpr monthNameFromDate(ServerExpression arg) {
    return new XsExprImpl.StringCallImpl("xdmp", "month-name-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsUnsignedLongExpr mul64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for mul64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for mul64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "mul64", new Object[]{ x, y });
  }

  
  @Override
  public XsStringSeqExpr nodeCollections(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodeCollections() cannot be null");
    }
    return new XsExprImpl.StringSeqCallImpl("xdmp", "node-collections", new Object[]{ node });
  }

  
  @Override
  public XsStringExpr nodeKind(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodeKind() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "node-kind", new Object[]{ node });
  }

  
  @Override
  public MapMapExpr nodeMetadata(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodeMetadata() cannot be null");
    }
    return new MapExprImpl.MapCallImpl("xdmp", "node-metadata", new Object[]{ node });
  }

  
  @Override
  public XsStringExpr nodeMetadataValue(ServerExpression uri, String keyName) {
    return nodeMetadataValue(uri, (keyName == null) ? (XsStringExpr) null : xs.string(keyName));
  }

  
  @Override
  public XsStringExpr nodeMetadataValue(ServerExpression uri, ServerExpression keyName) {
    if (uri == null) {
      throw new IllegalArgumentException("uri parameter for nodeMetadataValue() cannot be null");
    }
    if (keyName == null) {
      throw new IllegalArgumentException("keyName parameter for nodeMetadataValue() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "node-metadata-value", new Object[]{ uri, keyName });
  }

  
  @Override
  public ItemSeqExpr nodePermissions(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodePermissions() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("xdmp", "node-permissions", new Object[]{ node });
  }

  
  @Override
  public ItemSeqExpr nodePermissions(ServerExpression node, String outputKind) {
    return nodePermissions(node, (outputKind == null) ? (XsStringExpr) null : xs.string(outputKind));
  }

  
  @Override
  public ItemSeqExpr nodePermissions(ServerExpression node, ServerExpression outputKind) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodePermissions() cannot be null");
    }
    if (outputKind == null) {
      throw new IllegalArgumentException("outputKind parameter for nodePermissions() cannot be null");
    }
    return new BaseTypeImpl.ItemSeqCallImpl("xdmp", "node-permissions", new Object[]{ node, outputKind });
  }

  
  @Override
  public XsStringExpr nodeUri(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for nodeUri() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "node-uri", new Object[]{ node });
  }

  
  @Override
  public XsUnsignedLongExpr not64(ServerExpression x) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for not64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "not64", new Object[]{ x });
  }

  
  @Override
  public XsIntegerExpr octalToInteger(ServerExpression octal) {
    if (octal == null) {
      throw new IllegalArgumentException("octal parameter for octalToInteger() cannot be null");
    }
    return new XsExprImpl.IntegerCallImpl("xdmp", "octal-to-integer", new Object[]{ octal });
  }

  
  @Override
  public XsUnsignedLongExpr or64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for or64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for or64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "or64", new Object[]{ x, y });
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, String value) {
    return parseDateTime(picture, (value == null) ? (XsStringExpr) null : xs.string(value));
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, ServerExpression value) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseDateTime() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseDateTime() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-dateTime", new Object[]{ picture, value });
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, String value, String language) {
    return parseDateTime(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, ServerExpression value, ServerExpression language) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseDateTime() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseDateTime() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-dateTime", new Object[]{ picture, value, language });
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, String value, String language, String calendar) {
    return parseDateTime(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar));
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, ServerExpression value, ServerExpression language, ServerExpression calendar) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseDateTime() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseDateTime() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-dateTime", new Object[]{ picture, value, language, calendar });
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, String value, String language, String calendar, String country) {
    return parseDateTime(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar), (country == null) ? (XsStringExpr) null : xs.string(country));
  }

  
  @Override
  public XsDateTimeExpr parseDateTime(ServerExpression picture, ServerExpression value, ServerExpression language, ServerExpression calendar, ServerExpression country) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseDateTime() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseDateTime() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-dateTime", new Object[]{ picture, value, language, calendar, country });
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, String value) {
    return parseYymmdd(picture, (value == null) ? (XsStringExpr) null : xs.string(value));
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, ServerExpression value) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseYymmdd() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseYymmdd() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-yymmdd", new Object[]{ picture, value });
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, String value, String language) {
    return parseYymmdd(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language));
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, ServerExpression value, ServerExpression language) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseYymmdd() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseYymmdd() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-yymmdd", new Object[]{ picture, value, language });
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, String value, String language, String calendar) {
    return parseYymmdd(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar));
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, ServerExpression value, ServerExpression language, ServerExpression calendar) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseYymmdd() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseYymmdd() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-yymmdd", new Object[]{ picture, value, language, calendar });
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, String value, String language, String calendar, String country) {
    return parseYymmdd(picture, (value == null) ? (XsStringExpr) null : xs.string(value), (language == null) ? (XsStringExpr) null : xs.string(language), (calendar == null) ? (XsStringExpr) null : xs.string(calendar), (country == null) ? (XsStringExpr) null : xs.string(country));
  }

  
  @Override
  public XsDateTimeExpr parseYymmdd(ServerExpression picture, ServerExpression value, ServerExpression language, ServerExpression calendar, ServerExpression country) {
    if (picture == null) {
      throw new IllegalArgumentException("picture parameter for parseYymmdd() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for parseYymmdd() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "parse-yymmdd", new Object[]{ picture, value, language, calendar, country });
  }

  
  @Override
  public XsStringExpr path(ServerExpression node) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for path() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "path", new Object[]{ node });
  }

  
  @Override
  public XsStringExpr path(ServerExpression node, boolean includeDocument) {
    return path(node, xs.booleanVal(includeDocument));
  }

  
  @Override
  public XsStringExpr path(ServerExpression node, ServerExpression includeDocument) {
    if (node == null) {
      throw new IllegalArgumentException("node parameter for path() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "path", new Object[]{ node, includeDocument });
  }

  
  @Override
  public XsIntegerExpr position(ServerExpression test, String target) {
    return position(test, (target == null) ? (XsStringExpr) null : xs.string(target));
  }

  
  @Override
  public XsIntegerExpr position(ServerExpression test, ServerExpression target) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "position", new Object[]{ test, target });
  }

  
  @Override
  public XsIntegerExpr position(ServerExpression test, String target, String collation) {
    return position(test, (target == null) ? (XsStringExpr) null : xs.string(target), (collation == null) ? (XsStringExpr) null : xs.string(collation));
  }

  
  @Override
  public XsIntegerExpr position(ServerExpression test, ServerExpression target, ServerExpression collation) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "position", new Object[]{ test, target, collation });
  }

  
  @Override
  public XsQNameExpr QNameFromKey(ServerExpression key) {
    if (key == null) {
      throw new IllegalArgumentException("key parameter for QNameFromKey() cannot be null");
    }
    return new XsExprImpl.QNameCallImpl("xdmp", "QName-from-key", new Object[]{ key });
  }

  
  @Override
  public XsIntegerExpr quarterFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "quarter-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsUnsignedLongExpr random() {
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "random", new Object[]{  });
  }

  
  @Override
  public XsUnsignedLongExpr random(ServerExpression max) {
    if (max == null) {
      throw new IllegalArgumentException("max parameter for random() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "random", new Object[]{ max });
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
    return new XsExprImpl.AnyURICallImpl("xdmp", "resolve-uri", new Object[]{ relative, base });
  }

  
  @Override
  public XsUnsignedLongExpr rshift64(ServerExpression x, long y) {
    return rshift64(x, xs.longVal(y));
  }

  
  @Override
  public XsUnsignedLongExpr rshift64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for rshift64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for rshift64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "rshift64", new Object[]{ x, y });
  }

  
  @Override
  public XsStringExpr sha1(ServerExpression data) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha1() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha1", new Object[]{ data });
  }

  
  @Override
  public XsStringExpr sha1(ServerExpression data, String encoding) {
    return sha1(data, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr sha1(ServerExpression data, ServerExpression encoding) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha1() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for sha1() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha1", new Object[]{ data, encoding });
  }

  
  @Override
  public XsStringExpr sha256(ServerExpression data) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha256() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha256", new Object[]{ data });
  }

  
  @Override
  public XsStringExpr sha256(ServerExpression data, String encoding) {
    return sha256(data, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr sha256(ServerExpression data, ServerExpression encoding) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha256() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for sha256() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha256", new Object[]{ data, encoding });
  }

  
  @Override
  public XsStringExpr sha384(ServerExpression data) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha384() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha384", new Object[]{ data });
  }

  
  @Override
  public XsStringExpr sha384(ServerExpression data, String encoding) {
    return sha384(data, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr sha384(ServerExpression data, ServerExpression encoding) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha384() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for sha384() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha384", new Object[]{ data, encoding });
  }

  
  @Override
  public XsStringExpr sha512(ServerExpression data) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha512() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha512", new Object[]{ data });
  }

  
  @Override
  public XsStringExpr sha512(ServerExpression data, String encoding) {
    return sha512(data, (encoding == null) ? (XsStringExpr) null : xs.string(encoding));
  }

  
  @Override
  public XsStringExpr sha512(ServerExpression data, ServerExpression encoding) {
    if (data == null) {
      throw new IllegalArgumentException("data parameter for sha512() cannot be null");
    }
    if (encoding == null) {
      throw new IllegalArgumentException("encoding parameter for sha512() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "sha512", new Object[]{ data, encoding });
  }

  
  @Override
  public XsUnsignedLongExpr step64(ServerExpression initial, ServerExpression step) {
    if (initial == null) {
      throw new IllegalArgumentException("initial parameter for step64() cannot be null");
    }
    if (step == null) {
      throw new IllegalArgumentException("step parameter for step64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "step64", new Object[]{ initial, step });
  }

  
  @Override
  public XsStringExpr strftime(ServerExpression format, String value) {
    return strftime(format, (value == null) ? (XsDateTimeExpr) null : xs.dateTime(value));
  }

  
  @Override
  public XsStringExpr strftime(ServerExpression format, ServerExpression value) {
    if (format == null) {
      throw new IllegalArgumentException("format parameter for strftime() cannot be null");
    }
    if (value == null) {
      throw new IllegalArgumentException("value parameter for strftime() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "strftime", new Object[]{ format, value });
  }

  
  @Override
  public XsDateTimeExpr timestampToWallclock(ServerExpression timestamp) {
    if (timestamp == null) {
      throw new IllegalArgumentException("timestamp parameter for timestampToWallclock() cannot be null");
    }
    return new XsExprImpl.DateTimeCallImpl("xdmp", "timestamp-to-wallclock", new Object[]{ timestamp });
  }

  
  @Override
  public NodeExpr toJson(ServerExpression item) {
    return new BaseTypeImpl.NodeCallImpl("xdmp", "to-json", new Object[]{ item });
  }

  
  @Override
  public XsQNameExpr type(ServerExpression value) {
    if (value == null) {
      throw new IllegalArgumentException("value parameter for type() cannot be null");
    }
    return new XsExprImpl.QNameCallImpl("xdmp", "type", new Object[]{ value });
  }

  
  @Override
  public XsStringExpr urlDecode(ServerExpression encoded) {
    if (encoded == null) {
      throw new IllegalArgumentException("encoded parameter for urlDecode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "url-decode", new Object[]{ encoded });
  }

  
  @Override
  public XsStringExpr urlEncode(ServerExpression plaintext) {
    if (plaintext == null) {
      throw new IllegalArgumentException("plaintext parameter for urlEncode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "url-encode", new Object[]{ plaintext });
  }

  
  @Override
  public XsStringExpr urlEncode(ServerExpression plaintext, boolean noSpacePlus) {
    return urlEncode(plaintext, xs.booleanVal(noSpacePlus));
  }

  
  @Override
  public XsStringExpr urlEncode(ServerExpression plaintext, ServerExpression noSpacePlus) {
    if (plaintext == null) {
      throw new IllegalArgumentException("plaintext parameter for urlEncode() cannot be null");
    }
    return new XsExprImpl.StringCallImpl("xdmp", "url-encode", new Object[]{ plaintext, noSpacePlus });
  }

  
  @Override
  public XsUnsignedLongExpr wallclockToTimestamp(ServerExpression timestamp) {
    if (timestamp == null) {
      throw new IllegalArgumentException("timestamp parameter for wallclockToTimestamp() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "wallclock-to-timestamp", new Object[]{ timestamp });
  }

  
  @Override
  public XsIntegerExpr weekFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "week-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsIntegerExpr weekdayFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "weekday-from-date", new Object[]{ arg });
  }

  
  @Override
  public XsUnsignedLongExpr xor64(ServerExpression x, ServerExpression y) {
    if (x == null) {
      throw new IllegalArgumentException("x parameter for xor64() cannot be null");
    }
    if (y == null) {
      throw new IllegalArgumentException("y parameter for xor64() cannot be null");
    }
    return new XsExprImpl.UnsignedLongCallImpl("xdmp", "xor64", new Object[]{ x, y });
  }

  
  @Override
  public XsIntegerExpr yeardayFromDate(ServerExpression arg) {
    return new XsExprImpl.IntegerCallImpl("xdmp", "yearday-from-date", new Object[]{ arg });
  }

  }
