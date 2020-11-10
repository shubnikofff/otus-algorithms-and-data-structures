package ru.otus.power;

import ru.otus.TestCase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class AbstractPower implements TestCase<Arguments, Double> {

	private static final int SCALE = 11;

	public abstract Double execute(Arguments arguments);

	@Override
	public Arguments getArguments(List<String> input) {
		return new Arguments(Double.parseDouble(input.get(0)), Long.parseLong(input.get(1)));
	}

	@Override
	public Double getExpectedResult(List<String> output) {
		return Double.parseDouble(output.get(0));
	}

	protected double roundDouble(double value) {
		BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
		bigDecimal = bigDecimal.setScale(SCALE, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}
}
