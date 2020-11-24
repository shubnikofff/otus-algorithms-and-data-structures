package ru.otus.fibonacci;

import ru.otus.Testable;

import java.math.BigInteger;
import java.util.List;

public abstract class AbstractFibonacci implements Testable<Integer, BigInteger> {
	@Override
	public Integer getArguments(List<String> input) {
		return Integer.parseInt(input.get(0));
	}

	@Override
	public BigInteger getExpectedResult(List<String> output) {
		return new BigInteger(output.get(0));
	}
}
