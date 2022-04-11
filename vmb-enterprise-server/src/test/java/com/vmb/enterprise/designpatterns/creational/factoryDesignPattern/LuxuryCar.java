package com.vmb.enterprise.designpatterns.creational.factoryDesignPattern;

public class LuxuryCar extends Car{

	public LuxuryCar(Location location){
		super(CarType.LUXURY,location);
		construct();
		
	}

	@Override
	protected void construct() {
		System.out.println("Building LUXURY car");
		
	}
}
