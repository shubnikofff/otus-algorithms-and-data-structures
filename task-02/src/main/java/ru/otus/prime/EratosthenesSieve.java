package ru.otus.prime;

import java.util.Arrays;

public class EratosthenesSieve {

	public static int countPrimes(int number) {
		final boolean[] isPrime = new boolean[number + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int result = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				result++;
			}
		}

		return result;
	}
}
