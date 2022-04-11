package com.vmb.enterprise.beans;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.multi.MultiViewportUI;

public class Employee {
	
	private String empId;
	
	private String empName;
	
	public Employee(String empId,String empName){
		this.empId=empId;
		this.empName=empName;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hash =3;
		hash=7*hash+this.empId.hashCode();
		hash=7*hash+this.empName.hashCode();
		
		return hash;
	}
	

	public boolean equals(Object obj){
		//null instance object always returns null
		System.out.println("--Entered equals method---");
		boolean result =false;
		if(!(obj instanceof Employee)){
			result= false;
		}else {
			Employee employee=(Employee)obj;
			if(this.empId==employee.getEmpId() && this.empName== employee.getEmpName()){
				result= true;
			}
		}
		
		return result;
		
	}

	/**
	 * @param argsx
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee employee1=new Employee("111", "suresh");
		Employee employee2=new Employee("111", "suresh");

		Employee employee3=new Employee("222", "kishore");
		
		/*System.out.println(" employee1  and employee2===>"+employee1.equals(employee2));

		System.out.println(" employee1  and employee3===>"+employee1.equals(employee3));
		System.out.println(""+employee1);*/
		
		Map m = new HashMap();
	    m.put(employee1,"SureshYenugula");
	    m.put(employee2,"SureshY");
	    m.put(employee3,"kishore");
	    m.put(null, "vdv");
	    m.put(null, "dvd");
	    m.put(null, null);
	    System.out.println( "FInal valueeeeee  "+m.values());



	}
	
	
	
	
	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
