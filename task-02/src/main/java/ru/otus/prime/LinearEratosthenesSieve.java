package ru.otus.prime;

import java.util.*;

public class LinearEratosthenesSieve {

	public static int countPrimes(int number) {

		int primeNumbersCount = 0;
		final int[] lp = new int[number + 1];
		final Map<Integer, Integer> pr = new HashMap<>();

		for (int i = 2; i <= number; i++) {
			if (lp[i] == 0) {
				lp[i] = i;
				pr.put(primeNumbersCount++, i);
			}

			for (int p = 0; p < primeNumbersCount && (pr.get(p) <= lp[i] && pr.get(p) * i <= number); p++) {
				lp[pr.get(p) * i] = pr.get(p);
			}
		}

		return primeNumbersCount;
	}
}
