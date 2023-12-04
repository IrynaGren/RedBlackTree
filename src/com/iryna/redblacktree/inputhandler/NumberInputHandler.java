package com.iryna.redblacktree.inputhandler;

import com.iryna.redblacktree.factory.NumbersInputStrategyFactory;
import com.iryna.redblacktree.inputstrategy.NumbersInputStrategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputHandler {

    private final Scanner scanner;

    public NumberInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[] getNumbers() {
        NumbersInputStrategy strategy;
        while (true) {
            try {
                System.out.println("Choose input method:\n" +
                        "1. Manual\n" +
                        "2. Automatic Random\n" +
                        "3. Automatic Ascending Order");
                int choice = scanner.nextInt();
                strategy = NumbersInputStrategyFactory.getStrategy(choice, 10);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return strategy.getNumbers();
    }
}
