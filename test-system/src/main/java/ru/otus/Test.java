package ru.otus;

import org.opentest4j.AssertionFailedError;

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
			final long startTime = System.currentTimeMillis();
			final O result = testCase.execute(testCase.getInput(testData.getInput()));
			final long executionTime = System.currentTimeMillis() - startTime;

			try {
				assertEquals(testCase.getOutput(testData.getOutput()), result);
				System.out.println("SUCCESS, Execution time " + executionTime + " ms");
			} catch (AssertionFailedError e) {
				System.out.println("FAILED, " + e.getMessage());
			}
		});
	}
}
