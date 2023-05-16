package com.vmb.enterprise.service;

public interface ITest {
	
	 public default void  add(int a, int b)
	    {
	        System.out.print("Answer by Default method = ");
	        System.out.println(a + b);
	    }
	  
	    public static void mul(int a, int b)
	    {
	        System.out.print("Answer by Static method = ");
	        System.out.println(a * b);
	    }
	

}
