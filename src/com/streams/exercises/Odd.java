package com.streams.exercises;

import java.util.*;

public class Odd {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 5, 2, 6);
        List<Integer> output = list.stream().filter(a -> a % 2 != 0).toList();
        System.out.println(output);
    }
}
