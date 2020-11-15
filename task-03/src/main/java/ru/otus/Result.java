package ru.otus;

public class Result {

	final int movesNumber;

	final long bitMask;

	public Result(int movesNumber, long bitMask) {
		this.movesNumber = movesNumber;
		this.bitMask = bitMask;
	}

	public int getMovesNumber() {
		return movesNumber;
	}

	public long getBitMask() {
		return bitMask;
	}
}
