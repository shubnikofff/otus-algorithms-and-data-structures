package ru.otus;

import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test<I, O> {

	private final String name;

	private final TestDataSource dataSource;

	public Test(String name, TestDataSource dataSource) {
		this.name = name;
		this.dataSource = dataSource;
	}

	public void run(TestCase<I, O> testCase) {
		System.out.println("\nTest \"" + name + "\"");

		dataSource.forEachRemaining(testData -> {
			final Instant startTime = Instant.now();
			final O result = testCase.execute(testCase.getInput(testData.getInput()));
			final Instant endTime = Instant.now();

			try {
				assertEquals(testCase.getOutput(testData.getOutput()), result);
				System.out.println("SUCCESS, Execution time " + Duration.between(startTime, endTime).toMillis() + " ms");
			} catch (AssertionFailedError e) {
				System.out.println("FAILED, " + e.getMessage());
			}
		});
	}
}
