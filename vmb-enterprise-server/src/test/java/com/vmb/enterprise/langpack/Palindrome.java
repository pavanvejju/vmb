package com.vmb.enterprise.langpack;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(Palindrome.isPalindrome("RAJAR"));
	}
	
	public static boolean isPalindrome(String str){
		
		boolean ispflag	=	false;
		
		String revStr	=	new StringBuilder(str).reverse().toString();
		
		if(revStr.equals(str)){
			ispflag=true;
		}
		
		return ispflag;
	}

}
