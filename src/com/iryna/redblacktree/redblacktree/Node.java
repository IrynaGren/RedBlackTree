package com.iryna.redblacktree.redblacktree;

public class Node {

    int data;
    Node parent;
    Node left;
    Node right;
    Color color;

    public Node(int data) {
        this.data = data;
        this.color = Color.RED;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Color getColor() {
        return color;
    }

}
