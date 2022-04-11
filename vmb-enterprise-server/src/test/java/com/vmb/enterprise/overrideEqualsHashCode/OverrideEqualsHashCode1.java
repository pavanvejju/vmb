package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.HashMap;

import com.vmb.enterprise.beans.Student;

public class OverrideEqualsHashCode1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<Object, Object> hm= new HashMap<Object, Object>();
		hm.put(new Student("Rohan"),"20");
		hm.put(new Student("Rohan"),"21");
		hm.put(new Student("Rohan"),"23");
		hm.put(new Student("Suresh"),"21");
		
		System.out.println("------------------");
		System.out.println("Hash Map =="+hm.get(new Student("Rohan")));
	}

}
