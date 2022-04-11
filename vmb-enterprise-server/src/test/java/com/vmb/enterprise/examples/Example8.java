package com.vmb.enterprise.examples;

import java.util.Random;

/*
 * Write a method to take arguments as integer. Method should generate a random alphanumeric string of a character.
 * */
public class Example8 {

	public static String generateAlphaNumeric(int length){
		String alphanumeric	=	"1234567890abcdefgh";
		int n	=	alphanumeric.length();
		
		String result = "";
		Random r = new Random(); 
		for(int i=0;i<length;i++){
			result = result + alphanumeric.charAt(r.nextInt(n)); 
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(Example8.generateAlphaNumeric(5));
		
	}

}
