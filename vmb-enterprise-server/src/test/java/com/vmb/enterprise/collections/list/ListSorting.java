package com.vmb.enterprise.collections.list;

import java.util.ArrayList;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;


/**
 * list sorting with reverse order
 * */
public class ListSorting {

	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<>();
			arraylist.add("AA");
			arraylist.add("ZZ");
			arraylist.add("CC");
			arraylist.add("FF");

		/* Unsorted List: ArrayList content before sorting */
		System.out.println("Before Sorting:"+arraylist);

		//Collections.sort(arraylist);
		
		/* Sorting in descending order */
		arraylist.sort(reverseOrder());
		System.out.println("ArrayList in descending order:"+arraylist);
	}
}
