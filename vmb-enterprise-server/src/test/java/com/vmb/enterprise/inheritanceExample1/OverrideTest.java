package com.vmb.enterprise.inheritanceExample1;


//http://www.coderanch.com/t/512888/java/java/Ambiguous-method-overloading
public class OverrideTest {

	/**
	 * @param args
	 */
	public String display(String str){
		System.out.println("=======strmethod called");
		return str;
	}
	public String display(Long str){
		System.out.println("=======longmethod called");
		return "long";
	}
	public String display(Object ob){
		System.out.println("=======obj method called");
		
		return "pavan";
		
	}
	/*static public void display(Integer i)   {    
	    System.out.println("Integer");    
	}*/  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//According to the java specification
		//If more than one member method is both accessible and applicable to a method invocation ...
		//The Java programming language uses the rule that the most specific method is chosen.
		//Because String is a subclass of Object, the version with String is considered more specific. 

		OverrideTest test=new OverrideTest();
		
	//test.display(null);

	}
	

	

}
