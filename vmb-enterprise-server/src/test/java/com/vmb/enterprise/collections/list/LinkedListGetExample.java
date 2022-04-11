package com.vmb.enterprise.collections.list;

import java.util.LinkedList;



/**
 * @author pavankumarv
 * How to get the first and the last element of a linked list ?
 *
 */

public class LinkedListGetExample {

	public static void main(String[] args) {

		LinkedList<String> ll	=	new LinkedList<String>();
		ll.add("100");
		ll.add("200");
		ll.add("300");
		ll.add("400");
		ll.add("500");
		ll.add("600");
		
		 System.out.println("First element of LinkedList is : " + ll.getFirst());
	      System.out.println("Last element of LinkedList is : " + ll.getLast());
	      System.out.println("beforeAdding elements"+ll);
	      
	      ll.addFirst("90");
	      ll.addLast("690");
	    
	      System.out.println("Number of items in the list: " + ll.size());
	      System.out.println(""+ll);
	
	}

}
