package ru.otus;

public class ShellSort {

	public static void sort(int[] array) {

		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			InsertionSort.sort(array, gap);
		}

	}
}
