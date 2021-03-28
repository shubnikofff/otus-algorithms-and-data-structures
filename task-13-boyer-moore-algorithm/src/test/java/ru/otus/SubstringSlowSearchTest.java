package ru.otus;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.util.test.TestData;
import ru.otus.util.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringSlowSearchTest {

	@TestFactory
	Stream<DynamicTest> find() {
		return DynamicTest.stream(
				new TestDataSource("text"),
				SubstringSlowSearchTest::generateDisplayName,
				this::executeTest
		);
	}

	private static String generateDisplayName(TestData testData) {
		return "with string length " + testData.getInput().get(1).length();
	}

	private void executeTest(TestData testData) {
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = SubstringSlowSearch.find(testData.getInput().get(1), testData.getInput().get(0));

		assertEquals(expected, result);
	}
}
