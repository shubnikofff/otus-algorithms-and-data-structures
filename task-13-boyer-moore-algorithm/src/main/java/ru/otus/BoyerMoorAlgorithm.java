package ru.otus;

import java.util.Arrays;

public class BoyerMoorAlgorithm {

    private static final int NUMBER_OF_CHARS = 128;

    public static int indexOf(char[] text, char[] pattern) {
        final int[] shiftTable = makeShiftTable(pattern);
        final int[] offsetTable = makeOffsetTable(pattern);

        int textIdx = pattern.length - 1;
        while (textIdx < text.length) {

            int pattIdx = pattern.length - 1;
            while (pattern[pattIdx] == text[textIdx]) {
                if (pattIdx == 0) {
                    return textIdx;
                }

                textIdx--;
                pattIdx--;
            }

            textIdx += Math.max(offsetTable[pattern.length - 1 - pattIdx], shiftTable[text[textIdx]]);
        }

        return -1;
    }

    private static int[] makeShiftTable(char[] pattern) {
        final int[] table = new int[NUMBER_OF_CHARS];

        Arrays.fill(table, pattern.length);

        for (int i = 0; i < pattern.length - 2; i++) {
            table[pattern[i]] = pattern.length - i - 1;
        }

        return table;
    }

    private static int[] makeOffsetTable(char[] pattern) {
        final int[] table = new int[pattern.length];
        int lastPrefixPosition = pattern.length;

        for (int i = pattern.length; i > 0; i--) {
            if (isPrefix(pattern, i)) {
                lastPrefixPosition = i;
            }
            table[pattern.length - i] = lastPrefixPosition - i + pattern.length;
        }

        for (int i = 0; i < pattern.length - 1; i++) {
            final int suffixLength = suffixLength(pattern, i);
            table[suffixLength] = pattern.length - 1 - i + suffixLength;
        }

        return table;
    }

    private static boolean isPrefix(char[] pattern, int index) {
        for (int i = index, j = 0; i < pattern.length; i++, j++) {
            if (pattern[i] != pattern[j]) {
                return false;
            }
        }

        return true;
    }

    private static int suffixLength(char[] pattern, int index) {
        int length = 0;

        for (int i = index, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; i--, j--) {
            length++;
        }

        return length;
    }
}
