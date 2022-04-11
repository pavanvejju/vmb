package com.vmb.enterprise.collections.map;

import java.util.Hashtable;
import java.util.Map;

public class HashtablePut {

	public static void main(String[] args) {
		Map<String,Object> m 	=	new Hashtable<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		//m.put("d", null); // wil not accept null keys || null values
		//m.put(null, 1); // wil not accept null keys || null values
		System.out.println(m.put("2", 1));
		System.out.println(m.put("1", 1));  // previous key-value will return
		System.out.println(m);
	}

}
