import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.otus.power.Arguments;
import ru.otus.power.BinaryWithMultiplyPower;
import ru.otus.power.FastPower;
import ru.otus.power.IterationPower;
import ru.otus.test.TestData;
import ru.otus.test.TestDataSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerTest {

    @DisplayName("Iteration")
    @TestFactory
    Stream<DynamicTest> testIteration() {
        return DynamicTest.stream(
                new TestDataSource("power"),
                testData -> testData.getInput().get(0) + "^" + testData.getInput().get(1),
                testData -> assertEquals(getExpectedResult(testData), IterationPower.count(getArguments(testData)))
        );
    }

    @DisplayName("Binary with Multiply")
    @TestFactory
    Stream<DynamicTest> testBinaryWitjMultiply() {
        return DynamicTest.stream(
                new TestDataSource("power"),
                testData -> testData.getInput().get(0) + "^" + testData.getInput().get(1),
                testData -> assertEquals(getExpectedResult(testData), BinaryWithMultiplyPower.count(getArguments(testData)))
        );
    }

    @DisplayName("Fast")
    @TestFactory
    Stream<DynamicTest> testFast() {
        return DynamicTest.stream(
                new TestDataSource("power"),
                testData -> testData.getInput().get(0) + "^" + testData.getInput().get(1),
                testData -> assertEquals(getExpectedResult(testData), FastPower.count(getArguments(testData)))
        );
    }

    private static Arguments getArguments(TestData testData) {
        return new Arguments(Double.parseDouble(testData.getInput().get(0)), Long.parseLong(testData.getInput().get(1)));
    }

    private static Double getExpectedResult(TestData testData) {
        return Double.parseDouble(testData.getOutput().get(0));
    }
}
