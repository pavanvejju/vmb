package com.vmb.enterprise.designpatterns.creational.factoryDesignPattern;

public class SedanCar extends Car{

	public SedanCar(Location location){
		super(CarType.SEDAN,location);
		construct();
		
	}

	@Override
	protected void construct() {
		System.out.println("Building SEDAN car");
		
	}
}
