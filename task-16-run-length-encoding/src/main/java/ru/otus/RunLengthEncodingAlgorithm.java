package ru.otus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RunLengthEncodingAlgorithm {

	public static void encode(File inputFile, File outputFile) throws IOException {
		try (final RandomAccessFile accessFile = new RandomAccessFile(inputFile, "r")) {
			while (accessFile.getFilePointer() < accessFile.length()) {





				System.out.println(accessFile.readByte());
			}
		}
	}

	public static void decode(File inputFile, File outputFile) {
		System.out.println("Unpacking...");
	}

}
