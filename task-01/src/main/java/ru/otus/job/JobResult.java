package ru.otus.job;

public class JobResult {

    final long executionTime;

    final boolean isSuccess;

    public JobResult(long executionTime, boolean isSuccess) {
        this.executionTime = executionTime;
        this.isSuccess = isSuccess;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
