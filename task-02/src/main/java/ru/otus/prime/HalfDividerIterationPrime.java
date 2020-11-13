package ru.otus.prime;

public class HalfDividerIterationPrime extends AbstractIterationPrime {
    @Override
    protected boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Half Divider Iteration Prime";
    }
}
