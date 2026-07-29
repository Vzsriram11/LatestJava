package practice.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static  void main (String[] args)
    {
        int[] [] intervalArray = { {1,3},{8,10},{2,6},{15,18} };

        int [][] result = mergeInterval(intervalArray);
        System.out.println("Result:"+ Arrays.deepToString(result));
    }

    public static int [][] mergeInterval (int [][] intervalArray)
    {
        if (intervalArray == null || intervalArray.length ==0)
            return  new int[0][];
        Arrays.sort(intervalArray, Comparator.comparing(row -> row[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervalArray[0];
        System.out.println("Current:"+Arrays.toString(current));

        for (int i=1 ; i < intervalArray.length; i++)
        {
            int[] next = intervalArray[i];
            //nextStart <= currentEnd
            System.out.println("NNext"+Arrays.toString(next));
            if(next[0] <= current[1])  // overlap
            {
                current[1]= Math.max( current[1],next[1]);
            }else
            {
                result.add(current); // add current to result since no overlap
                current= next;
                System.out.println("New Current:"+Arrays.toString(current));
            }

        }
        result.add(current);  // add the last current to the results
        System.out.println("Result:" + Arrays.deepToString(result.toArray()));
        return result.toArray(new int[result.size()] []);
    }
}
