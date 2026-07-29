package org.dto;

import java.util.List;

public class Department

{
    private String deptName;

    private List<Employee> employeeList;

    public String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}