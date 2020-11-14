package ru.otus;

import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRunner<I, O> {

	private final String testName;

	private final TestDataSource dataSource;

	public TestRunner(String testName, TestDataSource dataSource) {
		this.testName = testName;
		this.dataSource = dataSource;
	}

	public void run(TestCase<I, O> testCase) {
		System.out.println("\nTest \"" + testName + "\"");

		dataSource.forEachRemaining(testData -> {
			final Instant startTime = Instant.now();
			final I arguments = testCase.getArguments(testData.getInput());
			final O result = testCase.execute(arguments);
			final Instant endTime = Instant.now();

			try {
				final O expectedResult = testCase.getExpectedResult(testData.getOutput());
				assertEquals(expectedResult, result);
				System.out.println("SUCCESS, Execution time " + Duration.between(startTime, endTime).toMillis() + " ms");
			} catch (AssertionFailedError e) {
				System.out.println("FAILED, " + e.getMessage());
			}
		});
	}
}
