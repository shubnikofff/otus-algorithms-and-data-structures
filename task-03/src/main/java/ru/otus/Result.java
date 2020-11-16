package ru.otus;

public class Result {

	private final int movesNumber;

	private final String bitMask;

	public Result(int movesNumber, String bitMask) {
		this.movesNumber = movesNumber;
		this.bitMask = bitMask;
	}

	public int getMovesNumber() {
		return movesNumber;
	}

	public String getBitMask() {
		return bitMask;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Result)) {
			return false;
		}

		final Result comparison = (Result) obj;
		return movesNumber == comparison.getMovesNumber() && bitMask.equals(comparison.getBitMask());
	}

	@Override
	public String toString() {
		return "Result{" +
				"movesNumber=" + movesNumber +
				", bitMask=" + bitMask +
				'}';
	}
}
