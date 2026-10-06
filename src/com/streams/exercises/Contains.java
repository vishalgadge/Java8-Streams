package com.streams.exercises;

import java.util.*;

public class Contains {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 5, 4, 6);
        boolean output = list.stream().anyMatch(a -> a == 5);
        System.out.println(output);
    }
}
