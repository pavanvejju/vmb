package com.vmb.enterprise.examples;

import java.util.HashMap;
import java.util.Map;



 class Example11 {

	
	public static void main(String[] args) {
		
		Map<Object, Integer> m	=	new HashMap<Object, Integer>();
		m.put("af", 1);
		
		m.put(1, 1);
		System.out.println(m);
	}
	
	
}


