package ru.otus.benchmark;

import java.time.Duration;

public class BenchmarkResult {

	private final Duration insertTime;

	private final Duration removeTime;

	public BenchmarkResult(Duration insertTime, Duration removeTime) {
		this.insertTime = insertTime;
		this.removeTime = removeTime;
	}

	@Override
	public String toString() {
		return String.format("\nInsert time: %d ms.\nRemove time: %d ms.\n", insertTime.toMillis(), removeTime.toMillis());
	}
}
