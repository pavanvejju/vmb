package com.vmb.enterprise.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {

		Map m	=	new HashMap();
		m.put("s1",new String("PAVAN"));
		m.put("s2",new String("PAVAN"));
		m.put("s3", new Integer(1));
		m.put("s4", new Integer(1));
		System.out.println(m);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
