package com.vmb.enterprise.inheritanceExample1;


public class B extends C{

	public B(){
		System.out.println("B Class CNTR");
	}
	static {
		System.out.println("B Class static Block");
	}
	{
		System.out.println("B Class instance Block");
	}
	public static  void staticmain(){
		System.out.println("B Class static main Method");
	}
	
	//only unchecked exceptions need to throw because in parent class we didn't provide the exception
	// The access level cannot be more restrictive than the overridden method's access level. 
	//@Override
	public void instancemain(){
		System.out.println("B Class instance main Method");
		
	}
	
	protected void bmethod() throws Exception{
		System.out.println("B Class b Method");
	}

	
	
}
