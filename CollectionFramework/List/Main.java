package CollectionFramework.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);
        integerList.add(50);

        System.out.println("Initial List: " + integerList);

        integerList.add(2, 25);
        System.out.println("After adding 25 at index 2: " + integerList);

        int elementAt3 = integerList.get(3);
        System.out.println("Element at index 3: " + elementAt3);

        integerList.set(4, 35);
        System.out.println("After setting index 4 to 35: " + integerList);

        integerList.remove(1);
        System.out.println("After removing element at index 1: " + integerList);

        integerList.remove(Integer.valueOf(25));
        System.out.println("After removing value 25: " + integerList);

        System.out.println("List contains 30? " + integerList.contains(30));

        System.out.println("Index of 50: " + integerList.indexOf(50));

        System.out.println("Iterating using for-each:");
        for (int num : integerList) {
            System.out.println(num);
        }

        System.out.println("Iterating using traditional for loop:");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("Index " + i + ": " + integerList.get(i));
        }

        System.out.println("Size of list: " + integerList.size());

        integerList.clear();
        System.out.println("After clearing: " + integerList);

        System.out.println("Is list empty? " + integerList.isEmpty());
    }
}
