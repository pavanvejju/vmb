package com.vmb.enterprise.examples2;



public class Employee{
	
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	//private Date bithDate;
	
	private String mobileNumber;
	
	public Employee(int employeeId,String firstName,String lastName,String mobileNumber){
		this.employeeId=employeeId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.mobileNumber=mobileNumber;
	}
	

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the bithDate
	 */
	/*public Date getBithDate() {
		return bithDate;
	}

	*//**
	 * @param bithDate the bithDate to set
	 *//*
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
*/
	


	
//	public int compareTo(Employee employee) {
		// TODO Auto-generated method stub
		
		/*String x=employee.getFirstName();
		System.out.println("in Employee this.employeeId=="+this.employeeId);
		System.out.println("in Employee employee.getEmployeeId=="+employee.getEmployeeId());
		int val=this.employeeId-employee.getEmployeeId();
		System.out.println("returned value=="+val);
		//assending order
		return this.firstName-employee.getFirstName();
		//decendeing order
		//return x-this.firstName;
*/
		//postivie value(1) : This particular object is greater than the object which we are  comparing against
		//zero value(0) : This particular object is equal to  the object which we are  comparing against
		//nagative value(-1) : This particular object is less than the object which we are  comparing against
		
	//	return employee.getFirstName().compareTo(this.firstName);
	//return this.firstName.compareTo(employee.getFirstName());
	//}


	
	
	
	
	

}
