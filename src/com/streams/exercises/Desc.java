package com.streams.exercises;

import java.util.*;

public class Desc {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 3, 6, 7, 4);
        List<Integer> output = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(output);
    }
}
