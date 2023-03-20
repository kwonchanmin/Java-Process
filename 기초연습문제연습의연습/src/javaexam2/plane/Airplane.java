package javaexam2.plane;

public class Airplane extends Plane {

	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - distance*3 );
	}
	
	
}
