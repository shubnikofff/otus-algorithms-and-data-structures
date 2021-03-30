package ru.otus;

import java.util.Arrays;

public class BoyerMoorHorspoolAlgorithm {

	private static final int NUMBER_OF_CHARS = 128;

	public static int indexOf(char[] text, char[] pattern) {
		final int[] shiftTable = makeShiftTable(pattern);
		final int last = pattern.length - 1;
		int t = 0;

		while (t < text.length - last) {
			int p = pattern.length - 1;
			while (p >= 0 && text[t + p] == pattern[p]) {
				p--;
			}

			if (p == -1) {
				return t;
			}

			t += shiftTable[text[t + pattern.length - 1]];
		}

		return -1;
	}

	private static int[] makeShiftTable(char[] pattern) {
		final int[] table = new int[NUMBER_OF_CHARS];

		Arrays.fill(table, pattern.length);

		for (int i = 0; i < pattern.length - 1; i++) {
			table[pattern[i]] = pattern.length - i - 1;
		}

		return table;
	}
}
