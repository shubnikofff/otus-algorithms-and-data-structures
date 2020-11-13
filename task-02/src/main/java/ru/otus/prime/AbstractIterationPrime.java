package ru.otus.prime;

public abstract class AbstractIterationPrime extends AbstractPrime {

    @Override
    public Integer execute(Integer input) {
        int result = 0;

        for (int i = 2; i <= input; i++) {
            if (isPrime(i)) {
                result++;
            }
        }

        return result;
    }

    protected abstract boolean isPrime(int number);
}
