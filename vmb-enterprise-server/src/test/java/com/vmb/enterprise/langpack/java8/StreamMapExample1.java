/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pavankumarv
 *
 */
public class StreamMapExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names	=	Arrays.asList("A","BN","cdfg");
		List<Integer> length1	=	names.stream().map(name-> name.length()).collect(Collectors.toList());
		System.out.println(length1);
		

	}

}
