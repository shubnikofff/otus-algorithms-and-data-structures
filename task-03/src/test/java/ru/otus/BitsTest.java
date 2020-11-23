package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitsTest {

    @TestFactory
    @DisplayName("King")
    Stream<DynamicTest> testKing() {
        return DynamicTest.stream(
                new TestDataSource("king"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), KingBits.calculate(getArgument(testData)))
        );
    }

    private static int getArgument(TestData testData) {
        return Integer.parseInt(testData.getInput().get(0));
    }

    private static Result getExpectedResult(TestData testData) {
        return new Result(Integer.parseInt(testData.getOutput().get(0)), testData.getOutput().get(1));
    }
}
