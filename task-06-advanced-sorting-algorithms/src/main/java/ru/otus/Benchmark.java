package ru.otus;

import ru.otus.file.FileGenerator;
import ru.otus.sort.MergeSort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class Benchmark {

	public static void main(String[] args) throws IOException {
		run((int)1e6);
		run((int)1e7);
		run((int)1e8);
		run((int)1e9);
	}

	private static void run(int numbersSize) throws IOException {
		System.out.println("Run Merge Sort on file with " + numbersSize + " numbers");

		final File file = new File(UUID.randomUUID().toString());
		FileGenerator.generate(numbersSize, file);

		final Instant startTime = Instant.now();
		MergeSort.sort(file);
		System.out.println("Duration " + Duration.between(startTime, Instant.now()).getSeconds() + " seconds");

		Files.deleteIfExists(file.toPath());
	}
}
