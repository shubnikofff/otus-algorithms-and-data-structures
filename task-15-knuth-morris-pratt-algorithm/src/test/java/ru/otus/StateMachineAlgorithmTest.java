package ru.otus;

import ru.otus.util.test.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateMachineAlgorithmTest extends AbstractAlgorithmTest {

	@Override
	protected void executeTest(TestData testData) {
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = StateMachineAlgorithm.indexOf(testData.getInput().get(1), testData.getInput().get(0));

		assertEquals(expected, result);
	}
}
