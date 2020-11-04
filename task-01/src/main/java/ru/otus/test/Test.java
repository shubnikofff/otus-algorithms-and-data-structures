package ru.otus.test;

import ru.otus.job.Job;
import ru.otus.job.JobResult;
import ru.otus.task.Task;

import java.io.IOException;

public class Test {

    public static void run(Task task, String resourcePath) {

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
