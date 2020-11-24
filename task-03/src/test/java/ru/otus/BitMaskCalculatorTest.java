package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitMaskCalculatorTest {

    @TestFactory
    @DisplayName("For King")
    Stream<DynamicTest> testKing() {
        return DynamicTest.stream(
                new TestDataSource("king"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = KingBitMaskCalculator.calculate(getArgument(testData));
                    assertEquals(getExpectedBitmask(testData), bitMask);
                    assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("For Knight")
    Stream<DynamicTest> testKnight() {
        return DynamicTest.stream(
                new TestDataSource("knight"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = KnightBitMaskCalculator.calculate(getArgument(testData));
                    assertEquals(getExpectedBitmask(testData), bitMask);
                    assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("For Bishop")
    Stream<DynamicTest> testBishop() {
        return DynamicTest.stream(
                new TestDataSource("bishop"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = BishopBitMaskCalculator.calculate(getArgument(testData));
                    assertEquals(getExpectedBitmask(testData), bitMask);
                    assertEquals(getExpectedMovesCount(testData), PopulationCounter.count(bitMask));
                }
        );
    }

    @TestFactory
    @DisplayName("For Rook")
    Stream<DynamicTest> testRook() {
        return DynamicTest.stream(
                new TestDataSource("rook"),
                testData -> "With position: " + testData.getInput().get(0),
                testData -> {
                    final String bitMask = RookBitMaskCalculator.calculate(getArgument(testData));
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
