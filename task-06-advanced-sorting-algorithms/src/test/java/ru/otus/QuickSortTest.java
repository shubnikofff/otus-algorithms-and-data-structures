package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

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
        final short[] expectedResult = toArray(testData.getOutput().get(0));
        final short[] array = toArray(testData.getInput().get(1));

        QuickSort.sort(array);

        assertArrayEquals(expectedResult, array);
    }

    private static String generateDisplayName(TestData testData) {
        return "with length " + testData.getInput().get(0);
    }

    private static short[] toArray(String string) {
        final String[] strings = string.split(" ");
        final short[] shorts = new short[strings.length];

        for (int i = 0; i < strings.length; i++) {
            shorts[i] = Short.parseShort(strings[i]);
        }

        return shorts;
    }
}
