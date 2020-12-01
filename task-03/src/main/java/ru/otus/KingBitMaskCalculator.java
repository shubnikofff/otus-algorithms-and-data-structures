package ru.otus;

public class KingBitMaskCalculator {

	public static String calculate(int input) {

		final long position = 1L << input;
		final long leftLimitPosition = position & Bitboard.INVERTED_COLUMN_A;
		final long rightLimitPosition = position & Bitboard.INVERTED_COLUMN_H;

		final long bitMask = leftLimitPosition << 7 | position << 8 | rightLimitPosition << 9 |
				leftLimitPosition >>> 1 | rightLimitPosition << 1 |
				leftLimitPosition >>> 9 | position >>> 8 | rightLimitPosition >>> 7;

		return Long.toUnsignedString(bitMask);
	}
}
