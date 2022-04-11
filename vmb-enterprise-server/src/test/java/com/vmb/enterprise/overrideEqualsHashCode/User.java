package com.vmb.enterprise.overrideEqualsHashCode;

public class User {

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
	/*default behaviour of equals() internally uses '=='
	 * which means it will check references.
	 * */
	@Override
	public boolean equals(Object o){
		
		if(o==null)	return false;
		if(o==this)	return true;
		if(getClass()!=o.getClass()) return false;
		if(! (o instanceof User))	return false;
		
		User u	=	(User)o;
		
		
		return this.getId()==u.getId() && this.getFirstName()==u.getFirstName() ;
	}
	
	@Override
	public int hashCode(){
		int hash	=	(int)this.id;
		return hash;
	}
	
}
