package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Merge sort")
class MergeSortTest {

	@TestFactory
	Stream<DynamicTest> sort() {
		return DynamicTest.stream(
				new TestDataSource("numbers"),
				MergeSortTest::generateDisplayName,
				this::executeTest
		);
	}

	private void executeTest(TestData testData) {
		final int[] expectedResult = toArray(testData.getOutput().get(0));
		final int[] array = toArray(testData.getInput().get(1));

		MergeSort.sort(array);

		assertArrayEquals(expectedResult, array);
	}

	private static String generateDisplayName(TestData testData) {
		return "with length " + testData.getInput().get(0);
	}

	private static int[] toArray(String string) {
		return Arrays.stream(string.split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
