package com.vmb.enterprise.exceptions;

import java.io.IOException;

class Simple{  
	void m(){  
		try {
			throw new java.io.IOException("device error");
		} catch (IOException e) {
			e.printStackTrace();
		} //checked exception  
	}  
	void n(){  
		m();  
	}  
	void p(){  
	   try{  
	    m();  
	    throw new java.io.IOException("m() error");
	   }catch(Exception e){System.out.println("exception handeled");}  
	}  
  public static void main(String args[]){
	  Simple obj=new Simple();  
	  obj.p();  
	  System.out.println("normal flow");  
  }  
}  

//ref
//http`://www.c4learn.com/java/java-exception-propagation/