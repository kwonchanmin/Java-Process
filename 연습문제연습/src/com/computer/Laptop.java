package com.computer;

public class Laptop extends Computer implements Graphic {

	public Laptop() {
		
	}

	public Laptop(String name, int age, int memory, int battery) {
		super(name, age, memory, battery);
		
	}

	@Override
	public double rendering(int size) {
		return (double)size/(getCpu() * getMemory())*20;
	}

	@Override
	public void operate(int time) {
		int result = time / 10;
		setBattery(getBattery() - result);
	}
	
	
	
}
