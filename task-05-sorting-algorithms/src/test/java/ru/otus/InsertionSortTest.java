package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Insertion Sort")
class InsertionSortTest extends AbstractSortTest {

	@Override
	void runSort(int[] array) {
		InsertionSort.sort(array);
	}
}
