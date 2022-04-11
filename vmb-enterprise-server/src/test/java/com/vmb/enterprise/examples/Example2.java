package com.vmb.enterprise.examples;

class Parent1{ 
	
	public void met1(int i){
		System.out.println("Base::"+i);
	}
}

 public class Example2  extends Parent1{
	
	public void met1(int i){
		 super.met1(i);
		 System.out.println("Child::"+i);
	}
	
	public static void main(String[] args) {
		Example2 p	=	new Example2();
		p.met1(10);
	}
}
