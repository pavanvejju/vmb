package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Convertion of List to Set
 * */
public class ArrayListFrequency {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(7);
		
		System.out.println("ArrayList size=="+list.size());
		
		
		Set<Integer> set=new HashSet<Integer>();
		set.addAll(list);
		
		System.out.println("set size=="+set.size());
		
		for(Integer t:set){
			// frequency  means nothing but count
			System.out.println(t+":"+Collections.frequency(list, t));
		}
		System.out.println("===============================================");
	// java 8
		set.stream().forEach(i-> 
		{	
			System.out.println(i+":::"+Collections.frequency(list, i));
		});	
			
		
		
	}

}
