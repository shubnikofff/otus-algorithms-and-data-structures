package ru.otus.prime;

import java.util.ArrayList;
import java.util.List;

public class CachedIterationPrime extends AbstractPrime {

    private final List<Integer> primes = new ArrayList<>();

    @Override
    public Integer execute(Integer number) {
        primes.clear();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes.size();
    }

    private boolean isPrime(int number) {
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

    @Override
    public String getName() {
        return "Cached Iteration Prime";
    }
}
