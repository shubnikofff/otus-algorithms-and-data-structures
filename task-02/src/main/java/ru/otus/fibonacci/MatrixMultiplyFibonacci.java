package ru.otus.fibonacci;

import java.math.BigInteger;

public class MatrixMultiplyFibonacci extends AbstractFibonacci {

	@Override
	public String getName() {
		return "Matrix Multiply Fibonacci";
	}

	@Override
	public BigInteger execute(Integer index) {
		if (index < 2) {
			return BigInteger.valueOf(1);
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
