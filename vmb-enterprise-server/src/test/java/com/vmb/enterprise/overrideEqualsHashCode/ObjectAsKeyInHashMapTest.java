package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.HashMap;
import java.util.Map;

public class ObjectAsKeyInHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		User u1	=	new User();
		User u2	=	new User();
		u1.setId(5);
		u2.setId(5);
		
		Map<Object,String>	m	=	new HashMap<Object,String>();
					m.put(u1, "user obj1");
					m.put(u2, "user obj2");
					
					System.out.println(m.size());
	}

}
