package com.vmb.enterprise.designpatterns.creational.factoryDesignPattern;

public abstract class Car {

	private Location location;
	private CarType model;
	public Car(CarType model){
		this.model	=	model;
		
	}
	
	public Car(CarType model,Location location){
		this.model	=	model;
		this.location	=	location;
		
	}
	
	
	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public CarType getModel() {
		return model;
	}
	public void setModel(CarType model) {
		this.model = model;
	}

	private void arrangeParts(){
		System.out.println(" arrangeParts for "+ model);
	}
	
	protected abstract void construct();
	
	@Override
	public String toString(){
		return "Model:"+model+" built in "+location;
	}
}
