package com.vmb.enterprise.designpatterns.creational.factoryDesignPattern;

public  class CarFactory {

	public static Car buildCar(CarType model){
		
		Car car	=	 null;
		
		Location location	=	Location.ASIA;
		switch (location) {
        case ASIA:
            car = ASIACarFactory.buildCar(model);
            break;
 
        case USA:
            car = USACarFactory.buildCar(model);
            break;
 
        case DEFAULT:
            car = DefaultCarFactory.buildCar(model);
            break;
 
        default:
            // throw some exception
            break;
        }
		
		
		
		return car;
		
	}
}
