package com.vmb.enterprise.designpatterns.behavioral.strategy;

public class Demo {

	public static void main(String[] args) {

		SocialMediaContext context	=	new SocialMediaContext();
		context.setSocialMediaStrategy(new TwitterStrategy());
		context.connect("Vejju");
		
		System.out.println("==========================================");

		context.setSocialMediaStrategy(new GooglePlusStrategy());
		context.connect("Pavan");
	}

}
