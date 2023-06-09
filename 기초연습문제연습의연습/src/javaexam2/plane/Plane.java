package javaexam2.plane;

public abstract class Plane {

	public Plane() {
		// TODO Auto-generated constructor stub
	}
	
	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}


	private String planeName;
	private int fuelSize;
	
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel) {
		fuelSize += fuel;
	}
	
	public abstract void flight(int distance);
		
	
	@Override
	public String toString() {
		return planeName + "\t " + fuelSize;
	}
}
