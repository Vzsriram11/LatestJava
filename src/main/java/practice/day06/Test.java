package practice.day06;

import com.sun.security.jgss.GSSUtil;
import org.dto.Employees;

import java.util.*;

public class Test {
public static void main (String[] args)

{

    List<String> list = new ArrayList<>();

    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");

    System.out.println("List:" + list);

    for (String s: list)
    {
        if(s.equals("B"))
        {
           //list.remove(s);
        }
    }

    for (String s : list) {
        if (s.equals("B")) {
           // list.remove(s);
        }
    }
    System.out.println("After modifying List:" + list);

    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {
        if (iterator.next().equals("C")) {
            iterator.remove();
        }
    }
    System.out.println("After modifying List again1:" + list);

    list.removeIf( str -> str.equals("A"));

    System.out.println("After modifying List again2:" + list);

    Map<String, Employees> map = new HashMap<>();
    Employees e1 = new Employees("Sri", "IT", 240000.00);
    Employees e2 = new Employees("Sri", "IT", 240000.00);
    map.put("Sri", e1);
    map.put("Sri",e1);
    System.out.println(map.size());
    System.out.println(map.toString());
    System.out.println("map.get(\"Sri\"):"+ map.get("Sri"));
    System.out.println(map.size());
  //  System.out.println("map.remove(\"Sri\"):"+ map.remove("Sri"));
   // System.out.println(map.size());
    Map<String, Integer> mapFruitCount = new HashMap<>();
    List<String> fruits = new ArrayList<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Apple");
    fruits.add("Apple");
    fruits.add("Apple");

    for (String word : fruits) {
        if (mapFruitCount.containsKey(word)) {
            mapFruitCount.put(word, mapFruitCount.get(word) + 1);
        } else {
            mapFruitCount.put(word, 1);
        }
    }
    System.out.println("mapFruitCount:"+mapFruitCount);
    mapFruitCount = new HashMap<>();
    fruits.add("Banana");
    for (String fruit : fruits)
    {
        mapFruitCount.merge(fruit,1,Integer::max);
    }

    System.out.println("mapFruitCount:"+mapFruitCount);
}
}
