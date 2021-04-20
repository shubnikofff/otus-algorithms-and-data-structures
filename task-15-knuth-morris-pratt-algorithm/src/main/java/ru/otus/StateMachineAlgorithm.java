package ru.otus;

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
				final String line = pattern.substring(0, patternIdx) + letter;
				int patternPosition = patternIdx + 1;
				while (!pattern.substring(0, patternPosition).equals(line.substring(patternPosition))) {
					patternPosition--;
				}

				stateMachine[patternIdx][letter - 'A'] = patternPosition;
			}
		}

		return stateMachine;
	}
}
