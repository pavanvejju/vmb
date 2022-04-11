package com.vmb.enterprise.datastructure.sorting;

public class BubbleSortAlgorithm {

	
	public long startTime;
	public long endTime;
	
	int[] theArray	=	{5,3,7,2,4,9,1,8};
	
	public static void main(String[] args) {

		BubbleSortAlgorithm bs	=	new BubbleSortAlgorithm();
		bs.bubbleSort();
	}
	
	public void bubbleSort(){
		startTime	=	System.currentTimeMillis();	
		System.out.println("Sort Start time in miliseconds: "+startTime);
		
		for(int i=0;i<theArray.length-2;i++){
			for(int j=0;j<theArray.length-1-i;j++){
				if(theArray[j]>theArray[j+1]){
					swapValues(j,j+1);
				}
			}
			System.out.println("###########################iteration  count="+i);
			for(int j=0;j<theArray.length;j++){
				System.out.println(theArray[j]);
			}
			
		}
		endTime	=	System.currentTimeMillis();
		
		System.out.println("Sort end time in miliseconds: "+endTime);
	}
	
	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}
