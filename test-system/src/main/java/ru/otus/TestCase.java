package ru.otus;

import java.util.List;

public interface TestCase<I, O> {

    O execute(I input);

    I getArguments(List<String> input);

    O getExpectedResult(List<String> output);
}
