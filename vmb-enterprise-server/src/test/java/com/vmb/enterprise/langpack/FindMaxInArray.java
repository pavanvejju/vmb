package com.vmb.enterprise.langpack;

import java.util.Arrays;

public class FindMaxInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[]={5,3,10,6,17,8};
		int maxIndex = 0;
		int biggestnumber=0;
		for (int index = 1; index < array.length; index++){
			System.out.println("maxx Index==="+array[maxIndex]);
			System.out.println("array[index]===>>>"+array[index]);
			System.out.println("-----------------");
			if (array[maxIndex] < array[index]){
				maxIndex = index;
				 biggestnumber = array[maxIndex];
			}
		}
		System.out.println("The largest number you entered was: " + biggestnumber);
		
		System.out.println(">>>"+Arrays.stream(array).reduce(Math::max).getAsInt());
		
	}
}
