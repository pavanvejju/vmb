package com.vmb.enterprise.examples;

 public class Example4A  extends Example4B{
	
	 @Override
	public void met1(int i){
		 super.met1(i);
		 System.out.println("Child::"+i);
	}
	
	public static void main(String[] args) {
		Example4A p	=	new Example4A();
		p.met1(10);
	}
}
