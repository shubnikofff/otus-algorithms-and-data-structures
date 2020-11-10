package ru.otus;

public class Main {
    public static void main(String[] args) {
        TestRunner.run(new StringLength(), new TestDataSource("strings"));
        TestRunner.run(new LuckyTicket(), new TestDataSource("tickets"));
    }
}
