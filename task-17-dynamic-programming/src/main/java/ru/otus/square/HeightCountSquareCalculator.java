package ru.otus.square;

public class HeightCountSquareCalculator implements SquareCalculator {

	private final int[][] map;

	private final int[] row;

	public HeightCountSquareCalculator(int[][] map) {
		this.map = map;
		row = new int[map[0].length];
	}

	@Override
	public int calculateSquare() {
		int maxSquare = 0;
		for (int y = 0; y < map.length; y++) {
			updateRow(y);
			for (int x = 0; x < map[y].length; x++) {
				int square = getSquareAt(x, y);
				if (square > maxSquare) {
					maxSquare = square;
				}
			}
		}

		return maxSquare;
	}

	private void updateRow(int y) {
		for (int x = 0; x < map[y].length; x++) {
			if(map[x][y] == 0) {
				row[x]++;
			} else {
				row[x] = 0;
			}
		}
	}

	private int getSquareAt(int x, int y) {
		int maxSquare = 0;
		int minHeight = -1;

		for (int width = 1; width + x <= map[y].length; width++) {
			int height = row[x + width - 1];
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
}
