package com.vmb.enterprise.langpack.PolymorphismTest;

public class CurrentAccount extends Account {
	public void withdraw(){
		System.out.println("CurrentAccount withdraw");
	}
}
