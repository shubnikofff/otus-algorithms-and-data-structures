package ru.otus;

import java.util.Scanner;

public class DigitalChristmasTree {

	private static final int MATRIX_DIMENSION = 100;

	public static void main(String[] args) {

		final int[][] tree = new int[MATRIX_DIMENSION][MATRIX_DIMENSION];
		final Scanner scanner = new Scanner(System.in);
		final int height = scanner.nextInt();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				tree[i][j] = scanner.nextInt();
			}
		}

		for (int i = height - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				tree[i][j] += Math.max(tree[i + 1][j], tree[i + 1][j + 1]);
			}
		}

		System.out.println(tree[0][0]);
	}
}
