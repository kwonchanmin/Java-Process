package javaexam2.plane;

public class PlaneTest {

	public static void main(String[] args) {
		
		Plane air = new Airplane("L747" , 1000);
		Plane cargo = new Cargoplane("C40", 1000);
		
		System.out.println("Plane    fuelSize");
		System.out.println("--------------------");
		System.out.println(air);
		System.out.println(cargo);
		System.out.println();
		
		air.flight(100);
		cargo.flight(100);
		System.out.println("100 운항");
		System.out.println("Plane    fuelSize");
		System.out.println("--------------------");
		System.out.println(air);
		System.out.println(cargo);
		System.out.println();
		
		air.refuel(200);
		cargo.refuel(200);
		System.out.println("200 주유");
		System.out.println("Plane    fuelSize");
		System.out.println("--------------------");
		System.out.println(air);
		System.out.println(cargo);
	}
}
