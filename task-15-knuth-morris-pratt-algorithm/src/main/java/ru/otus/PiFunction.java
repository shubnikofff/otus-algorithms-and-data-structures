package ru.otus;

import static ru.otus.util.Strings.substringLeft;
import static ru.otus.util.Strings.substringRight;

public interface PiFunction {

	int[] makePiTable(String pattern);

	static PiFunction slowAlgorithm() {
		return pattern -> {
			final int[] piTable = new int[pattern.length() + 1];

			for (int patternIdx = 0; patternIdx <= pattern.length(); patternIdx++) {
				for (int state = 0; state < patternIdx; state++) {
					final String prefix = substringLeft(substringLeft(pattern, patternIdx), state);
					final String suffix = substringRight(substringLeft(pattern, patternIdx), state);

					if(prefix.equals(suffix)) {
						piTable[patternIdx] = state;
					}
				}
			}

			return piTable;
		};
	}

	static PiFunction fastAlgorithm() {
		return pattern -> {
			final int[] piTable = new int[pattern.length() + 1];

			for (int patternIdx = 1; patternIdx < pattern.length(); patternIdx++) {
				int state = piTable[patternIdx - 1];

				while (state > 0 && pattern.charAt(state) != pattern.charAt(patternIdx)) {
					state = piTable[state - 1];
				}

				if(pattern.charAt(state) == pattern.charAt(patternIdx)) {
					state++;
				}

				piTable[patternIdx] = state;
			}

			return piTable;
		};
	}

}
