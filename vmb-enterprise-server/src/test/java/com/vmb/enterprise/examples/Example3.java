package com.vmb.enterprise.examples;

public class Example3 {

	public static void main(String[] args) {
		
		int a=10;
		int b=20;
		
		if(a++>10 || ++b>20){
			System.out.println("a="+a);
			System.out.println("b="+b);
		}
		if(a++>11 && ++b>21){
			System.out.println("a=="+a);
			System.out.println("b=="+b);
		}

	}

}
