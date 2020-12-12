package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Shell Sort with Shell sequence")
class ShellSortShellSequenceTest extends AbstractSortTest {

	@Override
	void runSort(int[] array) {
		ShellSort.shellSequence(array);
	}
}
