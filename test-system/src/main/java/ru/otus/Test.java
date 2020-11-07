package ru.otus;

public class Test {

    public static void run(TestDataSource dataSource, TestCase testCase) {
        dataSource.forEachRemaining(testData -> {
            final long startTime = System.currentTimeMillis();
            final String result = testCase.execute(testData) ? "SUCCESS" : "FAILED";
            final long executionTime = System.currentTimeMillis() - startTime;

            System.out.format("%s, Execution time: %d ms\n", result, executionTime);
        });
    }
}
