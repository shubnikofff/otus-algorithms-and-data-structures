package ru.otus;

public class MergeSort {

	public static void sort(int[] array) {
		sort(0, array.length - 1, array);
	}

	private static void sort(int left, int right, int[] array) {
		if (left >= right) {
			return;
		}

		final int pivot = (left + right) / 2;

		sort(left, pivot, array);
		sort(pivot + 1, right, array);
		merge(left, pivot, right, array);
	}

	private static void merge(int left, int pivot, int right, int[] array) {
		final int[] result = new int[right - left + 1];
		int l = left;
		int r = pivot + 1;
		int res = 0;

		while (l <= pivot && r <= right) {
			if (array[l] < array[r]) {
				result[res++] = array[l++];
			} else {
				result[res++] = array[r++];
			}
		}

		while (l <= pivot) {
			result[res++] = array[l++];
		}

		while (r <= right) {
			result[res++] = array[r++];
		}

		for (int i = left; i <= right; i++) {
			array[i] = result[i - left];
		}
	}
}
