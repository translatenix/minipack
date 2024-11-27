/*
 * Copyright 2024 the MiniPack contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package io.github.odenix.minipack.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LeasedCharBufferTest {
  @Test
  void cannotGetBufferAfterClose() {
    var buffer = BufferAllocator.ofUnpooled().getCharBuffer(123);
    buffer.close();
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> buffer.get());
  }

  @Test
  void canBeClosedMultipleTimes() {
    var buffer = BufferAllocator.ofUnpooled().getCharBuffer(123);
    assertThatCode(() -> {
      buffer.close();
      buffer.close();
      buffer.close();
    }).doesNotThrowAnyException();
  }
}