package ru.otus.power;

public class IterationPower extends AbstractPower {

	@Override
	public Double execute(Arguments arguments) {
		final double base = arguments.getBase();
		final long power = arguments.getPower();

		double result = 1.0;

		for (long i = 1; i <= power; i++) {
			result = result * base;
		}

		return roundDouble(result);
	}
}
