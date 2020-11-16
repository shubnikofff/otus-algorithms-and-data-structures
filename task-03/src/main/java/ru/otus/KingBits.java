package ru.otus;

public class KingBits extends AbstractBits {

	private final static long INVERTED_COLUMN_A = 0xFEFEFEFEFEFEFEFEL;
	private final static long INVERTED_COLUMN_H = 0x7F7F7F7F7F7F7F7FL;


//	@Override
//	public Result execute(Integer input) {
//
//		final BigInteger position = new BigInteger(Long.toUnsignedString( 1L << input));
//
//		final BigInteger mask = position.and(LEFT_BOARD).and(TOP_BOARD).shiftLeft(7).or(position.and(TOP_BOARD).shiftLeft(8)).or(position.and(RIGHT_BOARD).and(TOP_BOARD).shiftLeft(9))
//				.or(position.and(LEFT_BOARD).shiftRight(1)).or(position.and(RIGHT_BOARD).shiftLeft(1))
//				.or(position.and(LEFT_BOARD).and(BOTTOM_BOARD).shiftRight(9)).or(position.and(BOTTOM_BOARD).shiftRight(8)).or(position.and(RIGHT_BOARD).and(BOTTOM_BOARD).shiftRight(7));
//
//
//		int movesCount = 0;
//		BigInteger tmp = new BigInteger(mask.toByteArray());
//
//		while (tmp.compareTo(BigInteger.valueOf(0)) == 1) {
//			movesCount++;
//			tmp = tmp.and(tmp.subtract(BigInteger.valueOf(1)));
//		}
//
//
//		return new Result(movesCount, mask);
//
//	}

	@Override
	public Result execute(Integer input) {
		final long position = 1L << input;
		final long leftBoard = position & INVERTED_COLUMN_A;
		final long rightBoard = position & INVERTED_COLUMN_H;
		final long mask = leftBoard << 7 | position << 8 | rightBoard << 9 |
				leftBoard >>> 1 | rightBoard << 1 |
				leftBoard >>> 9 | position >>> 8 | rightBoard >>> 7;

		return new Result(Long.bitCount(mask), Long.toUnsignedString(mask));
	}

	private int popscnt(long value) {
		int count = 0;
		while (value > 0L) {
			count++;
			value &= (value - 1L);
		}

		return count;
	}

	@Override
	public String getName() {
		return "King";
	}
}
