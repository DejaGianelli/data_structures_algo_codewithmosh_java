package com.codewithmosh.part2;

public class AVLTree {
    private static class AVLNode {
        public int value;
        public AVLNode leftChild;
        public AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        root.height = balanceFactor(root);

        if (isLeftHeavy(root))
            System.out.println(root.value + " is left heavy");

        if (isRightHeavy(root))
            System.out.println(root.value + "is right heavy");

        return root;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);

        AVLTree tree2 = new AVLTree();
        tree2.insert(30);
        tree2.insert(20);
        tree2.insert(10);

        System.out.println("Finished");
    }
}
