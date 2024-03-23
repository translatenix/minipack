/*
 * Copyright 2024 the minipack project authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.translatenix.minipack.internal;

/** The type requested when reading a MessagePack value. */
public enum RequestedType {
  NIL,
  BOOLEAN,
  BYTE,
  SHORT,
  INT,
  LONG,
  FLOAT,
  DOUBLE,
  STRING,
  ARRAY,
  MAP,
  BINARY,
  EXTENSION
}
