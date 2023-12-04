package com.iryna.redblacktree;

import com.iryna.redblacktree.inputhandler.NumberInputHandler;
import com.iryna.redblacktree.redblacktree.RedBlackTree;

import java.util.Scanner;

public class RedBlackTreeApp {

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        Scanner scanner = new Scanner(System.in);

        NumberInputHandler inputHandler = new NumberInputHandler(scanner);
        int[] numbers = inputHandler.getNumbers();

        for (int number : numbers) {
            tree.insert(number);
        }

        tree.inorder();
    }
}

