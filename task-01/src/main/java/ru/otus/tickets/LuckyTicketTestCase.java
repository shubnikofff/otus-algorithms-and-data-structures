package ru.otus.tickets;

import ru.otus.TestCase;
import ru.otus.TestData;

public class LuckyTicketTestCase implements TestCase {

    @Override
    public boolean execute(TestData data) {
        final long luckyTicketCount = LuckyTicketTask.run(Integer.parseInt(data.getInput().get(0)));
        return luckyTicketCount == Long.parseLong(data.getOutput().get(0));
    }
}
