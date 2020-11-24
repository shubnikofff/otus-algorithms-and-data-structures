package ru.otus.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class GoldenRatioFibonacci extends AbstractFibonacci {

	@Override
	public String getName() {
		return "Golden Ratio";
	}

	@Override
	public BigInteger execute(Integer index) {
		if (index < 2) {
			return BigInteger.valueOf(index);
		}


		if (index < 100) {
			double phi = (1 + Math.sqrt(5)) / 2;
			long result = (long) ((Math.pow(phi, index) - Math.pow(-phi, -index)) / Math.sqrt(5));
			return BigInteger.valueOf(result);
		}


		return BigDecimal.valueOf((1 + Math.sqrt(5)) / 2)
				.pow(index)
				.divide(BigDecimal.valueOf(Math.sqrt(5)), RoundingMode.HALF_UP)
				.add(BigDecimal.valueOf(0.5))
				.toBigInteger();
	}
}
