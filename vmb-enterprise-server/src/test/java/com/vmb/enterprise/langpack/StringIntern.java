package com.vmb.enterprise.langpack;

public class StringIntern {

	public static void main(String[] args) {
		
		String s1="pavan";
		String s2 = new String("pavan");
		System.out.println("s1==s2:"+s1==s2);
		
		String s3=s2.intern();
		System.out.println(s3);
		System.out.println(s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode()); 
	}

}
