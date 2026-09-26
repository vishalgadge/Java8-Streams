package com.streams.solutions;

import com.streams.exercises.StreamExercises.Employee;
import java.util.*;
import java.util.stream.*;

/**
 * COMPLETE REFERENCE SOLUTIONS FOR ALL 20 STREAM EXERCISES
 */
public class StreamSolutions {

    // EXERCISE 1
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    // EXERCISE 2
    public static List<String> convertToUppercase(List<String> words) {
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // EXERCISE 3
    public static List<String> findSpecialWords(List<String> words) {
        return words.stream().filter(w -> w.toLowerCase().startsWith("a") && w.length() > 3).collect(Collectors.toList());
    }

    // EXERCISE 4
    public static List<Integer> getUniqueSortedDescending(List<Integer> numbers) {
        return numbers.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    // EXERCISE 5
    public static List<String> flattenLists(List<List<String>> nestedList) {
        return nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    // EXERCISE 6
    public static int sumAllElements(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    // EXERCISE 7
    public static Optional<Employee> findHighestPaidEmployee(List<Employee> employees) {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    // EXERCISE 8
    public static double getAverageSalaryByDept(List<Employee> employees, String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // EXERCISE 9
    public static Map<String, List<Employee>> groupEmployeesByDept(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    // EXERCISE 10
    public static Map<String, Long> countEmployeesByDept(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    // EXERCISE 11
    public static String getCommaSeparatedNames(List<Employee> employees) {
        return employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
    }

    // EXERCISE 12
    public static Map<Boolean, List<Employee>> partitionByHighSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
    }

    // EXERCISE 13
    public static List<Employee> getTop3OldestEmployees(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).limit(3).collect(Collectors.toList());
    }

    // EXERCISE 14
    public static boolean areAllAdults(List<Employee> employees) {
        return employees.stream().allMatch(e -> e.getAge() > 18);
    }

    // EXERCISE 15
    public static long calculateSumUpToN(int n) {
        return IntStream.rangeClosed(1, n).asLongStream().sum();
    }

    // EXERCISE 16
    public static List<Integer> takeNumbersWhileLessThan10(List<Integer> sortedNumbers) {
        return sortedNumbers.stream().takeWhile(n -> n < 10).collect(Collectors.toList());
    }

    // EXERCISE 17
    public static List<Integer> dropNumbersWhileLessThan10(List<Integer> sortedNumbers) {
        return sortedNumbers.stream().dropWhile(n -> n < 10).collect(Collectors.toList());
    }

    // EXERCISE 18
    public static long countNonNullValue(String nullableValue) {
        return Stream.ofNullable(nullableValue).count();
    }

    // EXERCISE 19
    public static String getUpperJoinedNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.collectingAndThen(Collectors.joining(", "), String::toUpperCase));
    }

    // EXERCISE 20
    public static String getMinAndMaxSalaryFormatted(List<Employee> employees) {
        return employees.stream().collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                (min, max) -> "Min=$" + (min.isPresent() ? min.get().getSalary() : 0)
                            + " & Max=$" + (max.isPresent() ? max.get().getSalary() : 0)
        ));
    }
}
