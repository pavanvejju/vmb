package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "apple");
        hashmap.put(12, "lemon");
        hashmap.put(3, "orange");
        hashmap.put(4, "banana");
        hashmap.put(10, "litchi");
        hashmap.put(6, "mango");
        hashmap.put(7, "papaya");

        System.out.println("" + hashmap.size());

        for (String Val : hashmap.values()) {
            System.out.println("Val  ===" + Val);
        }

        //Iterator iterator = hashmap.keySet().iterator();
        for (Map.Entry<Integer, String> integerStringEntry : hashmap.entrySet()) {
            //System.out.println(iterator.next());
            System.out.print("key is: " + ((Map.Entry<?, ?>) integerStringEntry).getKey() + " & Value is: " + ((Map.Entry<?, ?>) integerStringEntry).getValue());
        }
    }
}
