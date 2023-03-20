package planetest;

public class Airplane extends Plane {
	
	public Airplane() {
		
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);

	}
				
	
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance*3));
	}
	class Cargoplane extends Plane{
		
		public Cargoplane() {
			
		}
		
		public Cargoplane(String planeName, int fuelSize) {
			super(planeName,fuelSize);
		}

		@Override
		public void flight(int distance) {
			setFuelSize(getFuelSize()-(distance*5));
			
		}
		
		
	}
}