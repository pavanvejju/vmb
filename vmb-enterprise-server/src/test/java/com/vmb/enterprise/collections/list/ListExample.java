package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	while (it.hasNext()) {
		String string = (String) it.next();
		System.out.println(">>>"+string.toString());
		//alist.remove(0);
	}
	
	for(Object obj: mergeList){
		System.out.println(obj.toString());
	}
 }
}
