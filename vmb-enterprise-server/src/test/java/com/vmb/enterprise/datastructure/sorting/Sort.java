package com.vmb.enterprise.datastructure.sorting;

import com.vmb.enterprise.util.CustomUtil;

public class Sort {

	public static void main(String[] args) {
		
		int[] list	=	{5,4,7,3,2,9,1};
		//Sort.bubbleSort(list);
		//Sort.selectionSort(list);
		//Sort.quickSort(list);
		for(int i	=	0;i<list.length;i++){
			System.out.println("sorted array::"+list[i]);
		}

	}

	public static void selectionSort(int[] array){

		int minIndex;
		boolean minIndexFound=false;
		int firstLoop	=	0;
		
		for(int i=0; i<array.length-1;i++){
			minIndex=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[i]){
					minIndex=j;
					minIndexFound= true;
				}
			}
			if(minIndexFound){
				CustomUtil.swapValues(i, minIndex, array);
			}
			minIndexFound=false;
			System.out.println("firstLoop::"+firstLoop+"============================");
			firstLoop++;
		}
	}
	
	
	public static void bubbleSort(int[] array){
		
		int firstLoop	=	0;
		Boolean isSorted	=	true;
		for(int i=0; i<array.length-1;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j] > array[j+1]){
					CustomUtil.swapValues(j, j+1, array);
					isSorted=false;
				}
			}
			firstLoop++;
			System.out.println("firstLoop::"+firstLoop+"============================");
			if(isSorted){
				System.out.println("sorted list ");
				break;
			}
		}
	}
}
