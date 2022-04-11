package com.vmb.enterprise.collections.map;
 
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.vmb.enterprise.beans.Dog;

 
public class TestHashMap {
 
  public static void main(String[] args) {
	  
	  Dog d1=new Dog("red");
	  Dog d2=new Dog("black");
	  Dog d3=new Dog("white");
	  Dog d4=new Dog("white");
	  
	  LinkedHashMap<Object, Integer> lhm=new LinkedHashMap<Object, Integer>();
	  lhm.put(d1,50);
	  lhm.put(d2,20);
	  lhm.put(d3,30);
	  lhm.put(d4,40);
	 // System.out.println(""+lhm.entrySet());
	  
	  for(Entry<Object, Integer> entry: lhm.entrySet()){
		  System.out.println(entry.getKey() + " - " + entry.getValue());
	  }
	  
	  
  }
}