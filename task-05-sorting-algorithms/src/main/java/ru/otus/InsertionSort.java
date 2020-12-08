package ru.otus;

public class InsertionSort {

	static void sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int buffer = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > buffer) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = buffer;
		}

	}

	static void sort(int[] array, int gap) {

		for (int i = 0; i + gap < array.length; i++) {
			int j = i + gap;
			int buffer = array[j];

			while (j - gap >= 0 && array[j - gap] > buffer) {
				array[j] = array[j - gap];
				j -= gap;
			}

			array[j] = buffer;
		}

	}
}
