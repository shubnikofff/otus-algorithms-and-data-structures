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
                testData -> {
                    final String bitMask = KingBitMask.calculate(getArgument(testData));
                    assertEquals(getExpectedBitmask(testData), bitMask);
                    assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("Knight")
    Stream<DynamicTest> testKnight() {
        return DynamicTest.stream(
                new TestDataSource("knight"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = KnightBitMask.calculate(getArgument(testData));
                    assertEquals(getExpectedBitmask(testData), bitMask);
                    assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    private static int getArgument(TestData testData) {
        return Integer.parseInt(testData.getInput().get(0));
    }

    private static int getExpectedMovesCount(TestData testData) {
        return Integer.parseInt(testData.getOutput().get(0));
    }

    private static String getExpectedBitmask(TestData testData) {
        return testData.getOutput().get(1);
    }
}
