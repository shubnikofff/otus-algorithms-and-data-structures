package ru.otus.task;

public class StringLengthTask implements Task {

    @Override
    public String execute(String input) {
        return String.valueOf(input.length());
    }
}
