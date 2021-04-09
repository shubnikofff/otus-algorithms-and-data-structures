package ru.otus;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.util.test.TestData;
import ru.otus.util.test.TestDataSource;

import java.util.stream.Stream;

abstract class AbstractAlgorithmTest {

	@TestFactory
	Stream<DynamicTest> find() {
		return DynamicTest.stream(
				new TestDataSource("text"),
				AbstractAlgorithmTest::generateDisplayName,
				this::executeTest
		);
	}

	private static String generateDisplayName(TestData testData) {
		return "with string length " + testData.getInput().get(1).length();
	}

	abstract protected void executeTest(TestData testData);

}
