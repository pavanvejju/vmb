package com.vmb.enterprise.datastructure.sorting;

import java.util.Arrays;

public class SeletionSortAlgorithm {
	
	public void selectionSort(int arr[]){
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					swapValues(arr, i,j);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		SeletionSortAlgorithm ss=new SeletionSortAlgorithm();
		
		int unsortedArray[]={33,12,54,2,81,7,93,3,66,11};
		System.out.println("Unsorted Array:::"+Arrays.toString(unsortedArray));
		ss.selectionSort(unsortedArray);
		System.out.println("Sorted Array:::"+Arrays.toString(unsortedArray));
	}
	
	public void swapValues(int[] theArray, int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}
