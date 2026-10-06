package com.streams.exercises;
import java.util.*;

class Sum{
    public static void main(String[] args) {
        List<Integer> list = List.of(2,5,4,6,7,1);
        int sum=list.stream().mapToInt(x->x).sum();
        System.out.println(sum);
    }
}