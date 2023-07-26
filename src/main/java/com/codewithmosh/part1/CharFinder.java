package com.codewithmosh.part1;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {
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
    }
}
