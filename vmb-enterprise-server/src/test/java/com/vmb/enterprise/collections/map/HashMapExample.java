package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
	
	
	public static void main(String[] args) {
		
		 HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	       hashmap.put(1, "apple" );
	       hashmap.put(12, "lemon" );
	       hashmap.put(3, "orange" );
	       hashmap.put(4, "banana" );
	       hashmap.put(10, "litchi" );
	       hashmap.put(6, "mango" );
	       hashmap.put(7, "papaya" );
	       
	       System.out.println(""+hashmap.size());
	       
	       
	       for (String Val : hashmap.values()) {
	    	   System.out.println("Val  ==="+Val);
			
		}
	       
	       Iterator iterator = hashmap.entrySet().iterator();
	       //Iterator iterator = hashmap.keySet().iterator();
	       while(iterator.hasNext()) {
	    	   //System.out.println(iterator.next());
	          Map.Entry  mentry = (Map.Entry)iterator.next();
	          System.out.print("key is: "+ mentry.getKey() + " & Value is: "+mentry.getValue());
	          //System.out.println((String)mentry.getValue());
	       }

	}

}
