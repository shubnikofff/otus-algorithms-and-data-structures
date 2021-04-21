package ru.otus;

import ru.otus.util.test.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnuthMorrisPrattAlgorithmFastAlgorithm extends AbstractAlgorithmTest {
	@Override
	protected void executeTest(TestData testData) {
		final KnuthMorrisPrattAlgorithm algorithm = new KnuthMorrisPrattAlgorithm(PiFunction.fastAlgorithm());
		final int expected = Integer.parseInt(testData.getOutput().get(0));
		final int result = algorithm.indexOf(testData.getInput().get(1), testData.getInput().get(0));

		assertEquals(expected, result);
	}
}
