package ru.otus.fibonacci;

import java.math.BigInteger;

public class IterationFibonacci {

	public static BigInteger count(int index) {
		if (index < 2) {
			return BigInteger.valueOf(index);
		}

		BigInteger prev = BigInteger.valueOf(1);
		BigInteger result = BigInteger.valueOf(1);
		BigInteger tmp;

		for (long i = 2; i < index; i++) {
			tmp = prev.add(result);
			prev = result;
			result = tmp;
		}

		return result;
	}
}
