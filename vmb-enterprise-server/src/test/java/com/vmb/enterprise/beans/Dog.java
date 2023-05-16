package com.vmb.enterprise.beans;

public class Dog {
  
	 String color;
	 
	public Dog(String c){
		 color=c;
	 }
	 
	 @Override
	public int hashCode() {
		return color.length();
	}
	 
	 @Override
	public String toString() {
		return color +" dog";
	}
	 
	 @Override
	public boolean equals(Object obj) {
		return ((Dog)obj).color== this.color;
	}
}




