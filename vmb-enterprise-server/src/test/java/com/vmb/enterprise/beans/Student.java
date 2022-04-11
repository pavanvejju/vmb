/**
 * 
 */
package com.vmb.enterprise.beans;

/**
 * @author pavankumarv
 *
 */
public class Student {
	
	private String sname;
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		
		this.sname=name;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		if(null==obj || this.getClass() != obj.getClass()){
			flag= false;
		}
		if(obj== this)
		{
			flag= true;
		}
		Student student=(Student)obj;

		if(this.sname!=null && sname.equals(student.getSname())){
			flag= true;
		}
		
		//System.out.println(this.sname!=null && sname.equals(student.getSname()));
		return flag;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hash =3;
		hash=7*hash+this.sname.hashCode();
		
		//System.out.println("hash  value"+hash);
		return hash;	
		}
	
}
