package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Shell Sort with Knuth sequence")
class ShellSortKnuthSequenceTest extends AbstractSortTest {

	@Override
	void runSort(int[] array) {
		ShellSort.knuthSequence(array);
	}
}
