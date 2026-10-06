package com.streams.exercises;
import java.util.*;
public class Product {
    public static void main(String[] args) {
    List<Integer> list = List.of(2,4,2,3,5);
    int output = list.stream().reduce( (a,b) -> a*b).orElse(0);  
    System.out.println(output);      
    }

}
