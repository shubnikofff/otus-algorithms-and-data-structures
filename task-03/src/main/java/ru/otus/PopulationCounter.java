package ru.otus;

import java.math.BigInteger;
import java.util.Map;

import static java.util.Map.entry;

public class PopulationCounter {

    private final static Map<Integer, Integer> POPULATION_MAP = Map.ofEntries(
            entry(0, 0),
            entry(1, 1),
            entry(2, 1),
            entry(3, 2),
            entry(4, 1),
            entry(5, 2),
            entry(6, 2),
            entry(7, 3),
            entry(8, 1),
            entry(9, 2),
            entry(10, 2),
            entry(11, 3),
            entry(12, 2),
            entry(13, 3),
            entry(14, 3),
            entry(15, 4)
    );

    static int count(long mask) {
        BigInteger absMask = new BigInteger(Long.toUnsignedString(mask));
        int count = 0;

        while (absMask.compareTo(BigInteger.ZERO) > 0) {
            final BigInteger shift = absMask.and(BigInteger.valueOf(15L));
            count += POPULATION_MAP.get(shift.intValue());
            absMask = absMask.shiftRight(4);
        }

        return count;
    }
}
