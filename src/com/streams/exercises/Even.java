package com.streams.exercises;

import java.util.*;

public class Even {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 5, 4, 6);
        List<Integer> output = list.stream().filter(a -> a % 2 == 0).toList();
        System.out.println(output);
    }
}
