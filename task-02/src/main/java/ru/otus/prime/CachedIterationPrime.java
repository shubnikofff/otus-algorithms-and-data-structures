package ru.otus.prime;

import java.util.ArrayList;
import java.util.List;

public class CachedIterationPrime {

    private static final List<Integer> primes = new ArrayList<>();

    public static int count(int number) {
        primes.clear();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes.size();
    }

    private static boolean isPrime(int number) {
        if(number % 2 == 0) {
            return number == 2;
        }

        final double sqrt = Math.sqrt(number);
        for(int prime: primes) {
            if (prime > sqrt) {
                return true;
            }

            if (number % prime == 0) {
                return false;
            }
        }

        return true;
    }
}
