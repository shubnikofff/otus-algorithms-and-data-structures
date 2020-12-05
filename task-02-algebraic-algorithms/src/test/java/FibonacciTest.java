import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.fibonacci.GoldenRatioFibonacci;
import ru.otus.fibonacci.IterationFibonacci;
import ru.otus.fibonacci.MatrixMultiplyFibonacci;
import ru.otus.fibonacci.RecursionFibonacci;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @TestFactory
    @DisplayName("Recursion")
    Stream<DynamicTest> testRecursion() {
        return DynamicTest.stream(
                new TestDataSource("fibonacci"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), RecursionFibonacci.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Iteration")
    Stream<DynamicTest> testIteration() {
        return DynamicTest.stream(
                new TestDataSource("fibonacci"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), IterationFibonacci.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Golden Ratio")
    Stream<DynamicTest> testGoldenRation() {
        return DynamicTest.stream(
                new TestDataSource("fibonacci"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), GoldenRatioFibonacci.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Multiply Matrix")
    Stream<DynamicTest> testMultiplyMatrix() {
        return DynamicTest.stream(
                new TestDataSource("fibonacci"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), MatrixMultiplyFibonacci.count(getArgument(testData)))
        );
    }

    private static int getArgument(TestData testData) {
        return Integer.parseInt(testData.getInput().get(0));
    }

    private static BigInteger getExpectedResult(TestData testData) {
        return new BigInteger(testData.getOutput().get(0));
    }
}
