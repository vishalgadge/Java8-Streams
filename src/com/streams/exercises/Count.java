package com.streams.exercises;

import java.util.*;

public class Count {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 6, 8, 4);
        long output = list.stream().mapToInt(x -> x).count();
        System.out.println(output);
    }
}