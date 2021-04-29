package ru.otus.util;

import java.util.Random;

public class Matrix {

	private static final long RANDOM_SEED = 123456789;

	public static int[][] makeRandomMatrix(int width, int height, int factor) {
		final int[][] matrix = new int[width][height];
		final Random random = new Random(RANDOM_SEED);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				matrix[x][y] = random.nextInt(factor) / (factor - 1);
			}
		}

		return matrix;
	}

	public static void print(int[][] matrix) {
		for (final int[] row : matrix) {
			for (final int element : row) {
				System.out.print(element == 0 ? ". " : "# ");
			}
			System.out.println();
		}
	}
}
