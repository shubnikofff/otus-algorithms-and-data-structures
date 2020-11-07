package ru.otus;

import ru.otus.strings.StringLengthTestCase;
import ru.otus.tickets.LuckyTicketTestCase;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nRun test \"String length\"");
        Test.run(new TestDataSource("strings"), new StringLengthTestCase());

        System.out.println("\nRun test \"Lucky ticket\"");
        Test.run(new TestDataSource("tickets"), new LuckyTicketTestCase());
    }
}
