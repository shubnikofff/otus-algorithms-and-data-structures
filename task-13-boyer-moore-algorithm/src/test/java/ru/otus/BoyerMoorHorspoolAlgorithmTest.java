package ru.otus;

import ru.otus.util.test.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoyerMoorHorspoolAlgorithmTest extends AbstractAlgorithmTest {

	@Override
	protected void executeTest(TestData testData) {
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = BoyerMoorHorspoolAlgorithm.substring(testData.getInput().get(1), testData.getInput().get(0));

		assertEquals(expected, result);
	}
}
