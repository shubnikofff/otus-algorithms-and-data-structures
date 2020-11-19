package ru.otus;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KingBitsTest {

	@TestFactory
	Stream<DynamicTest> kingTests() {
		final KingBits kingBits = new KingBits();

		return DynamicTest.stream(
				new TestDataSource("king"),
				(testData) -> "With position: " + testData.getInput().get(0),
				(testData) -> {
					final Result expected = new Result(Integer.parseInt(testData.getOutput().get(0)), testData.getOutput().get(1));

					assertEquals(expected, kingBits.execute(Integer.parseInt(testData.getInput().get(0))));
				});
	}
}
