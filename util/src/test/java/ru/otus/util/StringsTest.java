package ru.otus.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTest {

	private static final String STRING = "abcd";

	@Test
	void substringLeft() {
		assertEquals("abc", Strings.substringLeft(STRING, 3));
	}

	@Test
	void substringRight() {
		assertEquals("bcd", Strings.substringRight(STRING, 3));
	}
}
