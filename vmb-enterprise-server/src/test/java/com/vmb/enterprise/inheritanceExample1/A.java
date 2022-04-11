package com.vmb.enterprise.inheritanceExample1;

public class A extends B {

	public A(){
		System.out.println("A Class CNTR");
	}
	static {
		System.out.println("A Class static Block");
	}
	{
		System.out.println("A Class instance Block");
	}
	
	public static void staticmain(){
		System.out.println("A Class static main Method");
	}
	
	//@Override
	public void instancemain(){
		System.out.println("A Class instance main Method");
	}
	public void amethod() throws Exception{
		System.out.println("A Class a Method");
	}
}
