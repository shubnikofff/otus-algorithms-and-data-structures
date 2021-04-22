package ru.otus;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.util.test.TestData;
import ru.otus.util.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateMachineAlgorithmTest {

	@TestFactory
	Stream<DynamicTest> indexOf() {
		return DynamicTest.stream(
				new TestDataSource("text"),
				this::makeDisplayName,
				this::executeTest
		);
	}

	private String makeDisplayName(TestData testData) {
		return "with string length " + testData.getInput().get(1).length();
	}

	protected void executeTest(TestData testData) {
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = StateMachineAlgorithm.indexOf(testData.getInput().get(1), testData.getInput().get(0));

		assertEquals(expected, result);
	}
}
