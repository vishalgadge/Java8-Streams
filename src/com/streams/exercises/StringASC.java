package com.streams.exercises;

import java.util.*;

public class StringASC {
    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "cherry");
        List<String> output = words.stream().sorted().toList();
        System.out.println(output);
    }
}
