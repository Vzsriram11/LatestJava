package practice.day05;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};    //o/p: [24,12,8,6]
       // int[] nums = {-1,1,0,-3,3};   //Output:[0,0,9,0,0]
        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));

     }

    public  static int[] productExceptSelf (int[] nums)
    {
        if(nums == null || nums.length ==0)
            return new int[0];

       // int[] left = new int[nums.length];
        //int[] right  = new int[nums.length];
        int[] result = new int[nums.length];

        //left[0] =1;
        result[0] =1;
        for (int i = 1; i < nums.length; i++) {
              //  left[i]= nums[i-1] * left[i-1];
            result[i]= nums[i-1] * result[i-1];

        }
      //  System.out.println("Left:"+ Arrays.toString(result));
        //build right array
        //right[nums.length - 1] = 1;
      /*  for (int i = nums.length-2; i >= 0; i--) {
                right[i]= nums[i+1] * right[i+1];

        }*/
        int suffix =1;
          for (int i = nums.length-1; i >= 0; i--) {
                result[i]= suffix * result[i];
                suffix = suffix * nums[i];
              //System.out.println("suffix:" + suffix + " result[i]:"+result[i]);

        }

      /*  for (int i=0; i<nums.length;i++)
        {
            result[i]= left[i] * right[i];
        }*/

return  result;
    }
}
