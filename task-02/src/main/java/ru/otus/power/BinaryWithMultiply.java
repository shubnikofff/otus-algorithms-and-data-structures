package ru.otus.power;

public class BinaryWithMultiply extends AbstractPower {

	@Override
	public Double execute(Arguments arguments) {
		final long power = arguments.getPower();
		final double base = arguments.getBase();

		if (power == 0 || base == 1) {
			return 1.0;
		}

		double result = base;
		long i = 1;

		while (i < power / 2) {
			result *= result;
			i *= 2;
		}

		while (i < power) {
			result *= base;
			i++;
		}

		return roundDouble(result);
	}
}
