package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestDataSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyTicketTest {

    @TestFactory
    @DisplayName("Tickets count")
    Stream<DynamicTest> testCount() {
        return DynamicTest.stream(
                new TestDataSource("tickets"),
                testData -> "With digits number: " + testData.getInput().get(0),
                testData -> assertEquals(parseOutput(testData.getOutput()), LuckyTicket.count(parseInput(testData.getInput())))
                );
    }

    private int parseInput(List<String> input) {
        return Integer.parseInt(input.get(0));
    }

    private long parseOutput(List<String> output) {
        return Long.parseLong(output.get(0));
    }
}
