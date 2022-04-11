package com.vmb.enterprise.inheritanceExample1;

public class InheritanceOrder {

	public static void main(String[] args) {
		
		C obj =	new B();
		System.out.println("----- before instance--------------");
		obj.instancemain();
		System.out.println("---------before c----------");
		obj.cmethod();
		System.out.println("---------c method----------");
		// will get compile time error if we try to call b class methods
		//obj.bmethod();
		
		C.staticmain();
		
	}
}