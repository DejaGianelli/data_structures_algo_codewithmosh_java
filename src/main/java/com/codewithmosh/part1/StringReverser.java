package com.codewithmosh.part1;

import java.util.Objects;
import java.util.Stack;

import static java.util.Objects.isNull;

/**
 * Reverse a string using Java Stack class
 */
public class StringReverser {
    public String reverse(String str) {
        if (isNull(str))
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    public static void main(String[] args) {
        StringReverser reverser = new StringReverser();
        String reversed = reverser.reverse("abcd");
        System.out.println(reversed);
    }
}
