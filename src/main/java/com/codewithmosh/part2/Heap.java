package com.codewithmosh.part2;

public class Heap {
    private final int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[size++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        boolean isValid = items[index] >= leftChild(index);
        if (hasRightChild(index)) {
            isValid = isValid & items[index] >= rightChild(index);
        }
        return isValid;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    public void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public boolean isFull() {
        return size == items.length;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index, int parentIndex) {
        int temp = items[parentIndex];
        items[parentIndex] = items[index];
        items[index] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
        heap.remove();
        System.out.println("Done");
    }
}
