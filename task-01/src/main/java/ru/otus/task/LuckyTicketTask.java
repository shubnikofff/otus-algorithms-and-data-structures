package ru.otus.task;

import java.util.*;

public class LuckyTicketTask implements Task {

	@Override
	public String execute(String input) {

		final int digitsQuantity = Integer.parseInt(input);

		long luckyTicketsQuantity = 0;

		final Map<Integer, Integer> sumToQuantityMap = new HashMap<>(digitsQuantity * 9);

		final List<Integer> sumList = new ArrayList<>();

		for (int i = 0; i <= digitsQuantity * 9; i++) {
			sumToQuantityMap.put(i, 0);
		}

		for (int i = 0; i < Math.pow(10, digitsQuantity); i++) {
			int key = calcSumDigits(i);
			sumToQuantityMap.put(key, sumToQuantityMap.get(key) + 1);
			sumList.add(key);
		}

		for (int k = 0; k < Math.pow(10, digitsQuantity); k++) {
			luckyTicketsQuantity += sumToQuantityMap.get(sumList.get(k));
		}

		return String.valueOf(luckyTicketsQuantity);
	}

	private int calcSumDigits(int value) {
		int sum = 0;
		while (value > 0) {
			sum += value % 10;
			value /= 10;
		}

		return sum;
	}
}
