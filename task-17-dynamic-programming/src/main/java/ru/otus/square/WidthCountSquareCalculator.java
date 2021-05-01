package ru.otus.square;

import ru.otus.util.Stack;

public class WidthCountSquareCalculator implements SquareCalculator {

	private final int[][] map;

	private final int[] row;

	private final int[] leftRanges;

	private final int[] rightRanges;


	public WidthCountSquareCalculator(int[][] map) {
		this.map = map;
		final int width = map[0].length;
		row = new int[width];
		leftRanges = new int[width];
		rightRanges = new int[width];
	}

	@Override
	public int calculateSquare() {
		int maxSquare = 0;
		for (int y = 0; y < map.length; y++) {
			updateRow(y);
			findRightRanges();
			findLeftRanges();

			final int square = getMaxRowSquare();
			if (square > maxSquare) {
				maxSquare = square;
			}
		}

		return maxSquare;
	}

	private int getMaxRowSquare() {
		int maxSquare = 0;

		for (int x = 0; x < row.length; x++) {
			final int height = row[x];
			final int width = rightRanges[x] - leftRanges[x] + 1;
			final int square = height * width;

			if (square > maxSquare) {
				maxSquare = square;
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

	private void findRightRanges() {
		final Stack<Integer> stack = new Stack<>();

		for (int x = 0; x < row.length; x++) {
			while (!stack.empty()) {
				if (row[x] < row[stack.peek()]) {
					rightRanges[stack.pop()] = x - 1;
				} else {
					break;
				}
			}
			stack.push(x);
		}

		while (!stack.empty()) {
			rightRanges[stack.pop()] = row.length - 1;
		}
	}

	private void findLeftRanges() {
		final Stack<Integer> stack = new Stack<>();

		for (int x = row.length - 1; x >= 0; x--) {
			while (!stack.empty()) {
				if (row[x] < row[stack.peek()]) {
					leftRanges[stack.pop()] = x + 1;
				} else {
					break;
				}
			}
			stack.push(x);
		}

		while (!stack.empty()) {
			leftRanges[stack.pop()] = 0;
		}
	}
}
