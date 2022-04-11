package com.vmb.enterprise.collections.set;

import java.util.Set;
import java.util.TreeSet;

/*
 * sorting, hetrogenous objects not allowed	, null insert is not possible
 * 
 * For the Empty TreeSet,  as the first element null insertion is possible. 
 * But after inserting null, if we are trying to insert anyother element we will get NullPointerException.
 * */
public class TreeSetAdd {

	public static void main(String[] args) {
		Set<Object> s	=	new TreeSet<Object>();
		s.add("Bando");
		s.add("Pavan");
		s.add("Amala");
		//s.add(1);  // hetrogenous objects not allowed
		//s.add(null); // null insertion is not possible
		System.out.println(s.add("Kumar")); // boolean return type ie., true 
		System.out.println(s.add("Pavan")); // boolean return type ie., false, because already value exists in set 
		
		System.out.println(s);
		
		
		//=========
		
		Set<Object> s1	=	new TreeSet<Object>();
		s1.add(null);
		System.out.println("Set2: "+s1);
	}

}
