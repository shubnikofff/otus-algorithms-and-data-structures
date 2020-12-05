package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @TestFactory
    @DisplayName("Random array")
    Stream<DynamicTest> testWithRandomArray() {
        return DynamicTest.stream(
          new TestDataSource("0.random"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(getExpectedResult(testData), InsertionSort.sort(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Digits array")
    Stream<DynamicTest> testWithDigitsArray() {
        return DynamicTest.stream(
                new TestDataSource("1.digits"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(getExpectedResult(testData), InsertionSort.sort(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Sorted array")
    Stream<DynamicTest> testWithSortedArray() {
        return DynamicTest.stream(
                new TestDataSource("2.sorted"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(getExpectedResult(testData), InsertionSort.sort(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Reversed array")
    Stream<DynamicTest> testWithReversedArray() {
        return DynamicTest.stream(
                new TestDataSource("3.revers"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(getExpectedResult(testData), InsertionSort.sort(getArgument(testData)))
        );
    }

    private int[] getArgument(TestData testData) {
        return Arrays.stream(testData.getInput().get(1)
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int[] getExpectedResult(TestData testData) {
        return Arrays.stream(testData.getOutput().get(0)
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
