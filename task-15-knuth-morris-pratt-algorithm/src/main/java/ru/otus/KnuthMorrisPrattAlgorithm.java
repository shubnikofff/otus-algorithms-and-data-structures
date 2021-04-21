package ru.otus;

public class KnuthMorrisPrattAlgorithm {

	private final PiFunction piFunction;

	public KnuthMorrisPrattAlgorithm(PiFunction piFunction) {
		this.piFunction = piFunction;
	}


	public int indexOf(String text, String pattern) {
		final int[] piTable = piFunction.makePiTable(pattern + "#" + text);
		final int position = findFirst(piTable, pattern.length());

		return position - 2 * pattern.length() - 1;
	}


	private int findFirst(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}

		return -1;
	}
}
