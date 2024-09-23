/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;

/**
 * @author pavankumarv
 *
 */
public class ArrayMergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ArrayList<String> alist=new ArrayList<String>();
		alist.add("Pavan");
		alist.add(null);
		alist.add("Pavan1");
		alist.add("Pavan4");
		alist.add("PAVAN3");

		ArrayList<Integer> intList=new ArrayList<Integer>();
		intList.add(1);
		intList.add(4);
		intList.add(3);

		ArrayList<Object> mergeList=new ArrayList<Object>();
		mergeList.addAll(alist);
		mergeList.addAll(intList);
		
		
		/*intList
			.stream()
			.filter(nameObj -> nameObj!=0)
			.map(Integer::intValue)
			.sorted()
			.forEach(System.out::println);*/
		
		mergeList
		.stream()
		.filter(nameObj ->nameObj!=null && nameObj.toString().length()>0)
		.map(Object::toString)
		.sorted()
		.forEach(System.out::println);
		
		Integer abc	=	intList
		.stream().reduce(1000, (x,y)->x+y);
		
		System.out.println("abc::"+abc);
	}
}