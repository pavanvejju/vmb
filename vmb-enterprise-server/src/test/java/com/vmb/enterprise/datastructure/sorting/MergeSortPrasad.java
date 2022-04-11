package com.vmb.enterprise.datastructure.sorting;

import java.util.Arrays;

public class MergeSortPrasad {
	
	int givenArrLen=0;

	public void merge(int[] a, int b[],int[] ab){
		
		int c=0;
		int d=0,e=0;
		while(d<a.length && e<b.length){
			
		if(a[d]<=b[e]){
			ab[c]=a[d];
			d++;
		}
		else{
			ab[c]=b[e];
			e++;
		}
		
		c++;
		}
		
		while(d<a.length){
			ab[c]=a[d];
			d++;
			c++;
		}
		
		while(e<b.length){
			ab[c]=b[e];
			e++;
			c++;
		}
		
		System.out.println("Merged Array:" + Arrays.toString(ab));
	}
	
	public void mergeSort(int[] arr){
		
		int arrLen=arr.length;
		//int marr[];
		System.out.println(arrLen/2);
		int[] leftArr= new int[arrLen/2];
		int[] rightArr=new int[arr.length-arrLen/2];
		int li=0,ri=0;
		for(int x=0;x<arr.length;x++){
			if(x<arr.length/2){
				leftArr[li]=arr[x];
				li++;
			}
			else{
				rightArr[ri]=arr[x];
				ri++;
			}
		}
		
		System.out.println(Arrays.toString(leftArr));
		System.out.println(Arrays.toString(rightArr));
		if(leftArr.length>1)
		{mergeSort(leftArr);}
		
		if(rightArr.length>1)
		{mergeSort(rightArr);}
		
		if((leftArr.length+rightArr.length) <= givenArrLen ){
		merge(leftArr, rightArr,arr);
		}
		
	}
	public static void main(String[] args) {
		
		int unsortedArray[]={33,12,54,2,81,7,93,3,66,11};
		
		MergeSortPrasad msp=new MergeSortPrasad();
		msp.givenArrLen=unsortedArray.length;
		msp.mergeSort(unsortedArray);

	}

}
