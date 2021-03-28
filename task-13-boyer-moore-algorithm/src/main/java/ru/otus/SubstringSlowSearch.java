package ru.otus;

public class SubstringSlowSearch {

	public static int find(String text, String pattern) {
		int t = 0;
		final int textLength = text.length();
		final int patternLength = pattern.length();
		final int last = patternLength - 1;

		while (t < textLength - last) {
			int p = 0;
			while (p <= last && text.charAt(t + p) == pattern.charAt(p)) {
				p++;
			}

			if (p == patternLength) {
				return t;
			}

			t++;
		}

		return -1;
	}
}
