package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Hashtable;

/*
 * Hashmap allows one null key and any number of null values, 
 * while Hashtable do not allow null keys and null values in the HashTable object.
 */
public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("test", "pavan");
		map.put("","");
		map.put(null, null);
		map.put(null, null);
		map.put("aaa", null);
		map.put("aaa", "ttt");
		System.out.println("Map size======"+map);
		
		
		Hashtable<String, String> hashtable=new Hashtable<String, String>();
		hashtable.put("test", "xxx");
		hashtable.put("test", "yy");
		hashtable.put("test", "pavan");
		hashtable.put("","");
		//hashtable.put(null, null);NPE
		//hashtable.put(null, "ttt");//NPE
		//hashtable.put("xxx", null);NPE
		// In hashtable, both keys and values need not be null,// Make sure the value is not null
		
		
		hashtable.put("xxx", "ttt");
		
		
		System.out.println("hashtable size======"+hashtable);

	}

}
