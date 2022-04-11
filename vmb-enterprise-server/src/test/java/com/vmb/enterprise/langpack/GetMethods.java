package com.vmb.enterprise.langpack;

import java.lang.reflect.Method;

public class GetMethods {

	    public void foo() { }

	    public int bar() { return 12; }

	    public String baz() { return ""; }

	    public static void main(String args[])
	    {
	        try {
	            Class c = GetMethods.class;
	            Method[] m = c.getDeclaredMethods();
	            for (int i = 0; i < m.length; i++)
	            System.out.println(m[i].toString());
	        } catch (Throwable e) {
	            System.err.println(e);
	        }
	    }


}
