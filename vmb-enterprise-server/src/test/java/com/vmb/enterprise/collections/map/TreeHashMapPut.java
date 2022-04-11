package com.vmb.enterprise.collections.map;

import java.util.Map;
import java.util.TreeMap;


/*
 * underlying data structure is Hashtable + LinkedList
 * */
public class TreeHashMapPut {

	public static void main(String[] args) {
		Map<String,Object> m 	=	new TreeMap<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		//m.put(null, 5); // will not accept null keys
		System.out.println(m.put("2", 1));
		System.out.println(m.put("1", 1));  // previous key-value will return
		m.put("3", "hello");
		m.put("5", "hello");
		m.put("4", "hello"); // insertion order is preserved
		System.out.println(m);
		
		Map<String,Object> m2 	=	new TreeMap<String,Object>();
		m2.put(null, "Hello");
		// m2.put(null, "Hello"); // only 1 time, we can declare null, ie., empty treemap
		//m2.put("3","dsfs");
		System.out.println(m2);
		
	}
}
