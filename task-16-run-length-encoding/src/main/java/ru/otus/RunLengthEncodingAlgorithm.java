package ru.otus;

import ru.otus.util.List;

public class RunLengthEncodingAlgorithm {

	public static byte[] encode(byte[] bytes) {
		final List<Byte> result = new List<>();

		int negativeCounterIdx = 0;
		for (int i = 0; i < bytes.length; i++) {

			byte counter = 1;
			while (i + 1 < bytes.length && bytes[i] == bytes[i + 1] && counter < Byte.MAX_VALUE) {
				counter++;
				i++;
			}

			if (counter > 1) {
				result.add(counter);
				negativeCounterIdx = result.size() + 1;
			} else if (negativeCounterIdx == result.size()) {
				result.add((byte) -1);
			} else {
				final byte negativeCounterValue = result.get(negativeCounterIdx);
				if (negativeCounterValue > Byte.MIN_VALUE) {
					result.set(negativeCounterIdx, (byte) (result.get(negativeCounterIdx) - 1));
				} else {
					result.add((byte) -1);
					negativeCounterIdx = result.size() + 1;
				}
			}

			result.add(bytes[i]);
		}

		return toPrimitive(result);
	}

	public static byte[] decode(byte[] bytes) {
		final List<Byte> result = new List<>();

		for (int i = 0; i < bytes.length; i++) {
			final byte runLength = bytes[i];

			if(runLength > 0) {
				final byte value = bytes[i + 1];

				for (int j = 0; j < runLength; j++) {
					result.add(value);
				}

				i++;
			}

			if(runLength < 0) {
				for (int j = 0; j < Math.abs(runLength); j++) {
					result.add(bytes[j + i + 1]);
				}

				i += Math.abs(runLength);
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
