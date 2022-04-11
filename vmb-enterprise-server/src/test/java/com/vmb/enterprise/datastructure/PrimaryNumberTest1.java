package com.vmb.enterprise.datastructure;

/**
 * @author pavankumarv
 *
 */

public class PrimaryNumberTest1 {
	
	
	public static void main(String[] args) {
	
		int n=5;
		boolean isPrime	=	betterMethod(n);
		boolean isBestMethodPrime	=	bestMethod(n);
		if(isPrime) {
			System.out.println(n+" is a prime number");
		}if(isBestMethodPrime){
			System.out.println(n+" is a prime number in best method");
		}
		if(!isPrime ) {
			System.out.println(n+" is a not prime number");
		}
		if( !isBestMethodPrime) {
			System.out.println(n+" is a not prime number in best method");
		}
	}
	
	 private static boolean bestMethod(int n) {
		 boolean isPrime	=	true;
		 
		 System.out.println("O(√N) Solution : "+Math.sqrt(n));
		 
		 for(int i=2;i<=Math.sqrt(n);i++) {
			 if(n%i==0) {
				   isPrime = false;
	                break;
			 }
		 }
		 return isPrime;
	 }
	 
	 private static boolean betterMethod(int n){
	        boolean isPrime = true;
	        System.out.print("O(N/2) Solution : ");
	        for (int i = 2; i <=n/2 ; i++) {
	            if(n%i==0) {
	                isPrime = false;
	                break;
	            }
	        }
	        //Time Complexity: O(N/2) ~ O(N)
	        
	        return isPrime;
	    }
}
