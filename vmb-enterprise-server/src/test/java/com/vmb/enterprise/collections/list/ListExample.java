package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExample {

	/**
	 * @author pavanvejju
	 */
	public static void main(String[] args) {
		
		
	ArrayList<String> alist=new ArrayList<String>();
	alist.add("Pavan");
	alist.add(null);
	alist.add("Pavan1");
	alist.add("Pavan2");
	alist.add("PAVAN3");

	ArrayList<Integer> intList=new ArrayList<Integer>();
	intList.add(1);
	intList.add(2);
	intList.add(3);

	ArrayList<Object> mergeList=new ArrayList<Object>();
	mergeList.addAll(alist);
	mergeList.addAll(intList);
	
	Iterator<Object> it=mergeList.listIterator();
	System.out.println(":::"+mergeList);
	try {
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(">>>"+string.toString());
			//alist.remove(0);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	for(Object obj: mergeList){
		System.out.println(obj.toString());
	}
 }
}
