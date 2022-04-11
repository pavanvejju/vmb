package com.vmb.enterprise.examples2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class IteratorEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("I");
		list.add("am");
		list.add("very");
		list.add("good");
		Enumeration<String> enumeration=Collections.enumeration(list);
		//Iterator<String> itr=list.iterator();
		
	/*	while (enumeration.hasMoreElements()) {
			list.remove(0);
			String string = (String) enumeration.nextElement();
			System.out.println(""+string);
			
		}
	*/	
		
		CopyOnWriteArrayList<String> cwa=new CopyOnWriteArrayList<String>();
		cwa.add("I");
		cwa.add("am");
		cwa.add("very");
		cwa.add("good");
		Iterator<String> itr=cwa.iterator();
		
		while (itr.hasNext()) {
			cwa.remove(0);
			System.out.println(""+itr.next());
			
		}

	}

}
