package com.vmb.enterprise.datastructure.sorting;

public class MergeSortArgorithm {
	
		int givenArrLen;
		
		public static void main(String[] args) {
			int unsortedArray[]={33,12,54,2,81,7,93,3,66,11};
			MergeSortArgorithm msp=new MergeSortArgorithm();
			msp.givenArrLen=unsortedArray.length;
			msp.sort(unsortedArray);
		}
		
		
		public void sort(int array[]){
			
			int arrayLength	=	array.length/2;
			int leftIndex	=	0;
			int middleIndex	=	arrayLength/2;
			int rightIndex	=	arrayLength-1;
			
			
		//	int R[]	=	new Array
			
			for(int i=leftIndex;i<middleIndex;i++){
				
			}
			
			for(int j=middleIndex+1;j<rightIndex;j++){
				
			}
			
			
		}
		
		public void merge(int array[]){
			
		}


}
