package com.vmb.enterprise.datastructure.sorting;

public class BubbleSortNLargest {

	public static void main(String[] args) {

		int array[] =	{7,3,5,2,8,4};
		int temp;
		int nlargest=4;
		
		for(int i =0;i<nlargest;i++) {
			
			for (int j=0;j<array.length-1-i;j++) {
			
			if(array[j] > array[j+1]) {
				
				temp = array[j];  
				array[j] = array[j+1];  
				array[j+1] = temp; 
				
			}
			}
		}
		//System.out.println(Arrays.toString(array));
		System.out.println(array[array.length-nlargest]);

	}

}
