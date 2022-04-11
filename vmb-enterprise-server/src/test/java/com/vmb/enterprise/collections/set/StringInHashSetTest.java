package com.vmb.enterprise.collections.set;

import java.util.HashSet;
import java.util.Set;

public class StringInHashSetTest {

	public static void main(String[] args) {
		String s1="PAVAN";
		String s2="PAVAN";
		String s3=new String("PAVAN");
		Set<String> s	=	new HashSet<String>();
		s.add(s1);
		s.add(s2);
		s.add(s3);
		System.out.println(s);
		
		// need to test with employee object
	}

}
