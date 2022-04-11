package com.vmb.enterprise.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pavankumarv
 *
 */

public class MatrixDuplicateNumbers {
	
	
	

	public static void main(String[] args) {
		
		 int mat[][] =  {{ 1, 2, 3, 20}, {5, 6, 20, 25},{5, 6, 20, 25}};
		                	
		 unique(mat,3,4);
			
	}
	
	public static void unique(int mat[][], int r, int c) {

		int uniqueArray[]	=	new int[r*c];
		Set<Integer> s	=	new HashSet<Integer>();
		int t=0;
		for(int i = 0; i<r;i++) {
			for(int j=0;j<c;j++) {
				//System.out.println("r::"+i+"::c::"+j);
				//System.out.println("mat::"+mat[i][j]);
				int value	=	mat[i][j];
				if(! Arrays.stream(uniqueArray).anyMatch(x -> x	==	 value)) {
					uniqueArray[t]	=	value;
					t++;
				}
				
			}
		}
		
		for(int x=0;x<uniqueArray.length;x++) {
			System.out.println(uniqueArray[x]);
		}
		
	}
	

}
