package ru.otus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LuckyTicket implements Testable<Integer, Long> {

    @Override
    public Long execute(Integer digitsNumber) {
        final List<Long> sumList = Stream
                .generate(() -> 0L)
                .limit(digitsNumber * 9 + 1)
                .collect(Collectors.toList());

        LongStream.range(0L, (long) Math.pow(10, digitsNumber))
                .map(LuckyTicket::calcSumDigits)
                .mapToInt(v -> (int) v)
                .forEach(sum -> sumList.set(sum, sumList.get(sum) + 1));

        return sumList
                .stream()
                .reduce(0L, (subTotal, value) -> subTotal += value * value);
    }

    private static int calcSumDigits(long value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }

        return sum;
    }

    @Override
    public Integer getArguments(List<String> input) {
        return Integer.parseInt(input.get(0));
    }

    @Override
    public Long getExpectedResult(List<String> output) {
        return Long.parseLong(output.get(0));
    }
}
