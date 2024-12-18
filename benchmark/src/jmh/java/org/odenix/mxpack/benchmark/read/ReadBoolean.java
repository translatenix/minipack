/*
 * Copyright 2024 the MxPack project authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.odenix.mxpack.benchmark.read;

import java.io.IOException;
import java.util.Random;
import org.odenix.mxpack.core.MessageWriter;
import org.openjdk.jmh.infra.Blackhole;

@SuppressWarnings("unused")
public class ReadBoolean extends ReadValues {
  @Override
  void write256Values(MessageWriter writer) throws IOException {
    var random = new Random();
    for (int i = 0; i < 256; i++) {
      writer.write(random.nextBoolean());
    }
  }

  @Override
  void readValue(Blackhole hole) throws IOException {
    hole.consume(reader.readBoolean());
  }

  @Override
  void readValueMp(Blackhole hole) throws IOException {
    hole.consume(unpacker.unpackBoolean());
  }
}
