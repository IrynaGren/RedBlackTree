package com.iryna.redblacktree.inputstrategy;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputStrategy implements NumbersInputStrategy {

    @Override
    public int[] getNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (comma separated):");
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
