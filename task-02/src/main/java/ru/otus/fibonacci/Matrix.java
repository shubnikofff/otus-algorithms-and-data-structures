package ru.otus.fibonacci;

import java.math.BigInteger;

public class Matrix {

	private final BigInteger[] elements;

	private Matrix(BigInteger first, BigInteger second, BigInteger third, BigInteger fourth) {
		elements = new BigInteger[]{first, second, third, fourth};
	}

	public static Matrix initial() {
		return new Matrix(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(0));
	}

	public BigInteger getElement(int index) {
		return elements[index];
	}

	public Matrix multiply(Matrix matrix) {
		return new Matrix(
				elements[0].multiply(matrix.getElement(0)).add(elements[1].multiply(matrix.getElement(2))),
				elements[0].multiply(matrix.getElement(1)).add(elements[1].multiply(matrix.getElement(3))),
				elements[0].multiply(matrix.getElement(1)).add(elements[1].multiply(matrix.getElement(3))),
				elements[2].multiply(matrix.getElement(1)).add(elements[3].multiply(matrix.getElement(3)))
		);
	}
}
