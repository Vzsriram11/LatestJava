package practice.day02;

import java.util.*;

public class TwoSumAttempt2 {

    public static  void main(String[] args)
    {
        //source array with numbers
        int[] nums = {2,7,11,15};
        //target sum
        int target = 9;
        TwoSumAttempt2 twoSumAttempt2 = new TwoSumAttempt2();
        int[] result = twoSumAttempt2.twoSum(nums,target);
        System.out.println("The result indices are:"+ Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target) {
       // int[] result = new int[2];
        //List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (nums == null)
        {
            return new int[0];
        }

        //Iterate the array
        for ( int i=0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
            //calculate complement based on the target value
            int complement = target - nums[i];
            System.out.println("Complement:" + complement);
            if (map.containsKey(complement))
            {
               // result[0]= map.get(complement);
              //  result[1]= i;
              //  System.out.println("result:" + Arrays.toString(result));
                return  new int[] {map.get(complement),i};
            }else
            {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No solution exists");
    }
}
