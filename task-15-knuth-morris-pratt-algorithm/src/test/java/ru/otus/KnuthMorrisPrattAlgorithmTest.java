package ru.otus;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import ru.otus.util.test.TestData;
import ru.otus.util.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnuthMorrisPrattAlgorithmTest {

    @TestFactory
    Stream<DynamicTest> slowAlgorithm() {
        return DynamicTest.stream(
                new TestDataSource("text"),
                this::makeDisplayName,
                makeTestExecutor(PiFunction.slowAlgorithm())
        );
    }

    @TestFactory
    Stream<DynamicTest> fastAlgorithm() {
        return DynamicTest.stream(
                new TestDataSource("text"),
                this::makeDisplayName,
                makeTestExecutor(PiFunction.fastAlgorithm())
        );
    }

    private String makeDisplayName(TestData testData) {
        return "with string length " + testData.getInput().get(1).length();
    }

    private ThrowingConsumer<TestData> makeTestExecutor(PiFunction piFunction) {
        return testData -> {
            final KnuthMorrisPrattAlgorithm algorithm = new KnuthMorrisPrattAlgorithm(piFunction);
            final int expected = Integer.parseInt(testData.getOutput().get(0));
            final int result = algorithm.indexOf(testData.getInput().get(1), testData.getInput().get(0));

            assertEquals(expected, result);
        };
    }
}
