package ru.otus;

import ru.otus.task.LuckyTicketTask;
import ru.otus.task.StringLengthTask;
import ru.otus.test.Test;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nRun test \"String length\"");
        Test.run(new StringLengthTask(), "strings");

        System.out.println("\nRun test \"Lucky ticket\"");
        Test.run(new LuckyTicketTask(), "tickets");
    }
}
