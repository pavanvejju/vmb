package com.vmb.enterprise.datastructure;

/**
 * @author pavankumarv
 *
 */

public class MatrixDiagonal1 {

	public static void main(String[] args) {
		
		int mat[][] = { 
							{ 1, 2, 3, 4 }, 
							{ 5, 6, 7, 8 }, 
							{ 9, 10, 11, 12 },
							{ 13, 14, 15, 16 },
							{ 17, 18, 19, 20 }  
					  };
		
		
		printConsole(mat,5,4);
		
		
		diagonalOrder(mat,5,4);
		
		
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
	
	public static int min(int a, int b) {
		
		return a<b? a:b;
	}
	
	public static int min(int a, int b, int c) {
		
		
		return min(min(a,b),c);
	}
	
	public static int max(int a, int b) {
		
		return a>b? a:b;
	}
	
	// The main function that prints given
	// matrix in diagonal order
	public static void diagonalOrder(int matrix[][], int ROW, int COL) {

		
		System.out.print("\nDiagonal printing of matrix is \n");
		// There will be ROW+COL-1 lines in the output
		for (int line = 1; line <= (ROW + COL - 1); line++) {

		// Get column index of the first element in this
		// line of output.The index is 0 for first ROW
		// lines and line - ROW for remaining lines
		int start_col = max(0, line - ROW);
		//System.out.println("start_col::"+start_col);
		// Get count of elements in this line. The count
		// of elements is equal to minimum of line number,
		// COL-start_col and ROW 
		int count = min(line, (COL - start_col), ROW);
		
		//System.out.println("count::"+count);

		// Print elements of this line 
		for (int j = 0; j < count; j++) {
			int rowIndex	=	 min(ROW, line) - j - 1 ;
			//System.out.println("rowIndex::"+rowIndex);
			int colIndex	=	start_col + j;
			//System.out.println("colIndex::"+colIndex);
			
			System.out.print(matrix[rowIndex] [colIndex] + " ");
		}
		// Print elements of next diagonal on next line
		System.out.println();
		}
	}
}
