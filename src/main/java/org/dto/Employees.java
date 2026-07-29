package org.dto;

import java.util.Comparator;

public record Employees(String name, String department, Double salary) implements Comparable<Employees> {


    @Override
    public int compareTo(Employees other) {
        return this.name.compareTo(other.name);
       // return other.name.compareTo(this.name);
       // return other.salary.compareTo(this.salary);
    }
}
