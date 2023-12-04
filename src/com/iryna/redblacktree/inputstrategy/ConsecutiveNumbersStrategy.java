package com.iryna.redblacktree.inputstrategy;

import java.util.stream.IntStream;

public class ConsecutiveNumbersStrategy implements NumbersInputStrategy {

    private int count;

    public ConsecutiveNumbersStrategy(int count) {
        this.count = count;
    }

    @Override
    public int[] getNumbers() {
        return IntStream.range(1, count + 1).toArray();
    }
}
