package ru.otus.power;

public class IterationPower {

	public static double count(Arguments arguments) {
		final double base = arguments.getBase();
		final long power = arguments.getPower();

		double result = 1.0;

		for (long i = 1; i <= power; i++) {
			result = result * base;
		}

		return PowerUtil.roundDouble(result);
	}
}
