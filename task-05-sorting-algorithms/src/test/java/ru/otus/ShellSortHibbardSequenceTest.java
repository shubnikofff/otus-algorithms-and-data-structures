package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Shell Sort with Hibbard sequence")
class ShellSortHibbardSequenceTest extends AbstractSortTest {

	@Override
	void runSort(int[] array) {
		ShellSort.hibbardSequence(array);
	}
}
