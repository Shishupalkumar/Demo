package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        map.put("Mango", 40);

        // Retrieving a value based on the key
        String key = "Banana";
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            System.out.println("The value for key \"" + key + "\" is: " + value);
        } else {
            System.out.println("The key \"" + key + "\" is not found in the map.");
        }

        // Iterating over the HashMap
        System.out.println("\nIterating over the HashMap:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Removing a key-value pair
        map.remove("Apple");
        System.out.println("\nAfter removing key \"Apple\":");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Checking if the map is empty
        if (map.isEmpty()) {
            System.out.println("\nThe HashMap is empty.");
        } else {
            System.out.println("\nThe HashMap is not empty.");
        }

        // Clearing the HashMap
        map.clear();
        System.out.println("\nAfter clearing the HashMap:");
        if (map.isEmpty()) {
            System.out.println("The HashMap is empty.");
        } else {
            System.out.println("The HashMap is not empty.");
        }
    }
}