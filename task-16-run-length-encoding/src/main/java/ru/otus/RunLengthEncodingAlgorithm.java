package ru.otus;

import ru.otus.util.List;

public class RunLengthEncodingAlgorithm {

	public static byte[] encode(byte[] bytes) {
		final List<Byte> result = new List<>();

		int runLengthIdx = 0;
		for (int byteIdx = 0; byteIdx < bytes.length; byteIdx++) {

			byte runLength = 1;
			while (byteIdx + 1 < bytes.length && bytes[byteIdx] == bytes[byteIdx + 1] && runLength < Byte.MAX_VALUE) {
				runLength++;
				byteIdx++;
			}

			if (runLength > 1) {
				result.add(runLength);
				runLengthIdx = result.size() + 1;
			} else if (runLengthIdx == result.size()) {
				result.add((byte) -1);
			} else {
				final byte negativeCounterValue = result.get(runLengthIdx);
				if (negativeCounterValue > Byte.MIN_VALUE) {
					result.set(runLengthIdx, (byte) (result.get(runLengthIdx) - 1));
				} else {
					result.add((byte) -1);
					runLengthIdx = result.size() + 1;
				}
			}

			result.add(bytes[byteIdx]);
		}

		return toPrimitive(result);
	}

	public static byte[] decode(byte[] bytes) {
		final List<Byte> result = new List<>();

		for (int byteIdx = 0; byteIdx < bytes.length; byteIdx++) {
			final byte runLength = bytes[byteIdx];

			if (runLength > 0) {
				for (int i = 0; i < runLength; i++) {
					result.add(bytes[byteIdx + 1]);
				}
				byteIdx++;
			}

			if (runLength < 0) {
				for (int i = 0; i < Math.abs(runLength); i++) {
					result.add(bytes[i + byteIdx + 1]);
				}

				byteIdx += Math.abs(runLength);
			}
		}


		return toPrimitive(result);
	}

	private static byte[] toPrimitive(List<Byte> list) {
		final byte[] result = new byte[list.size()];
		int index = 0;

		for (Byte item : list) {
			result[index++] = item;
		}

		return result;
	}
}
