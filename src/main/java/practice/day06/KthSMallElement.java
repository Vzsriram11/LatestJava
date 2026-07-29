package practice.day06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class KthSMallElement {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 2,5);
        int k = 3; // Find the 3rd smallest element
        Optional<Integer> kthSmallest = numbers.stream().distinct().sorted().skip(k - 1).findFirst();
        System.out.println("The " + k + "th smallest element: " + (kthSmallest.isPresent() ? kthSmallest.get() : "N/A"));
    }
}
