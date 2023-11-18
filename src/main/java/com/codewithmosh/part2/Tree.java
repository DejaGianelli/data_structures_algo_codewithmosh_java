package com.codewithmosh.part2;

public class Tree {
    public static class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(10);
        System.out.println("Finished");
    }
}
