package ru.otus.test;

import ru.otus.job.Job;
import ru.otus.job.JobResult;
import ru.otus.task.Task;

import java.io.IOException;

public class Test {

    private final Task task;

    private final String resourcePath;

    public Test(Task task, String resourcePath) {
        this.task = task;
        this.resourcePath = resourcePath;
    }

    public void run() {
        int index = 0;
        while (true) {
            try {
                System.out.println("Run task #" + index);
                JobResult result = new Job(index, resourcePath).run(task);
                System.out.format("%s Execution time: %dms\n", result.isSuccess() ? "SUCCESS" : "FAILED", result.getExecutionTime());
                index++;
            } catch (IOException e) {
                break;
            }
        }
    }
}
