package edu.epam;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class SquashStringTest {

  @ParameterizedTest
  @MethodSource
  void squash(String input, String expected) {
    assertEquals(expected, SquashString.squash(input));
  }

  static Stream<Arguments> squash() {
    return Stream.of(
        arguments("ABC", "ABC"),
        arguments(null, null),
        arguments("", ""),
        arguments("ABBCCC", "AB2C3")
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "a",
      "1",
      "AB ",
      " AB",
      "A B",
      "  ",
      "A-B"
  })
  void squashFail(String input) {
    assertThrows(IllegalArgumentException.class, () -> SquashString.squash(input));
  }
}