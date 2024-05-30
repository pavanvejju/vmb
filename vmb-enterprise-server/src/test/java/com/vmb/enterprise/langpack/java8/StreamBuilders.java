/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pavankumarv
 *
 */
public class StreamBuilders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("1) Using Stream.of(val1, val2, val3�.)");
		Stream<Integer> stream1	=	Stream.of(1,2,3,11,5,6,7,8,9);
		stream1.sorted().forEach(i->System.out.println(i));
		
		
		System.out.println("2) Using Stream.of(arrayOfElements)");
		Stream<Integer> stream2	=	Stream.of(new Integer[] {13,2,3,11,5,6,7,8,9});
		stream2.sorted().forEach(i->System.out.println(i));
		
		System.out.println("3) Using someList.stream()");
		List<Integer> list1	=		Arrays.asList(1,3,6,2,8,13,45,21);
		Stream<Integer> stream3	=	list1.stream();
		stream3.sorted().forEach(i->System.out.println(i));

		System.out.println("4) Using Stream.generate() or Stream.iterate() functions");
		
	/*	Stream<Date> streamDate	=	Stream.generate(() -> {return new Date();});
					 streamDate.forEach(d->System.out.println(d));
					 */
		System.out.println("5A) Using String chars");
		
		  IntStream intStream = "12345_abcdefg".chars();
		  intStream.forEach(System.out::println);
		  
		  System.out.println("5B) Using String tokens");
			
		  Stream<String> stream = Stream.of("A$D$C".split("\\$"));
	        //stream.sorted().forEach(p -> System.out.println(p));
	        stream.sorted().forEach(System.out::println);
	        
	}

}
