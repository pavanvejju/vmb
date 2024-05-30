package com.vmb.enterprise.langpack;

public class NoClassDefFoundTest {

	public static void main(String[] args) {

		NoClassTest test	=	new NoClassTest();
		test.greeting();
	}

}

class NoClassTest{
	public void greeting() {
		System.out.println("Hello");
	}
}
