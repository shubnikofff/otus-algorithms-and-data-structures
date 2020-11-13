package ru.otus.prime;

public class SqrtDividerIterationPrime extends AbstractIterationPrime {
    @Override
    protected boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Square root Divider Iteration Prime";
    }
}
