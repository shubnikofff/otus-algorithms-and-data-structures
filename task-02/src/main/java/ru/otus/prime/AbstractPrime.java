package ru.otus.prime;

import ru.otus.Testable;

import java.util.List;

public abstract class AbstractPrime implements Testable<Integer, Integer> {
    @Override
    public Integer getArguments(List<String> input) {
        return Integer.parseInt(input.get(0));
    }

    @Override
    public Integer getExpectedResult(List<String> output) {
        return Integer.parseInt(output.get(0));
    }
}
