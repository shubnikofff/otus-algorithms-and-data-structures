package ru.otus;

import java.util.List;

public interface TestCase<I, O> {

    O execute(I input);

    I getInput(List<String> input);

    O getOutput(List<String> output);
}
