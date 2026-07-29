package org.example;

import org.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {
try
{
    List<Integer> numbers = List.of(22, 12,4,6,7,9,2,1,0,45,34,67);
    System.out.println("numbers:" + numbers);
    List<Integer> result = numbers.stream().filter(n -> n%2 == 0).filter(n -> n > 10).sorted(Comparator.reverseOrder()).toList();
    System.out.println("result:" + result);

    List<String> list = List.of("hello","test","world", "array");
    System.out.println("list:" + list);
    //boolean tiget = list.add("tiget");

    ArrayList<Employee> empList = new ArrayList<>();
    Employee e1 = null;
    empList.add(e1);

    Set<String> s1 = Set.of("a","z");
    System.out.println("Set:"+s1);
    List<String> mutable = new ArrayList<>(List.of("a", "b", "c"));
    System.out.println("mutable:" + mutable);
    mutable.add(null);
    System.out.println("new mutable:" + mutable);

    List<String> words = List.of("apple","avocado","banana","blueberry","cherry", "saathukudi");

// groupingBy — like SQL GROUP BY
    Map<Character, List<String>> byFirstLetter = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0)));
// {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
    System.out.println("byFirstLetter:" + byFirstLetter.values()  + " keys:" + byFirstLetter.keySet());

// counting within groups
    Map<Character, Long> countByLetter = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
    System.out.println("countByLetter:" + countByLetter.values()  + " keys:" + countByLetter.keySet());
// partitioningBy — splits into true/false map
    Map<Boolean, List<String>> longShort = words.stream()
            .collect(Collectors.partitioningBy(w -> w.length() > 6));
// {false=[apple, banana, cherry], true=[avocado, blueberry]}
    System.out.println("longShort:" + longShort.values()  + " keys:" + longShort.keySet());
    System.out.println("longshort.get(true):" + longShort.get(true));


// joining
    String joined = words.stream()
            .collect(Collectors.joining(", ", "[", "]"));
// "[apple, avocado, banana, blueberry, cherry]"
    System.out.println("joined:" + joined);






}catch (Exception e)
{
    System.out.println("Exception occurred");
    e.printStackTrace();;
}


    }
}
