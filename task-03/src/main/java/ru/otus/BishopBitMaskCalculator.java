package ru.otus;

public class BishopBitMaskCalculator {

	static String calculate(int input) {

		final long initialPosition = 1L << input;
		long bitMask = 0L;

		for (long position = initialPosition << 9; (position & Bitboard.INVERTED_COLUMN_A) > 0 || position == Long.MIN_VALUE; position <<= 9) {
			bitMask |= position;
		}

		for (long position = initialPosition >>> 7; (position & Bitboard.INVERTED_COLUMN_A) > 0; position >>>= 7) {
			bitMask |= position;
		}

		for (long position = initialPosition >>> 9 ; (position & Bitboard.INVERTED_COLUMN_H) > 0; position >>>= 9) {
			bitMask |= position;
		}

		for (long position = initialPosition << 7; (position & Bitboard.INVERTED_COLUMN_H) > 0; position <<= 7) {
			bitMask |= position;
		}

		return Long.toUnsignedString(bitMask);
	}
}
