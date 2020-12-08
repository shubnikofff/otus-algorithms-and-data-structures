package ru.otus;

public class ShellSort {

	public static void shellSequence(int[] array) {

		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			InsertionSort.sort(array, gap);
		}

	}

	public static void knuthSequence(int[] array) {

		final int arrayLength = array.length;

		int gap = 1;
		while (gap < arrayLength / 3) {
			gap = 3 * gap +  1;
		}

		while (gap >= 1) {

			InsertionSort.sort(array, gap);
			gap /= 3;
		}

	}
}
