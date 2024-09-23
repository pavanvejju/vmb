/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pavankumarv
 *
 */
public class StreamIterate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> memberNames = new ArrayList<String>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		
		Stream<Integer> streamIterated = Stream.iterate(2,n -> n + 1).limit(20);
		System.out.println(streamIterated.collect(Collectors.toList()));
		
		
		IntStream intStreamClosed = IntStream.rangeClosed(1, 3);
		System.out.println(intStreamClosed.sum());

		IntStream intStream = IntStream.range(1, 4);
		System.out.println(intStream.sum());


		
		
	}

}
