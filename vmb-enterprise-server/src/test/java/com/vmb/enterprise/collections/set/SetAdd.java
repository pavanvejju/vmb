package com.vmb.enterprise.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetAdd {

	public static void main(String[] args) {
		Set<Object> s	=	new HashSet<Object>();
		s.add("Pavan");
		s.add(1);  // hetrogenous objects allowed
		s.add(null); 
		s.add(null); // null insertion is possible
		System.out.println(s.add("Kumar")); // boolean return type ie., true 
		System.out.println(s.add("Pavan")); // boolean return type ie., false, because already value exists in set 
		
		System.out.println(s);
	}

}
