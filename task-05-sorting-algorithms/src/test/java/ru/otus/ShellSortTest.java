package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest {

    @TestFactory
    @DisplayName("Random array")
    Stream<DynamicTest> testWithRandomArray() {
        return DynamicTest.stream(
                new TestDataSource("0.random"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(
                        TestDataConverter.toExpectedResult(testData),
                        ShellSort.sort(TestDataConverter.toArgument(testData))
                )
        );
    }

    @TestFactory
    @DisplayName("Digits array")
    Stream<DynamicTest> testWithDigitsArray() {
        return DynamicTest.stream(
                new TestDataSource("1.digits"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(
                        TestDataConverter.toExpectedResult(testData),
                        ShellSort.sort(TestDataConverter.toArgument(testData))
                ));
    }

    @TestFactory
    @DisplayName("Sorted array")
    Stream<DynamicTest> testWithSortedArray() {
        return DynamicTest.stream(
                new TestDataSource("2.sorted"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(
                        TestDataConverter.toExpectedResult(testData),
                        ShellSort.sort(TestDataConverter.toArgument(testData))
                ));
    }

    @TestFactory
    @DisplayName("Reversed array")
    Stream<DynamicTest> testWithReversedArray() {
        return DynamicTest.stream(
                new TestDataSource("3.revers"),
                testData -> "with length " + testData.getInput().get(0),
                testData -> assertArrayEquals(
                        TestDataConverter.toExpectedResult(testData),
                        ShellSort.sort(TestDataConverter.toArgument(testData))
                ));
    }

}