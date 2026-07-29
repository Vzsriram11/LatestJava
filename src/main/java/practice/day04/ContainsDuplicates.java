package practice.day04;


import java.util.HashSet;
import java.util.Set;

/*Input:
        [1,2,3,1]

Output:
        true*/
public class ContainsDuplicates {
public static void main(String[] args)
{
    int[] numbers = {1,1,1,3,3,4,3,2,4,2};
    boolean result= false;
    result = checkIfDuplicates(numbers);
    if(result)
        System.out.println("The array contains duplicate elements");
    else
        System.out.println("The array doesn't contain duplicate elements");
}

public  static boolean checkIfDuplicates(int[] numbers)
{
    if(numbers == null || numbers.length ==0)
        return  false;
    //create a HashSet to store each number that we encounter/process
    //Set doesn't allow duplicates. so if set.add returns false, means tht number already exists in the set,
    //meaning we have found our duplicate

    Set<Integer> set = new HashSet<>();
    for (int number: numbers)
    {
        if(!set.add(number)) {
            return true;
        }
    }
    return  false;
}
}
