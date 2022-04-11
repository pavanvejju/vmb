package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamBuilders1 {

	public static void main(String[] args) {
		
		 List<String> memberNames = new ArrayList<>();
         memberNames.add("Amitabh");
         memberNames.add("Shekhar");
         memberNames.add("Aman");
         memberNames.add("Rahul");
         memberNames.add("Shahrukh");
         memberNames.add("Salman");
         memberNames.add("Yana");
         memberNames.add("Lokesh");
         

		/*Stream<Integer> streams1	=	Stream.of(1,2,3,4,5);
		streams1.forEach(p -> System.out.print(p));
		
		System.out.println("======================================");
		
		Stream<Integer> streams2	=	Stream.of(new Integer[]{1,2,3,4,5,6,7});
		streams2.forEach(p -> System.out.print(p));
		System.out.print("======================================");
		
		Stream<Date> streams3	=	Stream.generate(() -> {return new Date();});
		streams3.forEach(p -> System.out.print(p));
		
		IntStream intStream	=	"12345_abcdefg".chars();
		intStream.forEach(p -> System.out.print(p));
		
		System.out.println("======================================");
		
		 Stream<String> stream4 = Stream.of("A$B$C".split("\\$"));
	      stream4.forEach(p -> System.out.print(p));
	     System.out.println("======================================");
			
	       
	        List<Integer> list = new ArrayList<Integer>();
	         for(int i = 1; i< 10; i++){
	             list.add(i);
	         }
	         Stream<Integer> stream5 = list.stream();
	         
	         Integer[] evenNumbersArr =stream5.filter(i->i%2==0).toArray(Integer[] :: new);
	         System.out.print(evenNumbersArr);
		 
	         
	         List<String> memberNames = new ArrayList<>();
	         memberNames.add("Amitabh");
	         memberNames.add("Shekhar");
	         memberNames.add("Aman");
	         memberNames.add("Rahul");
	         memberNames.add("Shahrukh");
	         memberNames.add("Salman");
	         memberNames.add("Yana");
	         memberNames.add("Lokesh");
	         
	         Stream<String> stream6 = memberNames.stream();
	         stream6.sorted().filter(str -> str.startsWith("A"))
	         		.map(String :: toUpperCase)
	         		.forEach(System.out::println);
	      */
		
		
         Optional<String> reduced	=memberNames.stream().sorted().reduce( (s1,s2)	-> s1+","+s2);
         
         reduced.ifPresent(System.out::println);
         
         boolean matched	=	memberNames.stream().anyMatch(s->s.startsWith("A"));
		System.out.println(matched);
		
		 Optional<String> getFirst	=	memberNames.stream().sorted().findFirst();
			System.out.println(getFirst);
		
	}

}
