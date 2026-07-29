package practice.day05;

import org.dto.Employees;

import java.util.*;
import java.util.stream.Collectors;

public class HighestPaidEmp {

    public static void main(String[] args)
    {
        //Invoke Get Highest paid EMployee method
        Employees e1 = new Employees("Sri", "IT", 240000.00);
        Employees e2 = new Employees("Raj", "IT", 210000.00);
        Employees e3 = new Employees("ram", "IT", 160000.00);
        Employees e4 = new Employees("Abhi", "IT", 185000.00);
        Employees e5 = new Employees("Ragh", "IT", 2500000.00);

        Employees e6 = new Employees("Alice", "FINANCE", 190000.00);
        Employees e7 = new Employees("Eve", "FINANCE", 180000.00);
        Employees e8 = new Employees("Mel", "FINANCE", 220000.00);
        Employees e9 = new Employees("Gina", "FINANCE", 250000.00);
        Employees e10 = new Employees("Shar", "FINANCE", 2250000.00);

        Employees e11 = new Employees("Bob", "ACCTS", 160000.00);
        Employees e12 = new Employees("Tim", "ACCTS", 250000.00);
        Employees e13 = new Employees("Ravi", "ACCTS", 195000.00);
        Employees e14 = new Employees("Anita", "ACCTS", 170000.00);
        Employees e15 = new Employees("Gail", "ACCTS", 150000.00);
        Employees e16 = new Employees("Akki", "ACCTS", 230000.00);

        List<Employees> employeesList = new ArrayList<>(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15));
        System.out.println("employeesList:"+ employeesList);
        Collections.sort(employeesList);
        System.out.println("Sorted naturally employeesList:"+ employeesList);
        Comparator<Employees> bySalary = Comparator.comparing(Employees::salary);
        //employeesList.sort(bySalary);
        System.out.println("Sorted with byName Custom comparator employeesList:"+ employeesList);
        Comparator<Employees> bySalaryReversedAndDept = bySalary.reversed().thenComparing(Employees::department);
       // Comparator<Employees> byNameClean = Comparator.comparing(Employee::getName);

        employeesList.sort(bySalaryReversedAndDept);
        System.out.println("Sorted with bySalaryReversedAndDept Custom comparator employeesList:"+ employeesList);

        HighestPaidEmp hpe = new HighestPaidEmp();
        hpe.getHighestPaidEmp(employeesList);
        System.out.println();
    }

    public Map<String, List<Employees>> getHighestPaidEmp(List<Employees> employeesList)
    {
        //Given a list of Employee objects (name, department, salary),
        // write a method using Streams that returns a Map containing
        // the top 3 highest-paid employees per department, sorted by salary descending.

        Map<String, List<Employees>> employeesMap = new HashMap<>();

        if(employeesList == null || employeesList.isEmpty())
            return employeesMap;

        // FOr each department, return the top 3 highest paid employees.
        //  Group them by Department
        // sort by salary descending
        //pick the Top 3
        //Map <DeptName, List<Employees>>


        Map<String, List<Employees>> test =  employeesList.stream()
               .collect(Collectors.groupingBy(Employees::department,Collectors.collectingAndThen(
                       Collectors.toList(),
                       list -> list
                                                .stream()
                                                .sorted(Comparator.comparingDouble(Employees::salary).reversed())
                               .limit(3).toList()
               )));

              // .collect(Collectors.groupingBy(Employees::department));
       //                (Collectors.groupingBy(Payment::getStatus,Collectors.summingDouble(Payment::getAmount)));

               //.sorted(Comparator.comparingDouble(Employees::salary).reversed()).toList();
        System.out.println("Test:"+test);

        return employeesMap;
    }
}
