package ru.otus;

import ru.otus.file.FileGenerator;
import ru.otus.sort.CountingSort;
import ru.otus.sort.MergeSort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class Benchmark {

	private static final int MAX_VALUE = (int) Math.pow(2, 16) - 1;

	public static final int[] NUMBER_SIZE = {(int) 1e6, (int) 1e7, (int) 1e8, (int) 1e9};

	public static void main(String[] args) throws IOException {
		for (int size : NUMBER_SIZE) {
			runMergeSort(size);
			runCountingSort(size);
		}
	}

	private static void runMergeSort(int numbersSize) throws IOException {
		System.out.println("Run Merge Sort on file with " + numbersSize + " numbers");

		final File file = new File(UUID.randomUUID().toString());
		FileGenerator.generate(numbersSize, MAX_VALUE, file);

		final Instant startTime = Instant.now();
		MergeSort.sort(file);
		System.out.println("Duration " + Duration.between(startTime, Instant.now()).getSeconds() + " seconds");

		Files.deleteIfExists(file.toPath());
	}

	private static void runCountingSort(int numbersSize) throws IOException {
		System.out.println("Run Counting Sort on file with " + numbersSize + " numbers");

		final File inputFile = new File(UUID.randomUUID().toString());
		final File outputFile = new File(UUID.randomUUID().toString());
		FileGenerator.generate(numbersSize, MAX_VALUE, inputFile);

		final Instant startTime = Instant.now();
		CountingSort.sort(inputFile, outputFile);
		System.out.println("Duration " + Duration.between(startTime, Instant.now()).getSeconds() + " seconds");

		Files.deleteIfExists(inputFile.toPath());
		Files.deleteIfExists(outputFile.toPath());
	}
}
