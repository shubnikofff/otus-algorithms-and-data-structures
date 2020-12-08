package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Shell Sort with Shell sequence")
class ShellSortShellSequenceTest {

	@TestFactory
	@DisplayName("Random array")
	Stream<DynamicTest> testWithRandomArray() {
		return DynamicTest.stream(
				new TestDataSource("0.random"),
				ShellSortShellSequenceTest::generateDisplayName,
				ShellSortShellSequenceTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Digits array")
	Stream<DynamicTest> testWithDigitsArray() {
		return DynamicTest.stream(
				new TestDataSource("1.digits"),
				ShellSortShellSequenceTest::generateDisplayName,
				ShellSortShellSequenceTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Sorted array")
	Stream<DynamicTest> testWithSortedArray() {
		return DynamicTest.stream(
				new TestDataSource("2.sorted"),
				ShellSortShellSequenceTest::generateDisplayName,
				ShellSortShellSequenceTest::executeTest
		);
	}

	@TestFactory
	@DisplayName("Reversed array")
	Stream<DynamicTest> testWithReversedArray() {
		return DynamicTest.stream(
				new TestDataSource("3.revers"),
				ShellSortShellSequenceTest::generateDisplayName,
				ShellSortShellSequenceTest::executeTest
		);
	}

	private static void executeTest(TestData testData) {
		final int[] expectedResult = TestDataConverter.toExpectedResult(testData);
		final int[] array = TestDataConverter.toArray(testData);

		ShellSort.shellSequence(array);

		assertArrayEquals(expectedResult, array);
	}

	private static String generateDisplayName(TestData testData) {
		return "with length " + testData.getInput().get(0);
	}

}
