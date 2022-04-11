package com.vmb.enterprise.designpatterns.behavioral.strategy;

public class FacebookStrategy implements ISocialMediaStrategy {

	@Override
	public void connectTo(String friendName) {

		 System.out.println("Connecting with " + friendName + " through Facebook");
	}

}
