package ru.otus;

import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRunner {

	public static <I, O> void run(Testable<I, O> testable, TestDataSource  dataSource) {
		System.out.println("\nTest \"" + testable.getName() + "\"");

		dataSource.forEachRemaining(testData -> {
			final I arguments = testable.getArguments(testData.getInput());
			final Instant startTime = Instant.now();
			final O result = testable.execute(arguments);
			final long executionTime = Duration.between(startTime, Instant.now()).toMillis();

			try {
				final O expectedResult = testable.getExpectedResult(testData.getOutput());
				assertEquals(expectedResult, result);
				System.out.println("SUCCESS, Execution time " + executionTime + " ms");
			} catch (AssertionFailedError e) {
				System.out.println("FAILED, " + e.getMessage() + ",  Execution time: " + executionTime + " ms");
			}
		});
	}
}
