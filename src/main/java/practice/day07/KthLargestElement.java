package practice.day07;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class KthLargestElement {


   // Write a program to find the kth largest element in a list of integers using Java Stream API.
    public static  void main(String[] args)
    {

        List<Integer>  numbers = List.of(100, 121, 23,100, 45,23, 100,121,45,76,89,19);
        System.out.println("Numbers:"+numbers);
        int k=4;
      //  List<Integer> result = numbers.stream().distinct().sorted(Comparator.reverseOrder()).toList();
       Integer result  = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(k-1).findFirst().orElseThrow();
        System.out.println("result:"+result);
    }
}
