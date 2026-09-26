package com.streams.exercises;

import java.util.*;
import java.util.stream.*;

/**
 * JAVA STREAMS EXERCISES FOR PRACTICE (Exhaustive Edition)
 * Fill in the TODO methods using Stream API functions!
 */
public class StreamExercises {

    public static class Employee {
        private String name;
        private String department;
        private double salary;
        private int age;

        public Employee(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return name + " (" + department + ", $" + salary + ", age " + age + ")";
        }
    }

    // EXERCISE 1: Filter even numbers from a list
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        // TODO: Return a list containing only even numbers
        return null;
    }

    // EXERCISE 2: Convert all strings to uppercase
    public static List<String> convertToUppercase(List<String> words) {
        // TODO: Convert all words to uppercase
        return null;
    }

    // EXERCISE 3: Find words starting with 'A' (case insensitive) and length > 3
    public static List<String> findSpecialWords(List<String> words) {
        // TODO: Filter words starting with 'a' or 'A' and length > 3
        return null;
    }

    // EXERCISE 4: Get unique sorted numbers in descending order
    public static List<Integer> getUniqueSortedDescending(List<Integer> numbers) {
        // TODO: Deduplicate and sort in descending order
        return null;
    }

    // EXERCISE 5: Flatten nested list of strings into a single list
    public static List<String> flattenLists(List<List<String>> nestedList) {
        // TODO: Flatten nested list into a single list
        return null;
    }

    // EXERCISE 6: Calculate sum of all elements using reduce
    public static int sumAllElements(List<Integer> numbers) {
        // TODO: Calculate total sum using stream reduce
        return 0;
    }

    // EXERCISE 7: Find the highest earning employee
    public static Optional<Employee> findHighestPaidEmployee(List<Employee> employees) {
        // TODO: Find employee with highest salary
        return Optional.empty();
    }

    // EXERCISE 8: Find average salary of employees in a given department using mapToDouble
    public static double getAverageSalaryByDept(List<Employee> employees, String dept) {
        // TODO: Calculate average salary for given department using mapToDouble
        return 0.0;
    }

    // EXERCISE 9: Group employees by department
    public static Map<String, List<Employee>> groupEmployeesByDept(List<Employee> employees) {
        // TODO: Group employees by department name
        return null;
    }

    // EXERCISE 10: Count employees in each department
    public static Map<String, Long> countEmployeesByDept(List<Employee> employees) {
        // TODO: Return map of Department -> Count of employees
        return null;
    }

    // EXERCISE 11: Join all employee names into a comma-separated String
    public static String getCommaSeparatedNames(List<Employee> employees) {
        // TODO: Join employee names using Collectors.joining(", ")
        return "";
    }

    // EXERCISE 12: Partition employees into High Earners (salary > 5000) and Others
    public static Map<Boolean, List<Employee>> partitionByHighSalary(List<Employee> employees) {
        // TODO: Partition employees into true (salary > 5000) and false
        return null;
    }

    // EXERCISE 13: Find top 3 oldest employees
    public static List<Employee> getTop3OldestEmployees(List<Employee> employees) {
        // TODO: Return top 3 oldest employees sorted by age descending
        return null;
    }

    // EXERCISE 14: Check if all employees are older than 18
    public static boolean areAllAdults(List<Employee> employees) {
        // TODO: Return true if all employees age > 18
        return false;
    }

    // EXERCISE 15: Calculate total sum of numbers from 1 to N using IntStream.rangeClosed
    public static long calculateSumUpToN(int n) {
        // TODO: Use IntStream.rangeClosed to sum 1 to N
        return 0;
    }

    // EXERCISE 16: Take elements while condition is met (takeWhile)
    public static List<Integer> takeNumbersWhileLessThan10(List<Integer> sortedNumbers) {
        // TODO: Use takeWhile to take numbers until a number >= 10 is encountered
        return null;
    }

    // EXERCISE 17: Drop elements while condition is met (dropWhile)
    public static List<Integer> dropNumbersWhileLessThan10(List<Integer> sortedNumbers) {
        // TODO: Use dropWhile to drop numbers until a number >= 10 is encountered
        return null;
    }

    // EXERCISE 18: Stream of nullable element (ofNullable)
    public static long countNonNullValue(String nullableValue) {
        // TODO: Use Stream.ofNullable and return count
        return 0;
    }

    // EXERCISE 19: Collecting and then modifying result (collectingAndThen)
    public static String getUpperJoinedNames(List<Employee> employees) {
        // TODO: Use Collectors.collectingAndThen with joining(", ") and String::toUpperCase
        return "";
    }

    // EXERCISE 20: Compute min and max in a single pass using Collectors.teeing
    public static String getMinAndMaxSalaryFormatted(List<Employee> employees) {
        // TODO: Use Collectors.teeing to format "Min=$X & Max=$Y"
        return "";
    }
}
