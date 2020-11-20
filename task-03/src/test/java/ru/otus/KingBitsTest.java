package ru.otus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.test.TestDataSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KingBitsTest {

    @TestFactory
    @DisplayName("Test getting bitmask with population count")
    Stream<DynamicTest> testBitMaskWithPopulationCount() {
        final KingBits kingBits = new KingBits();

        return DynamicTest.stream(
                new TestDataSource("king"),
                (testData) -> "With position: " + testData.getInput().get(0),
                (testData) -> assertEquals(parseOutput(testData.getOutput()), kingBits.execute(parseInput(testData.getInput()))));
    }

    private static int parseInput(List<String> input) {
        return Integer.parseInt(input.get(0));
    }

    private static Result parseOutput(List<String> output) {
        return new Result(Integer.parseInt(output.get(0)), output.get(1));
    }
}
