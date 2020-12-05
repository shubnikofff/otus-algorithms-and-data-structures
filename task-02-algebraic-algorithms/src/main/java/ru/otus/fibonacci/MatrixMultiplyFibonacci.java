package ru.otus.fibonacci;

import java.math.BigInteger;

public class MatrixMultiplyFibonacci {

	public static BigInteger count(int index) {
		if (index < 2) {
			return BigInteger.valueOf(1L);
		}

		Matrix base = Matrix.initial();
		Matrix result = Matrix.initial();

		index -= 2;

		while (index > 1) {
			if (index % 2 == 1) {
				result = result.multiply(base);
			}

			base = base.multiply(base);
			index /= 2;
		}

		if (index > 0) {
			result = result.multiply(base);
		}

		return result.getElement(0);
	}
}
