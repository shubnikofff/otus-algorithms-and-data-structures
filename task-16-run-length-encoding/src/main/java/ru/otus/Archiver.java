package ru.otus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Archiver {

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("To compress file run: java -jar archiver.jar <input file> <output file>");
			System.out.println("To unpack file run: java -jar archiver.jar -u <input file> <output file>");
			return;
		}

		if(args[0].equals("-u")) {
			final byte[] decodedFile = RunLengthEncodingAlgorithm.decode(Files.readAllBytes(Path.of(args[1])));
			Files.write(Path.of(args[2]), decodedFile);
		} else {
			final byte[] encodedFile = RunLengthEncodingAlgorithm.encode(Files.readAllBytes(Path.of(args[0])));
			Files.write(Path.of(args[1]), encodedFile);
		}
	}
}
