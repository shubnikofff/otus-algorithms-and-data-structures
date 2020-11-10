package ru.otus;

import ru.otus.power.Arguments;
import ru.otus.power.BinaryWithMultiplyPower;
import ru.otus.power.FastPower;
import ru.otus.power.IterationPower;

public class Main {

	public static void main(String[] args) {
		new TestRunner<Arguments, Double>(new TestDataSource("power")).run(new IterationPower());
		new TestRunner<Arguments, Double>(new TestDataSource("power")).run(new BinaryWithMultiplyPower());
		new TestRunner<Arguments, Double>(new TestDataSource("power")).run(new FastPower());
	}
}
