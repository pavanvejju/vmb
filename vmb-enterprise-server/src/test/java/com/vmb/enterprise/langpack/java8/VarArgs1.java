package com.vmb.enterprise.langpack.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class VarArgs1 {

	public static void main(String[] args) {

		List<String> l1	=	Arrays.asList("A","B");
		List<String> l2	=	Arrays.asList("C","D");
		List<String> l3	=	Arrays.asList("E","F");
		Set<String> s3	=	new HashSet<>(l3);
		
		m1(null,l1);	
		m1(null,l1,l2);	
		m1(s3,l1,l2);
		
		Collections.unmodifiableList(l1);
		
		String[] array = {"a", "b", "c", "d", "e"};
		Stream<String> stream2 = Stream.of(array);
	    stream2.forEach(x -> System.out.println(x));
		
	}
	
	/**
	 * @SafeVarargs
	 * upto 1.8v, Expect private methods, we can declare all methods. i.e constructors, static, final
	 * From 1.9v, Private methods also applicable
	 * */
	@SafeVarargs
	public static void m1(Set<String> s,List<String> ... l){ 
		for(List<String> l1:l){
			l1.stream().forEach(System.out::println);
			System.out.println("===========");
		}
		
		if(s!=null){
			s.stream().forEach(System.out::println);	
		}
		
	}
}
