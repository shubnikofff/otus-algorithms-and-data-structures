package ru.otus.power;

public class Arguments {

	private final double number;

	private final long power;

	public Arguments(double number, long power) {
		this.number = number;
		this.power = power;
	}

	public double getNumber() {
		return number;
	}

	public long getPower() {
		return power;
	}
}
