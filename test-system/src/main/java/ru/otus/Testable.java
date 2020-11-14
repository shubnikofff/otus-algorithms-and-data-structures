package ru.otus;

import java.util.List;

public interface Testable<I, O> {

    O execute(I input);

    I getArguments(List<String> input);

    O getExpectedResult(List<String> output);

    String getName();
}
