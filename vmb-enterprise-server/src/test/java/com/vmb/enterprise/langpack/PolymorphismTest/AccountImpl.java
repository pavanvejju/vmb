package com.vmb.enterprise.langpack.PolymorphismTest;

public class AccountImpl {
	public static void main(String args[]){
		//static binding or static polymorphism
		Account a 	=	 new SavingAccount();
		a.withdraw();
		
		
		//Dynamic polymorphism
		Decide d	=	new Decide();
		d.invokeMyAccount(new CurrentAccount());
		
	}
	
	
}
