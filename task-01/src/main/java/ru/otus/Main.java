package ru.otus;

public class Main {
    public static void main(String[] args) {
        new TestRunner<String, Integer>(new TestDataSource("strings")).run(new StringLength());
        new TestRunner<Integer, Long>(new TestDataSource("tickets")).run(new LuckyTicket());
    }
}
