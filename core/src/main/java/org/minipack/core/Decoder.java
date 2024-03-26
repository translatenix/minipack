/*
 * Copyright 2024 the minipack project authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.minipack.core;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.minipack.core.internal.IdentifierDecoder;
import org.minipack.core.internal.StringDecoder;

public interface Decoder<T> {
  static Decoder<String> defaultStringDecoder(int sizeLimit) {
    return new StringDecoder(sizeLimit);
  }

  static Decoder<String> defaultIdentifierDecoder(int cacheSizeLimit) {
    return new IdentifierDecoder(cacheSizeLimit);
  }

  T decode(ByteBuffer buffer, MessageSource source) throws IOException;
}