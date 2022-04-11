package com.vmb.enterprise.langpack;

public class ParentChild{
	public static void main() {
		Parent p	=	new Child();
		p.display();
		//Compile time error ie., The method displayName() is undefined of type Parent
		//p.displayName();
	}
}

class Parent	{  
	public void display(){
		System.out.println("Display() in Parent");
	}  
}

class Child extends Parent{  
	
	@Override
	public void display(){
		System.out.println("Display() in Child");
	}
	public void displayName(){
		System.out.println("DisplayName() in Child");
	}
}
