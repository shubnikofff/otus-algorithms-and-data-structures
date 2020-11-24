package ru.otus.power;

public class Arguments {

	private final double base;

	private final long power;

	public Arguments(double base, long power) {
		this.base = base;
		this.power = power;
	}

	public double getBase() {
		return base;
	}

	public long getPower() {
		return power;
	}
}
