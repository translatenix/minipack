/*
 * Copyright 2024 the MiniPack contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package io.github.odenix.minipack.core.example;

import org.junit.jupiter.api.Test;
import io.github.odenix.minipack.core.LeasedByteBuffer;
import io.github.odenix.minipack.core.MessageReader;
import io.github.odenix.minipack.core.MessageWriter;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class WriteToBuffer extends Example {
  // -8<- [start:snippet]
  LeasedByteBuffer write() throws IOException {
    var output = MessageWriter.BufferOutput.of();
    try (var writer = MessageWriter.of(output)) {
      writer.write("Hello, MiniPack!");
      writer.write(42);
    }
    return output.get();
  }
  // -8<- [end:snippet]

  @Test
  void test() throws IOException {
    var buffer = write();
    var reader = MessageReader.of(buffer);
    assertThat(reader.readString()).isEqualTo("Hello, MiniPack!");
    assertThat(reader.readInt()).isEqualTo(42);
  }
}