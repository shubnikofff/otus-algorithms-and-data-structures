package ru.otus;

import ru.otus.fibonacci.*;
import ru.otus.power.BinaryWithMultiplyPower;
import ru.otus.power.FastPower;
import ru.otus.power.IterationPower;
import ru.otus.prime.*;

public class Main {

	public static void main(String[] args) {
		TestRunner.run(new IterationPower(), new TestDataSource("power"));
		TestRunner.run(new BinaryWithMultiplyPower(), new TestDataSource("power"));
		TestRunner.run(new FastPower(), new TestDataSource("power"));

		TestRunner.run(new IterationFibonacci(), new TestDataSource("fibonacci"));
		TestRunner.run(new RecursionFibonacci(), new TestDataSource("fibonacci"));
		TestRunner.run(new GoldenRatioFibonacci(), new TestDataSource("fibonacci"));
		TestRunner.run(new MatrixMultiplyFibonacci(), new TestDataSource("fibonacci"));

		TestRunner.run(new SimpleIterationPrime(), new TestDataSource("primes"));
		TestRunner.run(new OptimizedSimpleIterationPrime(), new TestDataSource("primes"));
		TestRunner.run(new HalfDividerIterationPrime(), new TestDataSource("primes"));
		TestRunner.run(new SqrtDividerIterationPrime(), new TestDataSource("primes"));
		TestRunner.run(new SqrtDividerExcludeEvenIterationPrime(), new TestDataSource("primes"));
	}
}
