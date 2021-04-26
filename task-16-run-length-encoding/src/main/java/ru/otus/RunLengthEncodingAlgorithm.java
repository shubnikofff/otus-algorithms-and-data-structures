package ru.otus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RunLengthEncodingAlgorithm {

	public static void encode(Path inputFile, Path outputFile) throws IOException {
		final byte[] bytes = Files.readAllBytes(inputFile);
	}

	public static void decode(Path inputFile, Path outputFile) throws IOException {
		System.out.println("Unpacking...");
	}

}
