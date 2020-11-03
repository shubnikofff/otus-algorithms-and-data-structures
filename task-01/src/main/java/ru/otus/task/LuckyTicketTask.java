package ru.otus.task;

import java.util.*;

public class LuckyTicketTask implements Task {

	@Override
	public String execute(String input) {
		final int digitsNumber = Integer.parseInt(input);

		final List<Long> sumList = new ArrayList<>(digitsNumber * 9);
		for (int i = 0; i <= digitsNumber * 9; i++) {
			sumList.add(0L);
		}

		int sum;
		for (long i = 0L; i < Math.pow(10, digitsNumber); i++) {
			sum = calcSumDigits(i);
			sumList.set(sum, sumList.get(sum) + 1);
		}

		final Long luckyTicketsNumber = sumList
				.stream()
				.reduce(0L, (subTotal, value) -> subTotal += value * value);

		return String.valueOf(luckyTicketsNumber);
	}

	private static int calcSumDigits(long value) {
		int sum = 0;
		while (value > 0) {
			sum += value % 10;
			value /= 10;
		}

		return sum;
	}
}
