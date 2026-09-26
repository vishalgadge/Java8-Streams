package com.streams;

import com.streams.exercises.StreamExercises.Employee;
import com.streams.solutions.StreamSolutions;

import java.util.*;

public class TestRunner {

    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("   EXHAUSTIVE STREAM EXERCISES TEST RUNNER");
        System.out.println("=======================================================\n");

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering", 7500, 30),
                new Employee("Bob", "HR", 4000, 45),
                new Employee("Charlie", "Engineering", 9000, 28),
                new Employee("David", "Sales", 5500, 35),
                new Employee("Eva", "HR", 4800, 22),
                new Employee("Frank", "Engineering", 6000, 50)
        );

        int passed = 0;
        int total = 20;

        passed += check("Ex 1: Filter Even", StreamSolutions.filterEvenNumbers(Arrays.asList(1,2,3,4,5,6)), Arrays.asList(2,4,6));
        passed += check("Ex 2: Uppercase", StreamSolutions.convertToUppercase(Arrays.asList("java", "stream")), Arrays.asList("JAVA", "STREAM"));
        passed += check("Ex 3: Find Special Words", StreamSolutions.findSpecialWords(Arrays.asList("Apple", "art", "Amazon", "banana")), Arrays.asList("Apple", "Amazon"));
        passed += check("Ex 4: Unique Sorted Desc", StreamSolutions.getUniqueSortedDescending(Arrays.asList(3,1,4,1,5,9,2,6,5)), Arrays.asList(9,6,5,4,3,2,1));
        passed += check("Ex 5: Flatten Lists", StreamSolutions.flattenLists(Arrays.asList(Arrays.asList("a","b"), Arrays.asList("c"))), Arrays.asList("a","b","c"));
        passed += check("Ex 6: Sum Reduce", StreamSolutions.sumAllElements(Arrays.asList(10, 20, 30)), 60);
        passed += check("Ex 7: Highest Paid", StreamSolutions.findHighestPaidEmployee(employees).map(Employee::getName).orElse(""), "Charlie");
        passed += check("Ex 8: Avg Salary Eng", Math.round(StreamSolutions.getAverageSalaryByDept(employees, "Engineering")), 7500L);
        passed += check("Ex 9: Group Dept Eng Count", StreamSolutions.groupEmployeesByDept(employees).get("Engineering").size(), 3);
        passed += check("Ex 10: Count Dept HR", StreamSolutions.countEmployeesByDept(employees).get("HR"), 2L);
        passed += check("Ex 11: Joined Names", StreamSolutions.getCommaSeparatedNames(employees), "Alice, Bob, Charlie, David, Eva, Frank");
        passed += check("Ex 12: Partition High Salary", StreamSolutions.partitionByHighSalary(employees).get(true).size(), 4);
        passed += check("Ex 13: Top 3 Oldest", StreamSolutions.getTop3OldestEmployees(employees).stream().map(Employee::getName).collect(java.util.stream.Collectors.toList()), Arrays.asList("Frank", "Bob", "David"));
        passed += check("Ex 14: Are All Adults", StreamSolutions.areAllAdults(employees), true);
        passed += check("Ex 15: Sum Up To N (100)", StreamSolutions.calculateSumUpToN(100), 5050L);
        passed += check("Ex 16: takeWhile < 10", StreamSolutions.takeNumbersWhileLessThan10(Arrays.asList(2,4,8,12,14)), Arrays.asList(2,4,8));
        passed += check("Ex 17: dropWhile < 10", StreamSolutions.dropNumbersWhileLessThan10(Arrays.asList(2,4,8,12,14)), Arrays.asList(12,14));
        passed += check("Ex 18: ofNullable(null)", StreamSolutions.countNonNullValue(null), 0L);
        passed += check("Ex 19: collectingAndThen", StreamSolutions.getUpperJoinedNames(employees), "ALICE, BOB, CHARLIE, DAVID, EVA, FRANK");
        passed += check("Ex 20: Collectors.teeing", StreamSolutions.getMinAndMaxSalaryFormatted(employees), "Min=$4000.0 & Max=$9000.0");

        System.out.println("\n-------------------------------------------------------");
        System.out.println(" RESULTS: " + passed + " / " + total + " TESTS PASSED!");
        System.out.println("-------------------------------------------------------");
    }

    private static int check(String testName, Object actual, Object expected) {
        boolean pass = Objects.equals(actual, expected);
        if (pass) {
            System.out.printf("  [PASS] %-32s | Result: %s%n", testName, actual);
            return 1;
        } else {
            System.out.printf("  [FAIL] %-32s | Actual: %s, Expected: %s%n", testName, actual, expected);
            return 0;
        }
    }
}
