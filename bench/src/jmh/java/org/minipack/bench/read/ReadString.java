/*
 * Copyright 2024 the minipack project authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.minipack.bench.read;

import java.io.IOException;
import net.jqwik.api.Arbitraries;
import org.minipack.core.MessageWriter;
import org.openjdk.jmh.infra.Blackhole;

public class ReadString extends ReadValue {
  @Override
  void writeValue(MessageWriter writer) throws IOException {
    var value = Arbitraries.strings().ofLength(256).sample();
    writer.write(value);
  }

  @Override
  void readValue(Blackhole hole) throws IOException {
    hole.consume(reader.readString());
  }

  @Override
  void readValueMp(Blackhole hole) throws IOException {
    hole.consume(unpacker.unpackString());
  }
}