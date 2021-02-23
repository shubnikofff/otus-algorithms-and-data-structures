package ru.otus.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.util.test.TestData;
import ru.otus.util.test.TestDataSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Quick sort")
class QuickSortTest {

    @TestFactory
    Stream<DynamicTest> sort() {
        return DynamicTest.stream(
                new TestDataSource("text"),
                QuickSortTest::generateDisplayName,
                this::executeTest
        );
    }

    private void executeTest(TestData testData) {
        final int[] expectedResult = toArray(testData.getOutput().get(0));
        final int[] array = toArray(testData.getInput().get(1));

        QuickSort.sort(array);

        assertArrayEquals(expectedResult, array);
    }

    private static String generateDisplayName(TestData testData) {
        return "with length " + testData.getInput().get(0);
    }

    private static int[] toArray(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
