package ru.otus;

import java.math.BigInteger;

public class QueenBitMaskCalculator {

    static String calculate(int input) {
        return new BigInteger(RookBitMaskCalculator.calculate(input))
                .or(new BigInteger(BishopBitMaskCalculator.calculate(input)))
                .toString();
    }
}
