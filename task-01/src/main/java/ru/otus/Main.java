package ru.otus;

public class Main {
    public static void main(String[] args) {
        new TestRunner<String, Integer>("String length", new TestDataSource("strings")).run(new StringLength());
        new TestRunner<Integer, Long>("Lucky ticket", new TestDataSource("tickets")).run(new LuckyTicket());
    }
}
