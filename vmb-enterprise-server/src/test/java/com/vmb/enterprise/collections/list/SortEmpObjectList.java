package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vmb.enterprise.examples2.EmpNameComparator;
import com.vmb.enterprise.examples2.Employee;


public class SortEmpObjectList {

	/**
	 * @author pavanvejju
	 */
	public static void main(String[] args) {
		
		List<Employee> employeeList=new ArrayList<Employee>();
		
		Employee e1		=	new Employee(1, "suresh", "Yenugula","9966499808");
		Employee e2		=	new Employee(10, "abcd", "Yenugula","9966499808");
		Employee e3		=	new Employee(30, "xfsere", "Yenugula","9966499808");
		Employee e4		=	new Employee(4, "jukjj", "Yenugula","9966499808");
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
      
    
      
      Collections.sort(employeeList, new EmpNameComparator());
    System.out.println("After-----------");
    for(Employee emp:employeeList)
    {
    	System.out.println(""+emp.getFirstName());
    }
      
      
      
	}
}
