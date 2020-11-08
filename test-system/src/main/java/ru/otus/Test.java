package ru.otus;

public class Test<I, O> {

    private final String name;

    private final TestDataSource dataSource;

    public Test(String name, TestDataSource dataSource) {
        this.name = name;
        this.dataSource = dataSource;
    }

    public void run(TestCase<I, O> testCase) {
        System.out.format("\nRun test \"%s\"\n", name);

        dataSource.forEachRemaining(testData -> {
            final long startTime = System.currentTimeMillis();
            final O result = testCase.execute(testCase.getInput(testData.getInput()));
            final long executionTime = System.currentTimeMillis() - startTime;
            final boolean isSuccess = result.equals(testCase.getOutput(testData.getOutput()));
            System.out.format("%s, Execution time: %d ms\n", isSuccess ? "SUCCESS" : "FAILED", executionTime);
        });
    }
}
