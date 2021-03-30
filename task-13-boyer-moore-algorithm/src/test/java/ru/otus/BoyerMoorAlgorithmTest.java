package ru.otus;

import ru.otus.util.test.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoyerMoorAlgorithmTest extends AbstractAlgorithmTest {

	@Override
	protected void executeTest(TestData testData) {
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = BoyerMoorAlgorithm.indexOf(
				testData.getInput().get(1).toCharArray(),
				testData.getInput().get(0).toCharArray()
		);

		assertEquals(expected, result);
	}
}
