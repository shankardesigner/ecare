package com.shankardesigner.ecare.test.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        if(this.getSalary() > employee.getSalary()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Runner {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"Shankar Bhattarai",45000));
        employees.add(new Employee(2,"Sundar Bhattarai",80000));
        employees.add(new Employee(3,"Krishna Bhattarai",80000));
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if(emp1.getId() > emp2.getId()) {
                    return 1;
                }
                return -1;
            }
        });

        System.out.println(employees);

    }
}