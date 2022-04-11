package com.vmb.enterprise.datastructure;

public class Search {

	
	static long startTime;
	static long endTime;
	private int arraySize;
	private int[] theArray;
	private int itemsInArray = 0;
	
	
	public static void main(String[] args) {
		Search s	=	new Search(10);
		s.generateRandomArray();
		//s.linearsearch(40);
		s.binarySearch(2);
	}
	
	/*
	 * O[1]
	 * */
	public void addItemsToArray(int newValue){
		startTime	=	System.currentTimeMillis();
		System.out.println("Linear Search Start time in miliseconds: "+ startTime);

		theArray[itemsInArray++]=newValue;
		
		endTime	=	System.currentTimeMillis();
		System.out.println("Linear Search end time in miliseconds: "+ endTime);
	}
	/*
	 * O[n]
	 * */
	public void linearsearch(int searchValue){
		startTime	=	System.currentTimeMillis();
		System.out.println("Linear Search Start time in miliseconds: "+ startTime);
		boolean valueInArray=false;
		for(int i=0;i<arraySize;i++){
			if(theArray[i]==searchValue){
				valueInArray = true;
				System.out.println(searchValue+ "array is present in current array");
				break;
			}
		}
		endTime	=	System.currentTimeMillis();
		System.out.println("Value Found: " + valueInArray);
		System.out.println("Linear Search end time in miliseconds: "+ endTime);
	}
	
	
	// O (log N) Occurs when the data being used is decreased
		// by roughly 50% each time through the algorithm. The
		// Binary search is a perfect example of this.

		// Pretty fast because the log N increases at a dramatically
		// slower rate as N increases

		// O (log N) algorithms are very efficient because increasing
		// the amount of data has little effect at some point early
		// on because the amount of data is halved on each run through

	
	public void binarySearch(int searchvalue){
		startTime	=	System.currentTimeMillis();
		System.out.println("Search Start time in miliseconds: "+ startTime);
		
		int array[] = {1,2,3,4,5,6,7,8,9,10};
		
		int lowIndex	= 0;
		int highIndex	=	array.length-1;
		int timesThrough = 0;
		
		while(lowIndex <= highIndex){
			int middleIndex	=	(lowIndex+highIndex)/2;
			
			if(array[middleIndex] > searchvalue){
				highIndex	=	middleIndex-1;
				
			}else if(array[middleIndex] < searchvalue){
				lowIndex	=	middleIndex+1;
			}else{
				System.out.println("\nFound a Match for " + searchvalue	+ " at Index " + middleIndex);
				lowIndex = highIndex + 1;
			}
			timesThrough++;
		}
		
		
		
		
		
		
		endTime	=	System.currentTimeMillis();
		System.out.println("Search end time in miliseconds: "+ endTime);
	}
	
	Search(int size) {

		arraySize = size;

		theArray = new int[size];

	}

	
	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = (int) (Math.random() * 1000) + 10;

		}

		itemsInArray = arraySize - 1;

	}
	
	
	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}


}
