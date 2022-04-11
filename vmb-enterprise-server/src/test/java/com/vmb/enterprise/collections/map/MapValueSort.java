package com.vmb.enterprise.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapValueSort {

	public static void main(String[] args) {

		Map<String,Object> m 	=	new HashMap<String,Object>();
		m.put("1", "PAVAN");
		m.put("2", 1);
		m.put("2", 5);
		m.put(null, 4);
		m.put(null, 5); // accepting null keys
		
		
		

		for (Map.Entry<String, Object> entry : m.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    
		    if(entry.getValue()!=null) {
		    	
		    }
		}
		
	}

}

class myComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
