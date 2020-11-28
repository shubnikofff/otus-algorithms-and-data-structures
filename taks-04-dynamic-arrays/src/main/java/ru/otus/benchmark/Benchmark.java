package ru.otus.benchmark;

import ru.otus.array.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Supplier;

public class Benchmark<T> {

    private final Supplier<DynamicArray<T>> arrayFactory;

    private final T arrayItem;

    private final long insertsNumber;

    public Benchmark(Supplier<DynamicArray<T>> arrayFactory, T arrayItem, long insertsNumber) {
        this.arrayFactory = arrayFactory;
        this.arrayItem = arrayItem;
        this.insertsNumber = insertsNumber;
    }

    public void measure() {
        System.out.printf("Insert at the beginning: %d ms\n", insertBegin().toMillis());
        System.out.printf("Insert at the end: %d ms\n", insertEnd().toMillis());
        System.out.printf("Insert at the random place: %d ms\n", insertRandom().toMillis());
    }

    private Duration insertBegin() {
        final DynamicArray<T> array = arrayFactory.get();
        final Instant startTime = Instant.now();

        for (long i = 0; i < insertsNumber; i++) {
            array.add(arrayItem, 0);
        }

        return Duration.between(startTime, Instant.now());
    }

    private Duration insertEnd() {
        final DynamicArray<T> array = arrayFactory.get();
        final Instant startTime = Instant.now();

        for (long i = 0; i < insertsNumber; i++) {
            array.add(arrayItem, array.size());
        }

        return Duration.between(startTime, Instant.now());
    }

    private Duration insertRandom() {
        final DynamicArray<T> array = arrayFactory.get();
        final Random random = new Random();
        final Instant startTime = Instant.now();

        for (long i = 0; i < insertsNumber; i++) {
            array.add(arrayItem, random.nextInt(array.size() + 1));
        }

        return Duration.between(startTime, Instant.now());
    }
}
