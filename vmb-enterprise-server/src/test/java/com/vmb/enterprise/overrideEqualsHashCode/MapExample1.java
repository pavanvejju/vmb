package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.HashMap;
import java.util.Map;

public class MapExample1 {
	
	private Integer id;
	private String firstName;
	private String lastName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public static void main(String[] args) {
		MapExample1 se1	=	new MapExample1();
		se1.setId(1);
		se1.setFirstName("Pavan");
		se1.setLastName("Vejju");
		
		MapExample1 se2	=	new MapExample1();
		se2.setId(1);
		se2.setFirstName("Pavan");
		se2.setLastName("Vejju");
		
		Map m	=	new HashMap();
		m.put(se1, "Map1");
		m.put(se2, "Map2");
		System.out.println(m.size());
		
	}
	
	@Override
	public boolean equals(Object o){
		System.out.println("equal");
		return true;
	}
	
	@Override
	public int hashCode(){
		System.out.println("hashcode");
		return 1;
	}

}
