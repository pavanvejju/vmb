package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<String> duplicateList=new ArrayList<>();
		duplicateList.add("I");
		duplicateList.add("am");
		duplicateList.add("very");
		duplicateList.add("good");
		duplicateList.add("good");
		duplicateList.add("very");
		
		System.out.println("Remove duplicates");
		duplicateList.stream().distinct().forEach(System.out::println);
		System.out.println("Remove duplicates");
		new HashSet<>(duplicateList).forEach(i->System.out.println(i+"=="+Collections.frequency(duplicateList, i)));
		
		
System.out.println("Above output is from java8");
		//Converting ArrayList to HashSet to remove duplicates
		HashSet<String> hashSet=new HashSet<>(duplicateList);
		System.out.println("duplicateList  size========"+duplicateList.size());
		//Creating Arraylist without duplicate values
		List<String> listWithOutDuplicates=new ArrayList<>(hashSet);
		System.out.println("listWithOutDuplicates  size==========="+listWithOutDuplicates.size());
		
		for(String str:duplicateList){
			System.out.println(str+"----:"+Collections.frequency(duplicateList, str));
		}
		
		for(String str1:duplicateList)  
        {  
            System.out.println(str1);  
        }  
        ArrayList<String> al2 = new ArrayList<>();
        for(String str2:duplicateList)  
        {  
            if(!al2.equals(duplicateList))          
            {  
                al2.add("al2:::::"+str2);  
            }  
        }  
        System.out.println(al2); 
	}

}
