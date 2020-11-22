package ru.otus.fibonacci;

import java.math.BigInteger;

public class RecursionFibonacci {

	public static BigInteger count(int index) {
		if (index < 2) {
			return BigInteger.valueOf(index);
		}

		return count(index - 1).add(count(index - 2));
	}
}
