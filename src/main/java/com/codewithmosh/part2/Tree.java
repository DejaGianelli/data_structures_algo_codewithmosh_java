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

    public boolean equals(Tree other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null) {
            return first.value == second.value &&
                    equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild),
                height(root.leftChild));
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

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

    public boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    // O(log n)
    public int min() {
        if (root == null)
            throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // O(n)
    public int min(Node root) {
        if (isLeaf(root))
            return root.value;
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
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

        System.out.println(tree.find(100));
        System.out.println(tree.find(7));
        System.out.println(tree.find(1));
        System.out.println(tree.find(10));

        tree.traversePreOrder();
        tree.traverseInOrder();
        tree.traversePostOrder();

        System.out.println("Height: " + tree.height());

        System.out.println("Min: " + tree.min());

        System.out.println("Finished");
    }
}
