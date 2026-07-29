package org.example;

import org.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

record UserProfile(String username, int userId) {}
record Product (String name, double price) {};

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        /*for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }*/

        List<String> names = List.of("Anna", "Bob", "Charlie","Alice", "Arun", "Ambi");
        System.out.println("names:" + names);
        List<String> result = names.stream().filter(n -> n.startsWith("A")).map(String::toUpperCase).toList();
        //names= null;
       // Stream nameStream = names.stream();
       // System.out.println("nameStream:" + nameStream);
    //    List<String> result  = names.stream().filter(name -> name.endsWith("e")).map(String::toUpperCase).sorted().toList();//  .map(String::toLowerCase).sorted().toList();
        System.out.println(" result:" + result);

        Employee alice = createEmployee("Alice", "Eng", 95000);
        Employee bob = createEmployee("Alice", "Eng", 120000);
        Employee carol = createEmployee("Carol", "Eng", 88000);
        System.out.println("alice.hashcode:" + alice.hashCode());
        System.out.println("bob.hashcode:" + bob.hashCode());
        //Employee alice = createEmployee("Dave", "HR", "$65K");
       // Employee alice = createEmployee("Eve", "Eng", "$110K");
       // Employee alice = createEmployee("Alice", "Eng", "$95K");

        List<List<String>> nestedWords = List.of(
                List.of("apple", "banana"),
                List.of("cherry")
        );
        System.out.println("nestedWords:" + nestedWords);

        List<String> flattenedWords = nestedWords.stream()
                .flatMap(List::stream) // Converts each List into a Stream and flattens them
                .collect(Collectors.toList());
        System.out.println("flattenedWords:" + flattenedWords);

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Optional<String> s = Optional.of("test");
        System.out.println(("s:"+s));

        List <String> myList2 = Stream.of("a","b").map(String::toUpperCase).toList();
        System.out.println(("mylist2 from map:" + myList2));
       // myList2.

        /*List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);
        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .toList());*/


       HashMap<String,Integer>  inventory = new HashMap<>();
       //add elements
        inventory.put("Apple",50);
        inventory.put("Banana",20);
        inventory.put("Orange",60);
        System.out.println("inventory:"+inventory);
        System.out.println("Total unique items:"+inventory.size());

        if(inventory.containsKey("Orange"))
            System.out.println("oranges are in stock");

        inventory.remove("Orange");
        inventory.put(null, 70);
        inventory.put(null, 91);
        inventory.put("Banana",45);

        System.out.println("inventory:"+inventory);
        System.out.println("Total unique items:"+inventory.size());
        UserProfile up = new UserProfile("sri",423099);
        System.out.println("Up:"+ up);
     Product gadget = new Product("Apple ipad", 999);
        System.out.println("gadget:" + gadget);
        System.out.println("gadget.name:" + gadget.name());

        //Learn Lamb




    }

    private static Employee createEmployee(String name, String dept, int salary) {
        Employee employee = new Employee();
        employee.setDept(dept);
        employee.setName(name);
        employee.setSalary(salary);
        return employee;
    }


}