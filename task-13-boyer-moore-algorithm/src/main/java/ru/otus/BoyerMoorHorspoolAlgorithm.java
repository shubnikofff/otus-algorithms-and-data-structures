package ru.otus;

import java.util.Arrays;

public class BoyerMoorHorspoolAlgorithm {

	public static int substring(String text, String pattern) {
		final int textLength = text.length();
		final int patternLength = pattern.length();
		final int last = patternLength - 1;
		final int[] shiftMap = getShiftMap(pattern);

		int t = 0;
		while (t < textLength - last) {
			int p = last;
			while (p >= 0 && text.charAt(t + p) == pattern.charAt(p)) {
				p--;
			}

			if (p == -1) {
				return t;
			}

			t += shiftMap[text.charAt(t + last)];
		}

		return -1;
	}

	private static int[] getShiftMap(String pattern) {
		final int[] shiftMap = new int[128];
		final int patternLength = pattern.length();

		Arrays.fill(shiftMap, patternLength);

		for (int p = 0; p < patternLength - 1; p++) {
			shiftMap[pattern.charAt(p)] = patternLength - p - 1;
		}

		return shiftMap;
	}
}
