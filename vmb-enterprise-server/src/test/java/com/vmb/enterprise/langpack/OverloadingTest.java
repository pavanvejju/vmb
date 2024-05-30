package com.vmb.enterprise.langpack;

public class OverloadingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public void save(){
		System.out.println("save without parameter");
	}
	
	public void save(String abc){
		System.out.println("save with parameter str");
	}
	
	public void save(int abc){
		System.out.println("save with parameter int");
	}
	
	public void save(int abc, String str){
		System.out.println("save with parameter int,string");
	}

	public void save(String abc, int i){
		System.out.println("save with parameter string,int");
	}

	
//same parameters with same data type not valid
 /*public String save(String abc, int i){
		System.out.println("save with parameter string,int with return type change");
		return null;
	}
	*/
}
