package practice.day07;

import org.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Day07 {


    //Given a list of integers,
    // write a program to find and print the elements with the lowest frequency using Java Stream API.
    public static  void main(String[] args)
    {

        List<Integer>  numbers = List.of(100, 121, 23,100, 45,23, 100,121,45,76,89,19);
        System.out.println("Numbers:"+numbers);
       Map<Integer,Long> map =  numbers.stream()
               //if We wanna preserve the input order use LinkedHashmap
                                     //   .collect(Collectors.groupingBy(Integer::intValue,LinkedHashMap::new,Collectors.counting()));
//If we don't wanna preserve the input order use regular HashMap which is be default; we don't need pass it explicitly
                                        .collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));

        System.out.println("Map:"+ map);
       // long minFrequency= map.values().stream().min(Comparator.naturalOrder()).orElseThrow();
        long minFrequency= map.values().stream().mapToLong(Long::longValue).min().orElseThrow();
        //long minFrequency = lowestFrequency.orElseThrow();
        System.out.println("minFrequency:"+minFrequency);
        System.out.println("map.entrySet():"+map.entrySet());

        List<Integer> result = map.entrySet().stream()
            .filter(entry ->entry.getValue() == minFrequency)
                    .map(entry ->entry.getKey()).toList();
                //.map(Map.Entry::getKey).toList();
        System.out.println("Result:"+ result);
    }

    
}
