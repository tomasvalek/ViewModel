package cz.tomasvalek.viewmodel.model;

public class Car {

	private String name;
	private String fuel;

	public Car(String name, String fuel){
		this.name = name;
		this.fuel = fuel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getName() {
		return name;
	}

	public String getFuel() {
		return fuel;
	}


}
