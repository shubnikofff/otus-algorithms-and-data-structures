package ru.otus.power;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class PowerUtil {

	private static final int SCALE = 11;

	static double roundDouble(double value) {
		BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
		bigDecimal = bigDecimal.setScale(SCALE, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}
}
