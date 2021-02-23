package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.util.test.TestDataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

class StringsTest {

    @TestFactory
    @DisplayName("String length")
    Stream<DynamicTest> testLength() {
        return DynamicTest.stream(
                new TestDataSource("strings"),
                testData -> "With string: " + testData.getInput().get(0),
                testData -> assertEquals(parseOutput(testData.getOutput()), Strings.length(testData.getInput().get(0)))
        );
    }

    private int parseOutput(List<String> output) {
        return Integer.parseInt(output.get(0));
    }
}
