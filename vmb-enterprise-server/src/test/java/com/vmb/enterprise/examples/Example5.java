package com.vmb.enterprise.examples;

public class Example5 {

	String name; 
	int age;
	
	public void incrementAge(){
		age++;
	}
	
	public static void main(String[] args) {
		Example5 e1	=	new Example5();
		Example5 e2	=	e1;
		e1.age	=	50;
		e1.incrementAge();
		System.out.println(e1.age+":::"+e2.age);
		e1=null;
		System.out.println(e2.age);

	}

}
