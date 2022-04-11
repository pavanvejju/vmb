package com.vmb.enterprise.examples;


public class Example1 {

	
	public void fun(int n){
		for(int i=0;i<=n;i++){
			fun(n-i);
		}
		System.out.println("weldone");
	}
	public static void main(String[] args) {
		Example1	ex1	=	new Example1();
		ex1.fun(10);

	}

}

// o/p: Exception in thread "main" java.lang.StackOverflowError