package ru.otus.job;

import ru.otus.task.Task;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Job {

    private final int index;

    private final String resourcePath;

    public Job(int index, String resourcePath) {
        this.index = index;
        this.resourcePath = resourcePath;
    }

    public JobResult run(Task task) throws IOException {
        final String input = readFile(resourcePath + File.separator + "test." + index + ".in");
        final String expectedResult = readFile(resourcePath + File.separator + "test." + index + ".out");
        final long startTime = System.currentTimeMillis();
        String result = task.execute(input);
        return new JobResult(System.currentTimeMillis() - startTime, result.equals(expectedResult));
    }

    private String readFile(String name) throws IOException {
        final InputStream resourceStream = Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(name))
                .orElseThrow(() -> new IOException("Could not find file " + name));

        try(InputStreamReader streamReader = new InputStreamReader(resourceStream, StandardCharsets.UTF_8)) {
            final BufferedReader bufferedReader = new BufferedReader(streamReader);
            return bufferedReader.readLine();
        }
    }
}
