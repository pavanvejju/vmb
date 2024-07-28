package com.vmb.enterprise.collections.list;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Conversion of List to Set
 * */
public class ArrayListFrequency {

    public static void main(String... args) {

        List<Integer> list = List.of(1, 2, 3, 3, 4, 5, 6, 6, 7);
        System.out.println("ArrayList size==" + list.size());
        Set<Integer> set = new HashSet<>(list);
        System.out.println("set size==" + set.size());
        for (Integer t : set) {
            // frequency  means nothing but count
            System.out.println(t + ":" + Collections.frequency(list, t));
        }
        System.out.println("===============================================");
        // java 8
        set.forEach(element -> System.out.println(element + ":::" + Collections.frequency(list, element)));
    }
}