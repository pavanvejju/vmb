package com.vmb.enterprise.overrideEqualsHashCode;

public class Contact {

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
	
	public Contact (int id,String firstName,String lastName){
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	
	/*default behaviour of equals() internally uses '=='
	 * which means it will check references.
	 * */
	/*@Override
	public boolean equals(Object o){
		
		return super.equals(o);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}*/
	
	
	
	
	@Override
	public boolean equals(Object o){
		if(o==null) return false;
		Contact c	=	(Contact)o;
		return (c.getId()==this.getId()) && (c.getFirstName()==this.getFirstName());
	}
	
	@Override
	public int hashCode(){
		return 12*id + firstName.hashCode()+lastName.hashCode();
	}
}
