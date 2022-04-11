package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map hashmap=new HashMap();
		Map weakhashmap=new WeakHashMap();
		
		String keyhashmap=new String("keyhashmap");
		String keyweakhashmap=new String("keyweakhashmap");
		
		hashmap.put(keyhashmap,"Pavan-hashmap");
		weakhashmap.put(keyweakhashmap, "Pavan-weakhashmap");

		System.out.println("Before: hash map value:"+hashmap.get("keyhashmap")+" and weak hash map value:"+weakhashmap.get("keyweakhashmap"));
		
		//System.gc();
		keyhashmap = null;
		keyweakhashmap = null;
		System.gc();
		System.out.println("After: hash map value:"+hashmap.get("keyhashmap")+" and weak hash map value:"+weakhashmap.get("keyweakhashmap"));
		
		//for ref http://www.concretepage.com/java/example_weakhashmap

	}

}
