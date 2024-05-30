package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EqualsTest {

	public static void main(String[] args) {
		User u1	=	new User();
		User u2	=	new User();
		
		u1.setId(5);
		u1.setFirstName("vdv");
		u2.setId(5);
		u2.setFirstName("prasad");

		System.out.println(u1.equals(u2));
		
		
		Set<User> userset	=	new HashSet<User>();
		userset.add(u1);
		userset.add(u2);
		
		System.out.println(userset.size());
		Iterator<User> i = userset.iterator();
		while(i.hasNext()){
			User u=i.next();
			System.out.println(u.getFirstName());
		}
	}

}
