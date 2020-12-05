package ru.otus.power;

public class FastPower {

	public static double count(Arguments arguments) {
		double base = arguments.getBase();
		long power = arguments.getPower();

		double result = 1.0;

		while (power > 1.0) {
			if(power % 2 == 1) {
				result *= base;
			}

			base *= base;
			power /= 2;
		}

		if (power > 0) {
			result *= base;
		}

		return PowerUtil.roundDouble(result);
	}
}
