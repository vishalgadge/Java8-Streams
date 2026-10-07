package com.streams.exercises;

import java.util.*;

public class First {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 4, 6);
        int first = list.stream().findFirst().orElse(0);
        System.out.println(first);
    }
}
