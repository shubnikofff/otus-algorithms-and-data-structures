package ru.otus;

public class RookBitMaskCalculator {

    static String calculate(int input) {

        final long initialPosition = 1L << input;
        long bitMask = 0L;

        for (long position = initialPosition << 8; position != 0; position <<= 8) {
            bitMask |= position;
        }

        for (long position = initialPosition << 1; (position & Bitboard.INVERTED_COLUMN_A) > 0; position <<= 1) {
            bitMask |= position;
        }

        for (long position = initialPosition >>> 8 ; position != 0; position >>>= 8) {
            bitMask |= position;
        }

        for (long position = initialPosition >>> 1; (position & Bitboard.INVERTED_COLUMN_H) > 0; position >>>= 1) {
            bitMask |= position;
        }

        return Long.toUnsignedString(bitMask);
    }
}
