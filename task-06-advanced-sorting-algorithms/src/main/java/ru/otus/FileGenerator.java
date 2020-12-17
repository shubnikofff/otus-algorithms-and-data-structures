package ru.otus;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {

	public static void main(String[] args) throws IOException {

		generate((int) 1e6, "test.0.in");
		generate((int) 1e7, "test.1.in");
		generate((int) 1e8, "test.2.in");
		generate((int) 1e9, "test.3.in");


//		final byte[] bytes = Files.readAllBytes(Path.of("numbers_300"));
//
//
//		final ByteBuffer allBytesBuffer = ByteBuffer.wrap(bytes);
//
//		System.out.println(allBytesBuffer.getShort(0));
//		System.out.println(allBytesBuffer.getShort(4));
//		System.out.println(allBytesBuffer.getShort(2));

//		generate(600);
	}


	private static void generate(int size, String filename) throws IOException {
		final Random random = new Random();

		try (final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename))) {
			short next;
			for (int i = 0; i < size; i++) {
				next = (short) random.nextInt(1 << 16);
				outputStream.write(new byte[]{(byte) ((next & 0xFF00) >> 8), (byte) (next & 0x00FF)});
			}

			outputStream.flush();
		}
	}
}
