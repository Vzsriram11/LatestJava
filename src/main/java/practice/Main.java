package practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static  void main (String[] args) {

        //1. Write a program to find the sum of all elements in a list using Java Stream API

        List<Integer> nums = List.of(1, -3, 5, 6, 2, -4);
        long sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum:" + sum);

        //2. Given a list of integers, write a program to find and print the maximum element using Java Stream API

        int max = nums.stream().mapToInt(Integer::intValue).max().orElseThrow();
        System.out.println("Max:" + max);


        List<Integer> numbers = Arrays.asList(2, 4, 8, 6, 10, 45000);
        int max2 = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
        System.out.println("Max element: " + max2);

        //3. Write a program to filter out all the even numbers from a list using Java Stream API
        List<Integer> even = nums.stream().filter(num -> num % 2 == 0).toList();
        System.out.println("Even:" + even);

        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
        // Char searchChar ='a';
        List<String> output = strings.stream().filter(str -> str.contains("a")).toList();
        System.out.println("output:" + output);
        long aCount = strings.stream().filter(str -> str.contains("a")).count();
        System.out.println("Number of strings with 'a':" + aCount);

        // List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");

        List<String> upper = strings.stream().map(String::toUpperCase).toList();
        System.out.println("Upper:" + upper);

        //8. Given a list of strings, write a program to concatenate all the strings using Java Stream API.

        String joined = String.join("", strings);
        System.out.println("concat string:" + joined);
        String concatenatedString = strings.stream()
                .collect(Collectors.joining());
        System.out.println("Concatenated string: " + concatenatedString);

        String s1 = "Java";

        String s2 = new String("Java");

        System.out.println(s2);
        System.out.println(s1);
        System.out.println(s1 == s2);


        Supplier<UUID> uuidSupplier =
                UUID::randomUUID;

        System.out.println("uuidsupplier:" + uuidSupplier.get());

        Supplier<LocalDateTime> now =
                LocalDateTime::now;

        System.out.println("now:" + now.get());

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        int sum1 = numbers2.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum:" + sum1);
        int max3 = numbers2.stream().mapToInt(Integer::intValue).max().orElseThrow();
        System.out.println("max:" + max3);
        List<String> strings2 = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");
        long count = strings2.stream().filter(s -> s.contains("a")).count();
        System.out.println("Count:" + count);

        String shortestString = strings2.stream().min(Comparator.comparingInt(String::length)).orElseThrow();
        System.out.println("shortest:" + shortestString);
        List<Integer> squared = numbers2.stream().map(n -> n * n).toList();
        System.out.println("squared:" + squared);
        //numbers2.stream().ma

        List<String> fruits = Arrays.asList("Apple", "Banana", "Kiwi", "Strawberry", "pear");
        String target = "Banana";
        boolean result = fruits.stream().anyMatch(s -> s.equals(target));
        System.out.println("List contains string:"+result);
        int minLength = 5;
       List<String> longStrings = fruits.stream().filter( s -> s.length() > 5).toList();
        System.out.println("Strings with length greater than " + minLength + ": " + longStrings);

        List<Integer> nums4 = List.of(2,4,6);
        System.out.println("any match even: "+ nums4.stream().anyMatch(n -> n%2 ==0));
        System.out.println("all match even: "+ nums4.stream().allMatch(n -> n%2 ==0));
        System.out.println("none odd: "+ nums4.stream().noneMatch(n -> n%2 !=0));

        List<String> words = List.of("Java", "Apple","Spring", "Kafka", "Docker", "Alice");
        boolean test = words.stream().map(String::toLowerCase).anyMatch(word -> word.contains("k"));
        System.out.println("Test:"+test);
        boolean test2 = words.stream().allMatch(word -> word.length() >3);
        System.out.println("Does all have length 3:"+ test2);
        String test3= words.stream().filter( word ->word.toUpperCase().startsWith("A")).findAny().orElseThrow();
        System.out.println("test3:"+test3);


    }
}
