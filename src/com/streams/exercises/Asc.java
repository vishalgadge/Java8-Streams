package com.streams.exercises;

import java.util.*;

public class Asc {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 4, 6, 2, 4);
        List<Integer> output = list.stream().sorted().toList();
        System.out.println(output);
    }
}
