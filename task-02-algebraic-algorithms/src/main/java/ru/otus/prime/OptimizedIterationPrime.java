package ru.otus.prime;

public class OptimizedIterationPrime extends AbstractIterationPrime {

    @Override
    protected boolean isPrime(int number) {
        if(number == 2) {
            return true;
        }

        if(number % 2 == 0) {
            return false;
        }

        final double sqrt = Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
