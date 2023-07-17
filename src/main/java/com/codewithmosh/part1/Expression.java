package com.codewithmosh.part1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> RIGHT_BRACKETS = Arrays.asList(')', '>', ']', '}');
    private final List<Character> LEFT_BRACKETS = Arrays.asList('(', '<', '[', '{');

    public boolean isBalanced(String str) {
        if (str.isEmpty())
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean bracketsMatch(char left, Character right) {
        return LEFT_BRACKETS.indexOf(left) == RIGHT_BRACKETS.indexOf(right);
    }

    private boolean isRightBracket(char c) {
        return RIGHT_BRACKETS.contains(c);
    }

    private boolean isLeftBracket(char c) {
        return LEFT_BRACKETS.contains(c);
    }

    public static void main(String[] args) {
        Expression expression = new Expression();
        boolean balanced = expression.isBalanced("(1 + 2)");
//        boolean balanced = expression.isBalanced("(1 + 2>");
//        boolean balanced = expression.isBalanced(")1 + 2)");
//        boolean balanced = expression.isBalanced("}1 + 2)");
        System.out.println(balanced);
    }
}
