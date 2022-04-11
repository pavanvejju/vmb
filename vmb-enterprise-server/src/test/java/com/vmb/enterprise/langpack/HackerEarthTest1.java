package com.vmb.enterprise.langpack;

import java.util.Arrays;
import java.util.function.Predicate;

public class HackerEarthTest1 {

	
	public static void main(String[] args) {
	String[] stringArray	=	{"11","345","4444","55","4567","4554","4664"};
	//Stream<String> streamString = Stream.of("11","345","4444","55","4567");
	
	Predicate<String> predicate	=	str->(str.length()%2==0 && isPallandrom(str) && isGivenStrMatch(str));

	Arrays.asList(stringArray).stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	
	public static Boolean isPallandrom(String str) {
		if(str==null || (str!=null && str.isEmpty())) {
			return false;	
		}
		StringBuffer sb	=	new StringBuffer(str.toLowerCase());
		String revString	=	sb.reverse().toString();
		if(revString.equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}
	
	public static Boolean isGivenStrMatch(String str) {
		
		if(str==null || (str!=null && str.isEmpty())) {
			return false;	
		}
		
		String replacedStr	=	str.replaceAll("[4,5]", "");
		if(replacedStr==null || (replacedStr!=null && replacedStr.isEmpty())) {
			return true;	
		}
		
		return false;
	}
	
	
}
