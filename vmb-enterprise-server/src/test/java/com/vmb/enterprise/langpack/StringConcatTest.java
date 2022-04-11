package com.vmb.enterprise.langpack;

public class StringConcatTest {

	public static void main(String[] args) {

		String s="Hello";
		s.concat("vejju");
		System.out.println("0::"+s);
		System.out.println("1::"+s.concat("Kumar"));
		String s1	=	s.concat("world");
		System.out.println("2::"+s1);
		String s2	=	"Pavan";
		System.out.println("3::"+s.concat(s2));  
	}

}
