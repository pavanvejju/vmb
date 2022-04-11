package com.vmb.enterprise.designpatterns.creational.singleton;

/**
 * @author pavanvejju
 * */
public class EagerSingleton {
	// private constructor
	private EagerSingleton(){}
	private static volatile EagerSingleton instance=new EagerSingleton();
	// factory method
	public static EagerSingleton getInstance(){
			return instance;	
	}
}
