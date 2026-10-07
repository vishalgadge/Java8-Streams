package com.streams.exercises;

import java.util.*;

public class Last {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 7, 4);
        int last = list.stream().reduce((a, b) -> b).orElse(0);
        System.out.println(last);
    }
}
