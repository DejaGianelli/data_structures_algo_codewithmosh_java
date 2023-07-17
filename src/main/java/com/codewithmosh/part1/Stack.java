package com.codewithmosh.part1;

import java.util.Arrays;

public class Stack {
    private int count = 0;
    private int[] items = new int[5];

    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();
        items[count] = item;
        count++;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[count - 1];
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        count--;
        return items[count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var array = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
