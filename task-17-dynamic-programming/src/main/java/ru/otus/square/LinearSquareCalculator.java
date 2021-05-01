package ru.otus.square;

public class LinearSquareCalculator implements SquareCalculator {

	private final int[][] map;

	public LinearSquareCalculator(int[][] map) {
		this.map = map;
	}

	@Override
	public int calculateSquare() {
		int maxSquare = 0;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				int square = getSquareAt(x, y);
				if (square > maxSquare) {
					maxSquare = square;
				}
			}
		}

		return maxSquare;
	}

	private int getSquareAt(int x, int y) {
		int maxSquare = 0;
		int minHeight = -1;

		for (int width = 1; width + x <= map[y].length; width++) {
			int height = getHeightAt(x + width - 1, y);
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

	private int getHeightAt(int x, int y) {
		int height = 0;

		while (y - height >= 0 && map[x][y - height] == 0) {
			height++;
		}

		return height;
	}
}
