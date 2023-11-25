package com.codewithmosh.part2;

public class AVLTree {
    private static class AVLNode {
        public int value;
        public AVLNode leftChild;
        public AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        if (root == null) {
            root = new AVLNode(value);
            return;
        }
        insert(root, value);
    }

    public void insert(AVLNode node, int value) {
        if (value < node.value) {
            if (node.leftChild == null) {
                node.leftChild = new AVLNode(value);
                return;
            }
            insert(node.leftChild, value);
        } else {
            if (node.rightChild == null) {
                node.rightChild = new AVLNode(value);
                return;
            }
            insert(node.rightChild, value);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);

        System.out.println("Finished");
    }
}
