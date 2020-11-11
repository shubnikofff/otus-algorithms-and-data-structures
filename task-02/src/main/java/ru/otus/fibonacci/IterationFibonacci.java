package ru.otus.fibonacci;

import java.math.BigInteger;

public class IterationFibonacci extends AbstractFibonacci {
	@Override
	public String getName() {
		return "Iteration Fibonacci";
	}

	@Override
	public BigInteger execute(Long index) {
		if (index == 0) {
			return BigInteger.valueOf(0);
		}

		BigInteger first = BigInteger.valueOf(0);
		BigInteger second = BigInteger.valueOf(1);
		BigInteger tmp;

		for (long i = 1; i < index; i++) {
			tmp = first.add(second);
			first = second;
			second = tmp;
		}

		return second;
	}
}
