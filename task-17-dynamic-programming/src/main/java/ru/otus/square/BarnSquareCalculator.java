package ru.otus.square;

import ru.otus.util.Matrix;

import java.time.Duration;
import java.time.Instant;

public class BarnSquareCalculator {

	private static final int MAP_WIDTH = 10;
	private static final int MAP_HEIGHT = 10;
	private static final int OBSTACLE_FACTOR = 7;

	public static void main(String[] args) {
		final int[][] map = Matrix.makeRandomMatrix(MAP_WIDTH, MAP_HEIGHT, OBSTACLE_FACTOR);

		Matrix.print(map);

		run(new LinearSquareCalculator(map));
		run(new HeightCountSquareCalculator(map));
		run(new WidthCountSquareCalculator(map));
	}

	private static void run(SquareCalculator calculator) {
		System.out.println("\nRun with " + calculator.getClass().getSimpleName());
		final Instant instant = Instant.now();
		final int square = calculator.calculateSquare();
		final long duration = Duration.between(instant, Instant.now()).toMillis();

		System.out.println("Square: " + square);
		System.out.println("Duration: " + duration + "ms");
	}
}
