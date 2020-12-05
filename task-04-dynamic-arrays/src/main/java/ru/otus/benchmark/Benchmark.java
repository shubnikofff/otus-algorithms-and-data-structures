package ru.otus.benchmark;

import ru.otus.array.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Supplier;

public class Benchmark<T> {

    private final Supplier<DynamicArray<T>> arrayFactory;

    private final T arrayItem;

    private final long operationsNumber;

    public Benchmark(Supplier<DynamicArray<T>> arrayFactory, T arrayItem, long operationsNumber) {
        this.arrayFactory = arrayFactory;
        this.arrayItem = arrayItem;
        this.operationsNumber = operationsNumber;
    }

    public void run() {
        System.out.println("Operations at the beginning: " + operationsBegin());
        System.out.println("Operations at the end: " + operationsEnd());
        System.out.println("Operations in a random place: " + operationsRandom());
    }

    private BenchmarkResult operationsBegin() {
        final DynamicArray<T> array = arrayFactory.get();

        Instant startTime = Instant.now();
        for (long i = 0; i < operationsNumber; i++) {
            array.add(arrayItem, 0);
        }
        final Duration insertTime = Duration.between(startTime, Instant.now());

        startTime = Instant.now();
        for (int i = 0; i < operationsNumber; i++) {
            array.remove(0);
        }
        final Duration removeTime = Duration.between(startTime, Instant.now());

        return new BenchmarkResult(insertTime, removeTime);
    }

    private BenchmarkResult operationsEnd() {
        final DynamicArray<T> array = arrayFactory.get();

        Instant startTime = Instant.now();
        for (long i = 0; i < operationsNumber; i++) {
            array.add(arrayItem, array.size());
        }
        final Duration insertTime = Duration.between(startTime, Instant.now());

        startTime = Instant.now();
        for (int i = 0; i < operationsNumber; i++) {
            array.remove(array.size() - 1);
        }
        final Duration removeTime = Duration.between(startTime, Instant.now());

        return new BenchmarkResult(insertTime, removeTime);
    }

    private BenchmarkResult operationsRandom() {
        final DynamicArray<T> array = arrayFactory.get();
        final Random random = new Random();

        Instant startTime = Instant.now();
        for (long i = 0; i < operationsNumber; i++) {
            array.add(arrayItem, random.nextInt(array.size() + 1));
        }
        final Duration insertTime = Duration.between(startTime, Instant.now());

        startTime = Instant.now();
        for (int i = 0; i < operationsNumber; i++) {
            array.remove(random.nextInt(array.size()));
        }
        final Duration removeTime = Duration.between(startTime, Instant.now());

        return new BenchmarkResult(insertTime, removeTime);
    }
}
