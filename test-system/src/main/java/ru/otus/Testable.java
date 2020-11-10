package ru.otus;

import java.util.List;

public interface Testable<I, O> {

    String getName();

    O execute(I input);

    I getArguments(List<String> input);

    O getExpectedResult(List<String> output);
}
