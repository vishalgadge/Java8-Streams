package com.streams.exercises;

import java.util.*;

public class Average {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 2, 5, 4);
        double output = list.stream().mapToInt(x -> x).average().orElse(0);
        System.out.println(output);
    }
}
