package com.vmb.enterprise.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Example10 {

	
	public static char findDuplicateMap(String s) {
	    char[] chars = s.toCharArray();
	    Map<Character, Integer> uniqueChars = new HashMap<Character, Integer> (chars.length);
	    for (int i = 0; i < chars.length; i++) {
	        Integer previousIndex = uniqueChars.put(chars[i], i);
	        if (previousIndex != null) {
	            return s.charAt(previousIndex);
	        }
	    }
	    return ' ';
	}
	
	public static char findDuplicateSet(String s) {
	    char[] chars = s.toCharArray();
	    Set<Character> uniqueChars = new HashSet<Character> (chars.length);
	    for (int i = 0; i < chars.length; i++) {
	        Boolean isValue = uniqueChars.add(chars[i]);
	        if (!isValue ) {
	            return s.charAt(i);
	        }
	    }
	    return ' ';
	}
	
	public static void main(String[] args) {
		
		System.out.println(Example10.findDuplicateMap("pavankumarvvvv"));
		
		//System.out.println(Example10.findDuplicateSet("hello"));

	}

}


