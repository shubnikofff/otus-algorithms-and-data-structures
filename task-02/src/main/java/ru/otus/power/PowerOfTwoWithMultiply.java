package ru.otus.power;

public class PowerOfTwoWithMultiply extends AbstractPower {

	@Override
	public Double execute(Arguments arguments) {

		final long power = arguments.getPower();
		final double number = arguments.getNumber();

		if (power == 0) {
			return 1.0;
		}

		final int k = (int) (Math.log(power) / Math.log(2));

		double result = number;
		for (int i = 1; i <= k; i++) {
			result *= result;
		}

		for (long i =  (long) Math.pow(2, k); i < power; i++) {
			result = result * number;
		}

		return roundDouble(result);
	}
}
