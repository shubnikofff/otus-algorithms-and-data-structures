package ru.otus;

import java.io.File;
import java.io.IOException;

public class Archiver {

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("To compress file run: java -jar archiver.jar <input filename> <output filename>");
			System.out.println("To unpack file run: java -jar archiver.jar -u <input filename> <output filename>");
			return;
		}

		if(args[0].equals("-u")) {
			RunLengthEncodingAlgorithm.decode(new File(args[1]), new File(args[2]));
		} else {
			RunLengthEncodingAlgorithm.encode(new File(args[0]), new File(args[1]));
		}
	}
}
