package ru.otus;

import ru.otus.power.Arguments;
import ru.otus.power.FastPower;
import ru.otus.power.BinaryWithMultiply;
import ru.otus.power.IterationPower;

public class Main {

	public static void main(String[] args) {
		new TestRunner<Arguments, Double>("Iteration power", new TestDataSource("power")).run(new IterationPower());
		new TestRunner<Arguments, Double>("Iteration power", new TestDataSource("power")).run(new BinaryWithMultiply());
		new TestRunner<Arguments, Double>("Binary power", new TestDataSource("power")).run(new FastPower());
	}
}
