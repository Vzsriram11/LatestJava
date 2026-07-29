package org.example;

import org.dto.Employee;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestFeatures {



    private final AtomicInteger count = new AtomicInteger(104);

    public void increment() {
        count.incrementAndGet(); // Thread-safe, non-blocking, and incredibly fast

    }

    public int getCount() {
        return count.get();
    }
    public static  void main (String[] args)
    {

        Employee sriram = createEmployee("Sriram", "IT", 200000);
        Employee alice = createEmployee("Alice","HR", 150000);
        Employee bob = createEmployee("Bob","Sales", 190000);
        Employee keerthy = createEmployee("Keerthy", "IT", 210000);
       // System.out.println("Sriram:" + sriram + " alice:"+ alice + " bob:" + bob);

        List<Employee> employees =  new ArrayList<Employee>();
        employees.add(sriram);
        employees.add(alice);
        employees.add(bob);
        employees.add(keerthy);
        System.out.println("List of employees:"+ employees);
        System.out.println("employees.get(3):"+employees.get(3));


       List<String> names = employees.stream().filter(e -> e.getSalary() > 180000)
                .map(Employee::getName).sorted().toList();
        System.out.println("Names of employees with Sal > 180K:"+ names);

        System.out.println("employees.stream().findFirst():" + employees.stream().findFirst());

        // Sample list of immutable Employee records
        List<Employee> employees2 = Arrays.asList(
                createEmployee("Alice", "HR", 5000),
                createEmployee("Bob", "IT", 7000),
                createEmployee("Charlie", "IT", 7000),
                createEmployee("Diana", "HR", 3000),
                createEmployee("Ethan", "Finance", 8000)
        );

        // Stream Pipeline: Filter -> Sort -> Group
        Map<String, List<Employee>> employeesByDept = employees.stream()
                // 1. Filter: Keep only employees earning more than $4,000
                .filter(emp -> emp.getSalary() > 4000)

                // 2. Sort: Salary (descending), then Name (alphabetically)
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))

                // 3. Group: Collect into a Map split by Department name
                .collect(Collectors.groupingBy(Employee::getDept));

        // Print the final grouped structures
        employeesByDept.forEach((dept, deptList) -> {
            System.out.println("\nDepartment: " + dept);
            //deptList.forEach(System.out.println);
        });


        //Lambda way sorting

        employees.sort((e1, e2) -> e2.getSalary() - e1.getSalary());

      /*  Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getSalary() - e1.getSalary();
            }
        });*/
       System.out.println("List of employees Descending salary:"+ employees);

       /* Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getSalary() - e2.getSalary();
            }
        });*/

        List<Employee> result = new ArrayList<>();
/*
        for(Employee e : employees){
            if(e.getSalary() > 180000){
                result.add(e);
            }
        }*/
       // result = null;
        result = employees.stream().filter( e -> e.getSalary() > 180000).filter( e -> e.getDept().equalsIgnoreCase("IT")) .toList();

        System.out.println("List of employees with Sal > 180K in IT:"+ result);
        result = null;



        employees.sort((e1, e2) -> e1.getSalary() - e2.getSalary());

        System.out.println("List of employees Ascending Salary:"+ employees);

        List <Integer> numbers = Arrays.asList(6,5,2,8,1,7);
  int resultNum = numbers.stream().filter(n -> n%2 ==1).map(n -> n*2).reduce(0,(c,e)->c+e);
        System.out.println("Result:"+ resultNum);

        TestFeatures l8 = new TestFeatures();
        l8.increment();
        System.out.println("l8.getCount:" + l8.getCount());


        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        System.out.println(a.add(b));

        //System.out.println("dAmount:" + dAmount);

        List<String> namesList = List.of("Alice","bob", "John", "Alice");
        //namesList.add("Tim");
        List <String> upper = namesList.stream().filter( name -> name.length() >3).map(String::toUpperCase).toList();
        System.out.println("nameslist:"+namesList);
        System.out.println("upper:"+upper);
        System.out.println("unique:"+ namesList.stream().distinct().count());

        List <Integer> num = List.of(21,12,13,4, 2,1);
        int sum = num.stream().reduce(0, Integer::sum);

        //create a HashSet
        HashSet<String> brands = new HashSet<>();
        System.out.println("brands after initialized:"+brands);
        System.out.println("brands.size():" + brands.size());
        //Add elements to the HashSet
        brands.add("Adidas");
        brands.add("Nike");
        brands.add("Puma");

        //Try to add duplicate - will be ignored
        brands.add("Puma");
        //Print the entire set
        System.out.println("brands:"+brands);
        System.out.println("brands.size:" + brands.size());
        if(brands.contains("Adidas"))
            System.out.println("brand Adidas exists");

        //Remove an element
        brands.remove("Adidas");
        //Print the entire set
        System.out.println("brands:"+brands);
        System.out.println("brands.size:" + brands.size());

        //Iterate the Set

        for (String brand: brands)
        {
            System.out.println(brand);
        }
        System.out.println("brands.size:" + brands.size());
        brands.clear();
        //check size again after clearing
        System.out.println("brands.size:" + brands.size() + " isEmpty:" + brands.isEmpty()) ;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,350);
        System.out.println("map.get:" + map.get(350));
        System.out.println("map.get(3):" + map.get(3));
        System.out.println("map.containskey:"+ map.containsKey(3));
        System.out.println("map.containskey:"+ map.containsKey(350));
        System.out.println("map.getorkeydefault:"+ map.getOrDefault(1,-1));
        System.out.println("map.getorkeydefault:"+ map.getOrDefault(350,-1));
        map.remove(2);
        System.out.println("map.get(2):" + map.get(2));

        int[] num1 = new int[5];
        System.out.println("num array:" + Arrays.toString(num1));
        String [] strArray = new String[15];
        System.out.println("strArray array:" + Arrays.toString(strArray));




    }


    private static Employee createEmployee(String name, String dept, int salary) {
        Employee employee = new Employee();
        employee.setDept(dept);
        employee.setName(name);
        employee.setSalary(salary);
        return employee;
    }
}
