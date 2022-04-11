package com.vmb.enterprise.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * http://java-interview-questions.com/core-java-example-programs/?_lbGate=468024
 */
public class HashSetToArrayTest {

	public static void main(String[] args) {

		Set<Integer> set	=	new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		// set to Array
		Object[] objarray	=	set.toArray();
		for(Object intvalue: objarray){
			System.out.println(intvalue);
			
		}
		System.out.println("====");
		
		// set to ArrayList ie .,  collections
		List<Integer> list	=	new ArrayList<Integer>();
		list.addAll(set);
		for(Integer integerValue: list){
			System.out.println(integerValue);
		}
		
		
	}

}
