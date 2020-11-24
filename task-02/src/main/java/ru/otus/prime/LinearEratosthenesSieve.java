package ru.otus.prime;

import java.util.*;

public class LinearEratosthenesSieve extends AbstractPrime {

	@Override
	public Integer execute(Integer number) {

		int primeNumbersCount = 0;
		final int[] lp = new int[number + 1];
		final Map<Integer, Integer> pr = new HashMap<>();

		for (int i = 2; i <= number; i++) {
			if (lp[i] == 0) {
				lp[i] = i;
				pr.put(primeNumbersCount++, i);
			}

			for (int j = 0; j < primeNumbersCount && (pr.get(j) <= lp[i] && pr.get(j) * i <= number); j++) {
				lp[pr.get(j) * i] = pr.get(j);
			}
		}

		return primeNumbersCount;
	}

	@Override
	public String getName() {
		return "Sieve of Eratosthenes (linear complexity)";
	}
}
