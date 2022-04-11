package com.vmb.enterprise.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPut {

	public static void main(String[] args) {
		Map<String,Object> m 	=	new ConcurrentHashMap<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		//m.put(null, 5); // will not accept null keys
		System.out.println(m.put("2", 1));
		System.out.println(m.put("1", 1));  // previous key-value will return
		System.out.println(m);
	}
}
