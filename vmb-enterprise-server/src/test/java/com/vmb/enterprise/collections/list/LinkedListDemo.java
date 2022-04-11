package com.vmb.enterprise.collections.list;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * Adding elements to linked list and converted to set 
 * */
public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<String> ll=new LinkedList<String>();
			ll.add("F");
			ll.add("F");
			ll.add("B");
			ll.add("D");
			ll.add("E");
			ll.add("C");
			ll.addLast("Z");
			ll.addFirst("A");
			ll.add(1, "A2");
			System.out.println("list values----"+ll);
		HashSet<String> hs=new HashSet<String>(ll);
			System.out.println("hash set values----"+hs);
	}
}
