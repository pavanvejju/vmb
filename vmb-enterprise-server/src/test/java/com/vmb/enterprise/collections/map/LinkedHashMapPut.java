package com.vmb.enterprise.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;


/*
 * underlying data structure is Hashtable + LinkedList
 * */
public class LinkedHashMapPut {

	public static void main(String[] args) {
		Map<String,Object> m 	=	new LinkedHashMap<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		m.put(null, 5); // will accept null keys
		System.out.println(m.put("2", 1));
		System.out.println(m.put("1", 1));  // previous key-value will return
		m.put("3", "hello");
		m.put("4", "hello");
		m.put("5", "hello"); // insertion order is preserved
		System.out.println(m);
	}
}
