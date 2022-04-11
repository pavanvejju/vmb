package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityMapDemo {

	public static void main(String[] args) {
		Map identityMap = new IdentityHashMap();
			identityMap.put("a", 1);
			identityMap.put(new String("a"), 2);
			identityMap.put("a", 3);
		
		Map hashMap = new HashMap();
			hashMap.put("a", 1);
			hashMap.put(new String("a"), 2);
			hashMap.put("a", 3);

			System.out.println(" identity hash map val "+identityMap);
			System.out.println("  hash map val "+hashMap);

	}
}
