package ru.otus.sort;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingSortTest {

	private final File initialFile = new File("src/test/resources/binary/initial");
	private final File resultFile = new File("src/test/resources/binary/result");
	private final File expectedFile = new File("src/test/resources/binary/expected");

	@AfterEach
	void tearDown() throws IOException {
		Files.deleteIfExists(resultFile.toPath());
	}

	@Test
	void sort() throws IOException {
		CountingSort.sort(initialFile, resultFile);

		assertArrayEquals(FileUtils.readFileToByteArray(resultFile), FileUtils.readFileToByteArray(expectedFile));
	}
}
