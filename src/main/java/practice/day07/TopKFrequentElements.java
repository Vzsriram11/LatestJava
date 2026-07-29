package practice.day07;


//Given an integer array nums and an integer k, return the k most frequent elements.

//nums = [1,1,1,2,2,3]
//k = 2

import java.util.*;

//Output: [1,2]
/*
At this point, the algorithm is complete.

If I asked you in an interview, I'd expect you to summarize it like this:

Traverse the array and build a HashMap<Integer, Integer> of frequencies. O(n)
Create a min-heap of Map.Entry<Integer, Integer> ordered by frequency.
Iterate over the map entries:
Add each entry to the heap.
If the heap size exceeds k, remove the smallest frequency.
The heap now contains the k most frequent elements.
Extract the keys from the heap into the result array.

Overall complexity:

Building the map: O(n)
Heap operations: O(m log k), where m is the number of distinct elements
Overall: O(n + m log k)

This is actually better than sorting all distinct elements (O(m log m)) when k is much smaller than m.
        */
public class TopKFrequentElements {


    public  static void main(String[] args)
    {
        int[] numbers = {1,1,1,2,2,3};
        int k=2;
        System.out.println(Arrays.toString(numbers));
        int[] result = getTopKFrequentElements(numbers,k);
        System.out.println("Result:" +Arrays.toString(result));


    }

    public  static  int[] getTopKFrequentElements (int[] numbers, int k)
    {
        int[] result= new int[k];
     if(numbers == null || numbers.length==0) {
         return new int[0];
     }

        //create a Hashmap to store each number as the key and the frequency of each number as it's value
        Map<Integer,Integer> integerHashMap = new HashMap<>();

        for (int number : numbers) {
            integerHashMap.put(number, integerHashMap.getOrDefault(number, 0) + 1);
        }
        System.out.println("integerHashMap:"+integerHashMap);
        //integerHashMap= Arrays.stream(numbers).collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        System.out.println("Priority Queue:"+pq);
        int index =0;



        for(Map.Entry<Integer,Integer> entry: integerHashMap.entrySet())
        {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            pq.offer(entry);
            if( pq.size() >k)
            {
                System.out.println("pq size >2 removing the smallest element:"+  pq.poll());
            }

        }
        System.out.println("Priority Queue after iteration:"+pq);

        while(!pq.isEmpty())
        {
            result[index++]= pq.poll().getKey();
        }
/*        Iterator<Map.Entry<Integer, Integer>> iter = pq.iterator();
        int j=0;
        List<Integer> resultList = new ArrayList<>();
        while(iter.hasNext())
        {
            resultList.add(iter.next().getKey());
            j++;
            System.out.println("forming result array:"+ resultList);
        }*/
        //return  resultList.stream().mapToInt(Integer::intValue).toArray();
        return  result;
    }
}
