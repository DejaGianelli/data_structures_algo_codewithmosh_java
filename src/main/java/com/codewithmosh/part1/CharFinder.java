package com.codewithmosh.part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public Character findFirstRepeatadCharacter(String str) {
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

    public Character findFirstNonRepeatadCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                Integer count = map.get(ch);
                map.put(ch, (count + 1));
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        var str = "a green apple";
        var finder = new CharFinder();
        var ch = finder.findFirstNonRepeatadCharacter(str);
        System.out.println(ch);

        str = "green apple";
        ch = finder.findFirstRepeatadCharacter(str);
        System.out.println(ch);
    }
}
