package ru.otus.prime;

public class SimpleIterationPrime extends AbstractIterationPrime {
    @Override
    protected boolean isPrime(int number) {
        int primesCount = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                primesCount++;
            }
        }

        return primesCount == 2;
    }

    @Override
    public String getName() {
        return "Simple Iteration Prime";
    }
}
