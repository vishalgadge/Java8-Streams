package com.streams.exercises;

import java.util.stream.Stream;

public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345;
        int sum = String.valueOf(number).chars().map(Character::getNumericValue).sum();
        System.out.println(sum);
    }
}
