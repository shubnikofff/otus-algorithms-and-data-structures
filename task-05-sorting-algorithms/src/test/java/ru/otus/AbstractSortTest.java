package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class AbstractSortTest {

	@TestFactory
	@DisplayName("Random array")
	Stream<DynamicTest> testWithRandomArray() {
		return DynamicTest.stream(
				new TestDataSource("0.random"),
				AbstractSortTest::generateDisplayName,
				this::executeTest
		);
	}

	@TestFactory
	@DisplayName("Digits array")
	Stream<DynamicTest> testWithDigitsArray() {
		return DynamicTest.stream(
				new TestDataSource("1.digits"),
				AbstractSortTest::generateDisplayName,
				this::executeTest
		);
	}

	@TestFactory
	@DisplayName("Sorted array")
	Stream<DynamicTest> testWithSortedArray() {
		return DynamicTest.stream(
				new TestDataSource("2.sorted"),
				AbstractSortTest::generateDisplayName,
				this::executeTest
		);
	}

	@TestFactory
	@DisplayName("Reversed array")
	Stream<DynamicTest> testWithReversedArray() {
		return DynamicTest.stream(
				new TestDataSource("3.revers"),
				AbstractSortTest::generateDisplayName,
				this::executeTest
		);
	}

	private void executeTest(TestData testData) {
		final int[] expectedResult = toArray(testData.getOutput().get(0));
		final int[] array = toArray(testData.getInput().get(1));

		runSort(array);

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

	abstract void runSort(int[]  array);

}
