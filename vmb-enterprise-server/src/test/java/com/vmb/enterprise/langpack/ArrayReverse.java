package com.vmb.enterprise.langpack;

public class ArrayReverse {

	public static void main(String[] args) {

		int [] revarr	=	ArrayReverse.reverse();
		
		for(int i=0;i<revarr.length;i++){
			System.out.println("rev::"+revarr[i]);	
		}
	}
	
	public static int[] reverse(){
		
		int[] arr	=	{1,2,3,4,5};
		
		int temp;
		for(int i=0;i<arr.length/2;i++){
				temp	=	arr[i];
				arr[i]	=	arr[arr.length-1-i];
				arr[arr.length-1-i]=temp;	
		}
		
		return arr;
	}

	
	
}
