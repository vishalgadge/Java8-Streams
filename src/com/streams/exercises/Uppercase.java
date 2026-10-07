package com.streams.exercises;

import java.util.*;

public class Uppercase {
    public static void main(String[] args) {
        List<String> list = List.of("hello", "hi");
        List<String> output = list.stream().map(x -> x.toUpperCase()).toList();
        System.out.println(output);
    }
}
