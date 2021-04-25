package ru.otus;

import static ru.otus.util.Strings.substringLeft;
import static ru.otus.util.Strings.substringRight;

public class StateMachineAlgorithm {

	private static final int ALPHABET_SIZE = 26;

	public static int indexOf(String text, String pattern) {
		final int[][] stateMachine = makeStateMachine(pattern);
		int state = 0;

		for (int i = 0; i < text.length(); i++) {
			state = stateMachine[state][text.charAt(i) - 'A'];
			if (state == pattern.length()) {
				return i - pattern.length() + 1;
			}
		}

		return -1;
	}

	private static int[][] makeStateMachine(String pattern) {
		final int[][] stateMachine = new int[pattern.length()][ALPHABET_SIZE];

		for (int patternIdx = 0; patternIdx < pattern.length(); patternIdx++) {
			for (char letter = 'A'; letter <= 'Z'; letter++) {
				final String line = substringLeft(pattern, patternIdx) + letter;
				int state = patternIdx + 1;

				while (!substringLeft(pattern, state).equals(substringRight(line, state))) {
					state--;
				}

				stateMachine[patternIdx][letter - 'A'] = state;
			}
		}

		return stateMachine;
	}
}
