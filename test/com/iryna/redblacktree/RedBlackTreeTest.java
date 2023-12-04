package com.iryna.redblacktree;

import com.iryna.redblacktree.redblacktree.Color;
import com.iryna.redblacktree.redblacktree.Node;
import com.iryna.redblacktree.redblacktree.RedBlackTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    private RedBlackTree tree;

    @BeforeEach
    void setUp() {
        tree = new RedBlackTree();
    }

    @Test
    void whenInsertingElements_thenRootShouldBeBlackAndCorrectValue() {
        // Given: an empty Red-Black Tree
        // When: inserting elements into the tree
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);

        // Then: the tree root should be 10 and colored black
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().getData());
        Assertions.assertEquals(Color.BLACK, tree.getRoot().getColor());
    }

    @Test
    void whenDeletingElement_thenTreeShouldMaintainRedBlackProperties() {
        // Given: a Red-Black Tree with elements
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);

        // When: deleting an element from the tree
        tree.deleteNode(10);

        // Then: the tree root should be 15 and the tree should maintain Red-Black properties
        assertNotNull(tree.getRoot());
        assertEquals(15, tree.getRoot().getData());
        assertTrue(validateRedBlackProperties(tree));
    }

    @Test
    void whenDeletingEachElement_thenTreeShouldAlwaysMaintainRedBlackProperties() {
        // Given: a Red-Black Tree with elements
        int[] values = {15, 6, 23, 4, 7, 71, 5, 50};
        for (int value : values) {
            tree.insert(value);
        }

        // When: deleting each element from the tree
        // Then: the tree should maintain Red-Black properties after each deletion
        for (int value : values) {
            tree.deleteNode(value);
            assertTrue(validateRedBlackProperties(tree), "Tree violates properties after removing " + value);
        }
    }

    @Test
    void afterInsertingMultipleElements_treeShouldMaintainRedBlackProperties() {
        // Given: a Red-Black Tree with elements
        int[] values = {15, 6, 23, 4, 7, 71, 5, 50};
        for (int value : values) {
            tree.insert(value);
        }

        // When: the tree is constructed
        // Then: it should maintain Red-Black properties
        assertTrue(validateRedBlackProperties(tree));
    }

    private boolean validateRedBlackProperties(RedBlackTree tree) {
        Node root = tree.getRoot(); // Assuming getRoot() is a public method returning the root
        if (root == null) {
            return true; // An empty tree is valid
        }

        // Check if root is black
        if (root.getColor() != Color.BLACK) {
            return false;
        }

        // Start recursive validation from the root
        return isBalanced(root, 0, -1);
    }

    private boolean isBalanced(Node node, int blackCount, int pathBlackCount) {
        if (node == null) { // Treat null as the NIL node
            if (pathBlackCount == -1) {
                pathBlackCount = blackCount;
            }
            return blackCount == pathBlackCount;
        }

        if (node.getColor() == Color.BLACK) {
            blackCount++;
        } else {
            if ((node.getLeft() != null && node.getLeft().getColor() == Color.RED) ||
                    (node.getRight() != null && node.getRight().getColor() == Color.RED)) {
                return false; // Red node has a red child
            }
        }

        return isBalanced(node.getLeft(), blackCount, pathBlackCount) &&
                isBalanced(node.getRight(), blackCount, pathBlackCount);
    }

}