package com.vmb.enterprise.collections.list;


import java.util.ArrayList;

public class ArrayListExample {
	   public static void main(String args[]) {
	      /*Creation of ArrayList: I'm going to add String elements, so I made it of generic as string type */
		  ArrayList<String> obj = new ArrayList<String>();

		  /*This is how elements should be added to the array list*/
		  obj.add("Ajeet");
		  obj.add("Harry");
		  obj.add("Chaitanya");
		  obj.add("Steve");
		  obj.add("Anuj");

		  /* Displaying array list elements */
		  System.out.println("Currently the array list has following elements:"+obj);

		  /*Add element at the given index*/
		  obj.add(0, "Rahul");
		  obj.add(1, "Justin");

		  System.out.println("Added 0th, 1st index , now updated array list is:"+obj);

		  /*Remove elements from array list based on index*/
		  obj.remove(1);
		  
		  /*Remove elements from array list based on names*/
		  obj.remove("Chaitanya"); 
		  obj.remove("Harry");

		  System.out.println("Removed few elements based on names and index, now updated array list is:"+obj);
	   }
	}