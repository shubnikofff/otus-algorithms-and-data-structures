import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.prime.*;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesTest {

    @TestFactory
    @DisplayName("Iteration")
    Stream<DynamicTest> testIteratin() {
        final IterationPrime iterationPrime = new IterationPrime();
        return DynamicTest.stream(
                new TestDataSource("primes"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), iterationPrime.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Optimized iteration")
    Stream<DynamicTest> testOptimizedIteratin() {
        final OptimizedIterationPrime optimizedIterationPrime = new OptimizedIterationPrime();
        return DynamicTest.stream(
                new TestDataSource("primes"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), optimizedIterationPrime.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Iteration with cache")
    Stream<DynamicTest> testCashedIteration() {
        return DynamicTest.stream(
                new TestDataSource("primes"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), CachedIterationPrime.count(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Eratosthenes Sieve")
    Stream<DynamicTest> testEratosthenesSieve() {
        return DynamicTest.stream(
                new TestDataSource("primes"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), EratosthenesSieve.countPrimes(getArgument(testData)))
        );
    }

    @TestFactory
    @DisplayName("Linear Eratosthenes Sieve")
    Stream<DynamicTest> testLinearEratosthenesSieve() {
        return DynamicTest.stream(
                new TestDataSource("primes"),
                testData -> "of " + testData.getInput().get(0),
                testData -> assertEquals(getExpectedResult(testData), LinearEratosthenesSieve.countPrimes(getArgument(testData)))
        );
    }

    private static Integer getArgument(TestData testData) {
        return Integer.parseInt(testData.getInput().get(0));
    }

    private static Integer getExpectedResult(TestData testData) {
        return Integer.parseInt(testData.getOutput().get(0));
    }
}
