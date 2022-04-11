package com.vmb.enterprise.datastructure;

/**
 * @author pavankumarv
 *
 */

public class MatrixDiagonal2 {

	public static void main(String[] args) {
		
		int mat[][] = { 
							{ 1, 2, 3}, 
							{ 4, 5, 6}, 
							{ 7, 8, 9}
					  };
		
		
		printConsole(mat,3,3);
		
		
		diagonalOrder(mat,3,3);
		
		
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
	}
	
	public static int min(int a, int b) {
		
		return a<b? a:b;
	}
	
	public static int min(int a, int b, int c) {
		
		
		return min(min(a,b),c);
	}
	
	public static int max(int a, int b) {
		
		return a>b? a:b;
	}
	
	public static void upDiagonal(int matrix[][], int ROW, int i,int j, int k) {
		for ( ; i>=0 && j<ROW ; i--,j++ )
        {
            System.out.print(matrix[i][j] + " ");
            k++;
        }

        // Set i and j according to direction
        if (i < 0 && j<=ROW-1)
            i = 0;
        if (j == ROW)
        {
            i = i+2 ; j--;
        }
	}
	
	/*public static void downDiagonal(int matrix[][], int ROW, int i,int j, int k) {
		for ( ; j >= 0 && i<ROW ; i++ , j--)
        {
            System.out.print(matrix[i][j] + " ");
            k++;
        }

        // Set i and j according to direction
        if (j < 0 && i<=ROW-1)
            j = 0;
        if (i == ROW)
        {
            j = j + 2 ; i--;
        }
	}*/
	
	// The main function that prints given matrix in diagonal order
	public static void diagonalOrder(int matrix[][], int ROW, int COL) {

		System.out.print("\n Diagonal printing of matrix is \n");
		boolean isUp	=	true;
		int i = 0, j = 0 ;
		for(int k=0;k<(ROW*COL);) {
			
			if(isUp) {
				upDiagonal(matrix, ROW, i, j, k);
			}else {
				upDiagonal(matrix, ROW, j, i, k);
			}
			isUp = !isUp;
		}
		
		
	}
}
