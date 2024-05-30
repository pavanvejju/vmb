package com.vmb.enterprise.langpack;

public class ParentChild1{
	public static void main() {
		Parent1 p	=	new Child1();
		p.display();
		//wheather Parent is an interface or class, ll get compiletime error saying the method xx is undefined type <Parent>
		//p.displayName();
		}
	}
interface Parent1	{  
	public void display();
}

class Child1 implements Parent1{  
	
	@Override
	public void display(){
		System.out.println("Display() in Child");
	}
	public void displayName(){
		System.out.println("DisplayName() in Child");
	}
}
