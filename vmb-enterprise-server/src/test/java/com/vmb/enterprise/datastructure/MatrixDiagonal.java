package com.vmb.enterprise.datastructure;

/**
 * @author pavankumarv
 *
 */

public class MatrixDiagonal {

	public static void main(String[] args) {
		
		int mat[][] = { { 1, 0, 0 }, { 0, 5, 0 }, { 1, 0, 9 } };
		                	
		int flag	=	isDiagonal(mat,3,3);
		
		if(flag==1) {
			System.out.println("Its not a diagonal matrix");	
		}else {
			System.out.println("Its a diagonal matrix");
		}
	}
	
	public static int isDiagonal(int mat[][], int r, int c) {
		
		// for printing the matrix in console
		printConsole(mat,3,3);
		
		int flag=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(i==j) {
					if(mat[i][j]==0) {
						flag=1;
						break;
					}
				}else {
					if(mat[i][j]!=0) {
						flag=1;
						break;
					}
				}
				
			}
		}
		return flag;
	}
	
	public static void printConsole(int mat[][], int r, int c) {
		System.out.println("Given input is ");
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				// print matrix
				System.out.print(mat[i][j] + " ");
			}
			 System.out.print("\n");
		}
		 System.out.println("=============");
	}
	

}
