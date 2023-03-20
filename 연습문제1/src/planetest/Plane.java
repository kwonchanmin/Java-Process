package planetest;

public abstract class Plane {
	
	// constructor
	public Plane() {
		
	}

    public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
    
    // field
    private String planeName;
	private int fuelSize;
	
	
	// method
    
	public abstract void flight(int distance); // 추상 method
	
	public void refuel(int fuel) {
		this.fuelSize += fuel;
		
	}
	@Override
	public String toString() {
		return planeName + " 	" + fuelSize;
	}
    
	// getter&setter
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

}
