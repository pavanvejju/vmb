package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapPut {

	public static void main(String[] args) {
		Map<String,Object> m 	=	new HashMap<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		m.put(null, 4);
		m.put(null, 5); // accepting null keys
		
		System.out.println(m.put("2", 1));
		System.out.println(m.put("1", 1));  // previous key-value will return
		System.out.println(m);

		HashMap<String, Integer> map = new HashMap<>();
		map.put("CS",8);
		map.computeIfAbsent("CA", key -> 10);
		map.computeIfPresent("CS", (k,v) -> v);
		System.out.print("map::"+map);
	}
}
