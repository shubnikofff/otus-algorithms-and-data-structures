package ru.otus;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

	private final Path initialResource = Paths.get("src/test/resources/binary/initial");
	private final Path resultResource = Paths.get("src/test/resources/binary/result");
	private final Path expectedResource = Paths.get("src/test/resources/binary/expected");

	@BeforeEach
	void setUp() throws IOException {
		Files.copy(initialResource, resultResource, StandardCopyOption.REPLACE_EXISTING);
	}

	@AfterEach
	void tearDown() throws IOException {
		Files.delete(resultResource);
	}

	@Test
	void sort() throws IOException {
		MergeSort.sort(resultResource.toString());

		final File resultFile = new File(resultResource.toString());
		final File expectedFile = new File(expectedResource.toString());

		assertArrayEquals(FileUtils.readFileToByteArray(resultFile), FileUtils.readFileToByteArray(expectedFile));
	}
}
