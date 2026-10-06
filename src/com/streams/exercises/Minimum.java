package com.streams.exercises;

import java.util.*;

public class Minimum {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 5, 4, 7);
        int output = list.stream().mapToInt(x -> x).min().orElse(0);
        System.out.println(output);
    }
}
