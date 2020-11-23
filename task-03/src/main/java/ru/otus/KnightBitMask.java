package ru.otus;

public class KnightBitMask {

    static String calculate(int input) {
        final long position = 1L << input;

        final long leftLimitPosition = position & Bitboard.INVERTED_COLUMN_A;
        final long doubleLeftLimitPosition = position & (Bitboard.INVERTED_COLUMN_A & Bitboard.INVERTED_COLUMN_B);
        final long rightLimitPosition = position & Bitboard.INVERTED_COLUMN_H;
        final long doubleRightLimitPosition = position & (Bitboard.INVERTED_COLUMN_G & Bitboard.INVERTED_COLUMN_H);

        final long mask = leftLimitPosition << 15 | rightLimitPosition << 17 |
                doubleRightLimitPosition << 10 | doubleRightLimitPosition >>> 6 |
                rightLimitPosition >>> 15 | leftLimitPosition >>> 17 |
                doubleLeftLimitPosition >>> 10 | doubleLeftLimitPosition << 6;

        return Long.toUnsignedString(mask);
    }
}
