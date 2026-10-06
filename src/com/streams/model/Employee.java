package com.streams.model;

/**
 * Shared Employee model for Java Stream exercises and solutions.
 */
public class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = 0;
    }

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ", age " + age + ")";
    }
}
