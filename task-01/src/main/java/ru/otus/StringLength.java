package ru.otus;

import ru.otus.TestCase;

import java.util.List;

public class StringLength implements TestCase<String, Integer> {

    @Override
    public Integer execute(String input) {
        return input.length();
    }

    @Override
    public String getInput(List<String> input) {
        return input.get(0);
    }

    @Override
    public Integer getOutput(List<String> output) {
        return Integer.parseInt(output.get(0));
    }
}
