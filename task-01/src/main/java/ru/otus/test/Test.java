package ru.otus.test;

import ru.otus.job.Job;
import ru.otus.job.JobResult;
import ru.otus.task.Task;

import java.io.IOException;

public class Test {

    private final String name;

    private final Task task;

    private final String resourcePath;

    public Test(String name, Task task, String resourcePath) {
        this.name = name;
        this.task = task;
        this.resourcePath = resourcePath;
    }

    public void run() {
        System.out.println("Run test \"" + name + "\"");
        int index = 0;
        while (true) {
            try {
                JobResult result = new Job(index, resourcePath).run(task);
                System.out.format("Case %d: %s, Execution time: %dms\n", index, result.isSuccess() ? "SUCCESS" : "FAILED", result.getExecutionTime());
                index++;
            } catch (IOException e) {
                break;
            }
        }
    }
}
