package com.vmb.enterprise.examples2;

import java.util.Comparator;


public class EmpNameComparator implements Comparator<Employee>{

	public int compare(Employee arg0, Employee arg1) {
		
		if(arg0.getFirstName().compareTo(arg1.getFirstName())>0){
			return -1;	
		}
		else if(arg0.getFirstName().compareTo(arg1.getFirstName())<0){
			return 1;	
		}else{	
			return 0;	
		}
		
	}


}
