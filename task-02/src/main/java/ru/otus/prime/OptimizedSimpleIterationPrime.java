package ru.otus.prime;

public class OptimizedSimpleIterationPrime extends AbstractIterationPrime {
    @Override
    protected boolean isPrime(int number) {
       for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Optimized Simple Iteration Prime";
    }
}
