package com.computer;

public abstract class Computer {

	public Computer() {
		
	}
	
	
	public Computer(String name, int cpu, int memory, int battery) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.battery = battery;
	}

	private String name;
	private int cpu;
	private int memory;
	private int battery;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCpu() {
		return cpu;
	}


	public void setCpu(int cpu) {
		this.cpu = cpu;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	public int getBattery() {
		return battery;
	}


	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public abstract void operate(int time);


	@Override
	public String toString() {
		return name + "\t " + cpu + " \t" + memory + " \t" + battery;
	}
	
	
	
	
	
}
