package ru.otus.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class FileGenerator {

	public static void printFile(String filename) throws IOException {
		System.out.println("Printing " + filename);
		try(final BufferedInputStream stream = new BufferedInputStream(new FileInputStream(filename)))  {
			final ByteBuffer buffer = ByteBuffer.wrap(stream.readAllBytes());
			for (int i = 0; i < buffer.capacity(); i = i + 2) {
				System.out.println(buffer.getShort(i));
			}
		}
	}

	public static void generate(int numbersSize, File file) throws IOException {
		final Random random = new Random();

		try (final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			short next;
			for (int i = 0; i < numbersSize; i++) {
				next = (short) random.nextInt(1 << 16);
				outputStream.write(new byte[]{(byte) ((next & 0xFF00) >> 8), (byte) (next & 0x00FF)});
			}

			outputStream.flush();
		}
	}
}
