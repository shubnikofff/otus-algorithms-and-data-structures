package ru.otus;

public class KingBits {

	private final static long INVERTED_COLUMN_A = 0xFEFEFEFEFEFEFEFEL;
	private final static long INVERTED_COLUMN_H = 0x7F7F7F7F7F7F7F7FL;

	public static String bitMask(int input) {
		final long position = 1L << input;
		final long leftBoard = position & INVERTED_COLUMN_A;
		final long rightBoard = position & INVERTED_COLUMN_H;
		final long mask = leftBoard << 7 | position << 8 | rightBoard << 9 |
				leftBoard >>> 1 | rightBoard << 1 |
				leftBoard >>> 9 | position >>> 8 | rightBoard >>> 7;

		return Long.toUnsignedString(mask);
	}
}
