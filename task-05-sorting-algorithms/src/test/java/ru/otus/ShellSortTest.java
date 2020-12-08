package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest {

	@TestFactory
	@DisplayName("Random array")
	Stream<DynamicTest> testWithRandomArray() {
		return DynamicTest.stream(
				new TestDataSource("0.random"),
				ShellSortTest::generateDisplayName,
				ShellSortTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Digits array")
	Stream<DynamicTest> testWithDigitsArray() {
		return DynamicTest.stream(
				new TestDataSource("1.digits"),
				ShellSortTest::generateDisplayName,
				ShellSortTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Sorted array")
	Stream<DynamicTest> testWithSortedArray() {
		return DynamicTest.stream(
				new TestDataSource("2.sorted"),
				ShellSortTest::generateDisplayName,
				ShellSortTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Reversed array")
	Stream<DynamicTest> testWithReversedArray() {
		return DynamicTest.stream(
				new TestDataSource("3.revers"),
				ShellSortTest::generateDisplayName,
				ShellSortTest::executeTest
		);
	}

	private static void executeTest(TestData testData) {
		final int[] expectedResult = TestDataConverter.toExpectedResult(testData);
		final int[] array = TestDataConverter.toArray(testData);

		ShellSort.sort(array);

		assertArrayEquals(expectedResult, array);
	}

	private static String generateDisplayName(TestData testData) {
		return "with length " + testData.getInput().get(0);
	}

}
