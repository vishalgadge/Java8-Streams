package com.streams.exercises;

import java.util.*;

public class Maximum {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 4, 3);
        int max = list.stream().mapToInt(x -> x).max().orElse(0);
        System.out.println(max);
    }
}
