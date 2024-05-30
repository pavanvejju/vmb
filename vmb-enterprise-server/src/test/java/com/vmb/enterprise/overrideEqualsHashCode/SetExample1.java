package com.vmb.enterprise.overrideEqualsHashCode;

import java.util.HashSet;
import java.util.Set;

public class SetExample1 {
	
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
		SetExample1 se1	=	new SetExample1();
		se1.setId(1);
		se1.setFirstName("Pavan");
		se1.setLastName("Vejju");
		
		SetExample1 se2	=	new SetExample1();
		se2.setId(1);
		se2.setFirstName("Pavan");
		se2.setLastName("Vejju");
		
		SetExample1 se3	=	new SetExample1();
		se3.setId(1);
		se3.setFirstName("Pavan");
		se3.setLastName("Vejju");
		
		Set<SetExample1> s	=	new HashSet<SetExample1>();
		s.add(se1);
		s.add(se2);
		s.add(se3);
		System.out.println(s.size());
	}
	
	
    @Override
	public boolean equals(Object o){
		
		if(o==null)	return false;
		if(o==this)	return true;
		if(getClass()!=o.getClass()) return false;
		if(! (o instanceof SetExample1))	return false;
		
		SetExample1 se1	=	(SetExample1)o;
		System.out.println("equals>>"+(this.getId()==se1.getId()));
		return this.getId()==se1.getId();
	}
	
	@Override
	public int hashCode(){
		int hash	=	(int)this.id;
		System.out.println("hash>>"+hash);
		return hash;
	}

}
