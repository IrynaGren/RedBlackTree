package com.iryna.redblacktree.factory;

import com.iryna.redblacktree.inputstrategy.ConsecutiveNumbersStrategy;
import com.iryna.redblacktree.inputstrategy.ConsoleInputStrategy;
import com.iryna.redblacktree.inputstrategy.NumbersInputStrategy;
import com.iryna.redblacktree.inputstrategy.RandomNumbersStrategy;

public class NumbersInputStrategyFactory {

    public static NumbersInputStrategy getStrategy(int choice, int count) {
        switch (choice) {
            case 1:
                return new ConsoleInputStrategy();
            case 2:
                return new RandomNumbersStrategy(count);
            case 3:
                return new ConsecutiveNumbersStrategy(count);
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

}
