package practice.day03;


import java.util.HashMap;
import java.util.Map;

/*Input:
s = "anagram"
t = "nagaram"

Output:
        true*/
public class checkAnagram
{
    public static void main(String args[])
    {
            String s= "anagram";
            String t = "anagram";

            boolean result  = checkAnagram.checkIfAnagram(s,t);
            if(result) {
                System.out.println("S and T are anagram");
            }
            else {
                System.out.println("S and T are not anagram");
            }

    }

    public  static boolean checkIfAnagram (String s, String t)
    {
        //validation
        if(s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() != t.length())
        {
            return false;
        }

        Map<Character,Integer> hm = new HashMap<>();
        //Iterate the string S and store each character as the key and the frequency as the value.
        for (int i = 0; i < s.length(); i++)
        {

            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) + 1);
            //System.out.println("s.charat[i]:"+s.charAt(i));
           // System.out.println("hm.get[i]:"+hm.get(s.charAt(i)));

        }
        //Now we have the hashmap filled with each letter from string s and the frequency as the value.

        //Iterate the string 't'
        for (int i = 0; i < t.length(); i++)
        {
            int count = hm.getOrDefault(t.charAt(i), 0);

            if (count == 0) {
                return false;
            }

            hm.put(t.charAt(i), count - 1);

        }


        for ( int count: hm.keySet())
        {
            System.out.println("keys:"+count);
        }

        for ( int count: hm.values())
        {
            if(count !=0)
            {
                return  false;
            }
        }
return  true;
    }
}
