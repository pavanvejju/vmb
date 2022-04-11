package com.vmb.enterprise.designpatterns.creational.singleton;

public class StaticBlockSingleton {

	private static volatile StaticBlockSingleton instance	=	null;
	
	static {
		try{
			instance	=	new StaticBlockSingleton();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private StaticBlockSingleton(){}
	public static StaticBlockSingleton getInstance(){
		return instance;
	}
}
