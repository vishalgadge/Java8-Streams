package com.streams.exercises;

import java.util.Map;
import java.util.stream.Collectors;

public class OccuranceOfChar {
    public static void main(String[] args) {
        String input = "hello";
        Map<Character, Long> charCounts = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Character Counts: " + charCounts);
    }
}
