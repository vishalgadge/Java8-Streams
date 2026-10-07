package com.streams.exercises;

import java.util.*;

public class Square {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 4, 3, 6);
        List<Integer> output = list.stream().map((x) -> x * x).toList();
        System.out.println(output);
    }
}
