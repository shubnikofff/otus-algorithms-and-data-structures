package ru.otus.fibonacci;

import java.math.BigInteger;

public class RecursionFibonacci extends AbstractFibonacci {

	@Override
	public String getName() {
		return "Recursion Fibonacci";
	}

	@Override
	public BigInteger execute(Long index) {
		if (index < 2) {
			return BigInteger.valueOf(index);
		}

		return execute(index - 1).add(execute(index - 2));
	}
}
