/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author pavankumarv
 *
 */
public class StreamTerminalOperations {

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
		
		System.out.println("match()");
		boolean matchedResult1 = memberNames.stream().anyMatch(name->name.startsWith("Z"));
		boolean matchedResult2 = memberNames.stream().anyMatch(name->name.startsWith("Y"));
		boolean matchedResult3 = memberNames.stream().allMatch(name->name.startsWith("Y"));
		
		System.out.println(matchedResult1);
		System.out.println(matchedResult2);
		System.out.println(matchedResult3);
		
		long count1 = memberNames.stream().filter(name->name.startsWith("A")).count();
		System.out.println(count1);
		
		
		Optional<String> reduced	=	memberNames.stream().reduce((s1,s2)->s1+"#"+s2);
		reduced.ifPresent(System.out::println);
		
		
		
		
		
	}

}
