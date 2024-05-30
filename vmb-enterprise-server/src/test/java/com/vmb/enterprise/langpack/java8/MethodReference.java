package com.vmb.enterprise.langpack.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MethodReference {

	public static void main(String[] args) {

		List<Integer> integerList	=	Arrays.asList(1,512,433,5);
		Optional<Integer> max	=	 integerList.stream().reduce(Math::max);
		max.ifPresent(System.out::println);
		
		IntStream.range(1, 100).boxed().reduce(Math::max).ifPresent(System.out::println);
		
		System.out.println(String.join("/", "a","b"));
		
		
		 Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
		 List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com",
                 "cat@google.com", "david@example.com");

	}

}
