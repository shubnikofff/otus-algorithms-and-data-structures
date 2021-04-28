package ru.otus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RunLengthEncodingAlgorithmTest {

	@Test
	void encode() {
		final byte[] bytes = new byte[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9};
		final byte[] expected = new byte[]{-1, 1, 3, 2, -4, 3, 4, 5, 6, 3, 7, -2, 8, 9};

		assertArrayEquals(expected, RunLengthEncodingAlgorithm.encode(bytes));
	}

	@Test
	void decode() {
		final byte[] bytes = new byte[]{-1, 1, 3, 2, -4, 3, 4, 5, 6, 3, 7, -2, 8, 9};
		final byte[] expected = new byte[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9};

		assertArrayEquals(expected, RunLengthEncodingAlgorithm.decode(bytes));
	}
}
