package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectEqualsAndHashCodeTest {

	public static void main(String[] args) {
	
		Contact c1= new Contact(1, "James", "ram");
		Contact c2= new Contact(2, "John", "rahem");
		Contact c3	=	c1;
		Contact c4= new Contact(1, "James", "ram");
		
		// two objects created in memory 
		System.out.println("Are c1 and c2 are equal ?==>"+(c1==c2)); //false
		// there is only one obj created in the memory
		System.out.println("Are c1 and c3 are equal ?==>"+(c1==c3)); //true
		System.out.println("Are c1 and c4 are equal ?==>"+(c1==c4)); //false
		System.out.println("Are c1 and c2 are equal by equal()==>"+(c1.equals(c2)));
		System.out.println("Are c1 and c3 are equal by equal()==>"+(c1.equals(c3)));
		System.out.println("Are c1 and c4 are equal by equal()==>"+(c1.equals(c4)));
		
		//List Object
		List<Contact> contactList	=	new ArrayList<Contact>();
		contactList.add(c1);
		contactList.add(c2);
		/*if(contactList.contains(c1))
			System.out.println("yes");
		else
			System.out.println("no");*/
		 
		/*
		if(contactList.contains(c4))
			System.out.println("yes");
		else
			System.out.println("no");*/
		
		
		// Set object
		
		Set<Contact> contactSet	=	new HashSet<Contact>();
		contactSet.add(c1);
		contactSet.add(c2);
		/*if(contactSet.contains(c1))
			System.out.println("yes");
		else
			System.out.println("no");*/
		 
		
		if(contactSet.contains(c4))
			System.out.println("yes");
		else
			System.out.println("no");  // o/p is no, because hashset,hashmap,hashtable will play differently
		
		
		
	}

}

