package ru.otus;

import java.util.Scanner;

public class Islands {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		final int size = scanner.nextInt();
		final int[][] map = new int[size][size];

		fillMap(map);

		int islandsCount = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1) {
					islandsCount++;
					walkMap(i, j, map);
				}
			}
		}

		System.out.println(islandsCount);
	}

	private static void fillMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
	}

	private static void walkMap(int x, int y, int[][] map) {
		if (x < 0 || x >= map.length) {
			return;
		}

		if (y < 0 || y >= map.length) {
			return;
		}

		if (map[x][y] == 0) {
			return;
		}

		map[x][y] = 0;

		walkMap(x - 1, y, map);
		walkMap(x + 1, y, map);
		walkMap(x, y - 1, map);
		walkMap(x, y + 1, map);
	}
}
