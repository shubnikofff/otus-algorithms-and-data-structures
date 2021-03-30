package ru.otus;

public class SimpleSubstringSearch {

	public static int indexOf(char[] text, char[] pattern) {

		for (int t = 0; t <= text.length - pattern.length; t++) {
			int p = 0;
			while (p <= pattern.length - 1 && text[t + p] == pattern[p]) {
				p++;
			}

			if (p == pattern.length) {
				return t;
			}
		}

		return -1;
	}
}
