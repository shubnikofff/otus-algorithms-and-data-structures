package ru.otus;

import ru.otus.test.TestData;

import java.util.Arrays;

public class TestDataConverter {

    static int[] toArray(TestData testData) {
        return Arrays.stream(testData.getInput().get(1)
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static int[] toExpectedResult(TestData testData) {
        return Arrays.stream(testData.getOutput().get(0)
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
