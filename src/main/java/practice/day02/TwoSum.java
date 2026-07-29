package practice.day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String args[])
    {
        int[] nums = {7,2,15,11};
        Arrays.sort(nums);
        System.out.println("Nums:"+ Arrays.toString(nums));

        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums,18);
        System.out.println("Result:"+ Arrays.toString(result));
    }
    //TIme complexity will be O(n)
    //space complexity will be O(n)
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        int complement = 0;
        Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++)
            {
                //calculate the complement by
                complement = target - nums[i];
                if(map.containsKey(complement))
                {
                    result[0] = map.get(complement);
                    result[1] = i;
                    return new int[]{map.get(complement), i};
                }
                else {
                    map.put(nums[i],i);
                }
            }

        return  result;
    }
}
