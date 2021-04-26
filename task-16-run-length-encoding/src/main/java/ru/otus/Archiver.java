package ru.otus;

import java.io.IOException;
import java.nio.file.Path;

public class Archiver {

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("To compress file run: java -jar archiver.jar <input file> <output file>");
			System.out.println("To unpack file run: java -jar archiver.jar -u <input file> <output file>");
			return;
		}

		if(args[0].equals("-u")) {
			RunLengthEncodingAlgorithm.decode(Path.of(args[1]), Path.of(args[2]));
		} else {
			RunLengthEncodingAlgorithm.encode(Path.of(args[0]), Path.of(args[1]));
		}
	}
}
