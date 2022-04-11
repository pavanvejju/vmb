package com.vmb.enterprise.langpack.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamRangeReduceExample {

	public static void main(String[] args) {
		
		String[] strarray	=	{ "this", "is", "a", "sentence" };
		
		System.out.println(Arrays.stream(strarray).reduce(">>>", (str1,str2)->str1+" "+str2));
		
		System.out.println( IntStream.rangeClosed(2, 4).reduce((num1, num2)-> num1*num2));
	//	System.out.println( IntStream.rangeClosed(2, 4).boxed().map(num1 ->num1*2).collect(Collectors.toList()));
		
		 int[] array = {23,43,56,97,32};
   	  Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
   	  Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
   	  
   	  
	}

}
