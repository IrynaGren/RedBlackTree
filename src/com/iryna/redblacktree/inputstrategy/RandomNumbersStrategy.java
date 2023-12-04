package com.iryna.redblacktree.inputstrategy;

import java.util.Random;

public class RandomNumbersStrategy implements NumbersInputStrategy {

    private int count;

    public RandomNumbersStrategy(int count) {
        this.count = count;
    }

    @Override
    public int[] getNumbers() {
        return new Random().ints(count, 1, 100).toArray();
    }

}
