package com.vmb.enterprise.examples;

public class Example6 {

	String name; 
	int age;
	
	private static void modifyEmp(Example6 e){
		e.age += 1;
	}
	
	private static void update(int x){
		x=x+10;
	}
	
	public static void main(String[] args) {
	
		int x=100;
		System.out.println("initial x:"+x);//100
		update(x);
		System.out.println("After update x:"+x);//100
		Example6 e1	=	new Example6();
		e1.age=25;
		System.out.println("Initial Age:"+e1.age);//25
		modifyEmp(e1);
		System.out.println("After Update Age:"+e1.age);//26
		
		
		
	}

}
