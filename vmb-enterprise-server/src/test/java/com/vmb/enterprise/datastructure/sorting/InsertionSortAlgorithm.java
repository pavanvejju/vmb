package com.vmb.enterprise.datastructure.sorting;

import java.util.Arrays;

public class InsertionSortAlgorithm {
	
	 public static void insertionSort(int array[]) {  
        
		 int arrayLength = array.length;  
        for(int j=0; j<arrayLength; j++){
        	
        	int key	=	array[j];
        	int i=j-1;
        	while(i>-1 && array[i] >  key){
        		
        		array[i+1] = array[i];
        		i--;
        	}
        	array[i+1]	=	key;
        }
	 }
	

	public static void main(String[] args) {
		
		int unsortedArray[]={33,12,54,2,81,7,93,3,66,11,4};
		insertionSort(unsortedArray);
		System.out.println(Arrays.toString(unsortedArray));
	}

}
