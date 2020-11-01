package ru.otus;

import ru.otus.task.StringLengthTask;
import ru.otus.test.Test;

public class Main {
    public static void main(String[] args) {
        new Test("String length", new StringLengthTask(), "strings").run();
    }
}
