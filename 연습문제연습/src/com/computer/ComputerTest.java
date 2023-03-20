package com.computer;

public class ComputerTest {

	public static void main(String[] args) {
		Computer arrays[] = new Computer[4];
		arrays[0] = new Laptop("Lap01",2,1024,2000);
		arrays[1] = new Laptop("Lap02",3,2048,2300);
		arrays[2] = new Tab("Tab01",2,1024,1200);
		arrays[3] = new Tab("Tab02",2,2048,1300);
		
		for(Computer c : arrays) {
			System.out.println(c);
		}
		
		for(Computer c : arrays) {
			c.operate(55);
			System.out.println(c);
			if(c instanceof Laptop) {
				System.out.println(((Laptop)c).rendering(100)) ;
			}
				if(c instanceof Tab) {
				System.out.println(((Tab)c).rendering(100)) ;
			}
		
		}
	}
}

