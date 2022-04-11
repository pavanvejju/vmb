package com.vmb.enterprise.inheritanceExample1;

public class C {

	public C(){
		System.out.println("C Class CNTR");
	}
	static {
		System.out.println("C Class static Block");
	}
	{
		System.out.println("C Class instance Block");
	}
	public static void staticmain(){
		System.out.println("C Class static main Method");
	}
	
	public void instancemain() {
		System.out.println("C Class instance main Method");
	}
	
	public void cmethod(){
		System.out.println("C Class c Method");
	}
	/*public void bmethod(){
		System.out.println("C Class b Method");
	}*/
}
