package ru.otus.square;

import ru.otus.util.Matrix;

import java.time.Duration;
import java.time.Instant;

public class LinearSquareCalculator {

	private static final int MAP_WIDTH = 5000;
	private static final int MAP_HEIGHT = 5000;
	private static final int OBSTACLE_FACTOR = 7;

	public static void main(String[] args) {

		final int[][] map = Matrix.makeRandomMatrix(MAP_WIDTH, MAP_HEIGHT, OBSTACLE_FACTOR);
		final Instant instant = Instant.now();
		final int square = calculateSquare(map);
		final long duration = Duration.between(instant, Instant.now()).toMillis();

		System.out.println("Square: " + square);
		System.out.println("Duration: " + duration + "ms");
	}

	private static int calculateSquare(int[][] map) {
		int maxSquare = 0;
		for (int y = 0; y < MAP_HEIGHT; y++) {
			for (int x = 0; x < MAP_WIDTH; x++) {
				int square = getSquareAt(x, y, map);
				if (square > maxSquare) {
					maxSquare = square;
				}
			}
		}

		return maxSquare;
	}

	private static int getSquareAt(int x, int y, int[][] map) {
		int maxSquare = 0;
		int minHeight = -1;

		for (int width = 1; width + x <= MAP_WIDTH; width++) {
			int height = getHeightAt(x + width - 1, y, map);
			if (minHeight == -1 || height < minHeight) {
				minHeight = height;
			}

			if (minHeight == 0) {
				return maxSquare;
			}

			final int square = width * minHeight;
			if (square > maxSquare) {
				maxSquare = square;
			}
		}

		return maxSquare;
	}

	private static int getHeightAt(int x, int y, int[][] map) {
		int height = 0;

		while (y - height >= 0 && map[x][y - height] == 0) {
			height++;
		}

		return height;
	}
}
