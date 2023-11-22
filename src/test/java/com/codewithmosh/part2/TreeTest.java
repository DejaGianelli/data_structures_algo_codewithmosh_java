package com.codewithmosh.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeTest {
    @Test
    void printNodesAtKDistance() {
        Tree first = new Tree();
        first.add(7);
        first.add(4);
        first.add(9);
        first.add(1);
        first.add(6);
        first.add(8);
        first.add(10);

        assertTrue(true);
    }

    @Test
    void testIsEqual() {
        Tree first = new Tree();
        first.add(7);
        first.add(4);
        first.add(9);
        first.add(1);
        first.add(6);
        first.add(8);
        first.add(10);

        Tree second = new Tree();
        second.add(7);
        second.add(4);
        second.add(9);
        second.add(1);
        second.add(6);
        second.add(8);
        second.add(10);

        assertTrue(first.equals(second));
    }

    @Test
    void testIsNotEqual() {
        Tree first = new Tree();
        first.add(7);
        first.add(4);
        first.add(9);
        first.add(1);
        first.add(6);
        first.add(8);
        first.add(9);

        Tree second = new Tree();
        second.add(7);
        second.add(4);
        second.add(9);
        second.add(1);
        second.add(6);
        second.add(8);
        second.add(10);

        assertFalse(first.equals(second));
    }
}