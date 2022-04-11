package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author pavankumarv
 * finding
*/
public class streamFilterExample {

	public static void main(String[] args) {

		List<String> arrayList	=	new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("A");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		arrayList.add("C");
		
		
		/*System.out.println("=======Remove Duplicate Elements=======");
		arrayList.stream().
		filter(a -> Collections.frequency(arrayList, a)==1).collect(Collectors.toSet())
		.forEach(System.out :: println);
		
		System.out.println("=======Find Duplicate Elements=======");
		arrayList.stream().
		filter(a -> Collections.frequency(arrayList, a)>1).collect(Collectors.toSet())
		.forEach(System.out :: println);*/
		
		System.out.println("=======Find Duplicate Elements count=======");
		arrayList.stream().
		filter(a -> Collections.frequency(arrayList, a)>1).collect(Collectors.toList())
		.forEach(System.out :: println);
		
		
		
		
	}

}
