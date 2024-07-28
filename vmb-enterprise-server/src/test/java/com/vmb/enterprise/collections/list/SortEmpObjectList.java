package com.vmb.enterprise.collections.list;

import com.vmb.enterprise.examples2.EmpNameComparator;
import com.vmb.enterprise.examples2.Employee;

import java.util.*;


public class SortEmpObjectList {

    /**
     * @author pavanvejju
     */
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "suresh", "Yenugula", "9966499808");
        Employee e2 = new Employee(10, "abcd", "Yenugula", "9966499808");
        Employee e3 = new Employee(30, "xfsere", "Yenugula", "9966499808");
        Employee e4 = new Employee(4, "jukjj", "Yenugula", "9966499808");
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.sort(new EmpNameComparator());
        System.out.println("After-----------");
        employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).forEach(System.out::println);
    }
}