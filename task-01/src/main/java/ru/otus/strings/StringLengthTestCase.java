package ru.otus.strings;

import ru.otus.TestCase;
import ru.otus.TestData;

public class StringLengthTestCase implements TestCase {

    @Override
    public boolean execute(TestData data) {
        final int length = StringLengthTask.run(data.getInput().get(0));
        return length == Integer.parseInt(data.getOutput().get(0));
    }
}
