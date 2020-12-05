package ru.otus;

import ru.otus.array.*;
import ru.otus.benchmark.Benchmark;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nSingle Array benchmark");
        new Benchmark<>(SingleArray::new, 1000, 100_000).run();

        System.out.println("\nVector Array benchmark");
        new Benchmark<>(VectorArray::new, 1000, 100_000).run();

        System.out.println("\nFactor Array benchmark");
        new Benchmark<>(FactorArray::new, 1000, 100_000).run();

        System.out.println("\nMatrixArray benchmark");
        new Benchmark<>(MatrixArray::new, 1000, 100_000).run();

        System.out.println("\nArrayList benchmark");
        new Benchmark<>(ArrayListWrapper::new, 1000, 100_000).run();

    }
}
