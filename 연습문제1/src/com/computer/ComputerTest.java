package com.computer;

public class ComputerTest {
	
	public static void main(String[] args) {
		
		Computer arrays[] = new Computer[4];
		// int[]     k      = new     int[4]
		//아하..arrays안에는 Computer라는 클래스 타입의 객체가 들어온다.
		// Laptop과 Tab은 둘 다 Computer의 subclass다.
		// 따라서 IS-A관계에 의해.. Laptop 과 Tab의 instance는 배열에 저장이 가능
		arrays[0]= new Laptop("Lap01",2,1024,2000);
		arrays[1]= new Laptop("Lap02",3,2048,2300);
		arrays[2]= new Tab("Tab01",2,1024,1200);
		arrays[3]= new Tab("Tab02",3,2048,1300);
		
		System.out.println("name\tcpu\tmemory battery ");
		System.out.println("--------------------------------");
		for(Computer c : arrays) {
			System.out.println(c.toString());
		}
		
		//컴퓨터 사용
		
		for(Computer c : arrays) {
			c.operate(55); // 동적바인딩 발생
			System.out.println(c);               // overriding 된 method 호출
			if(c instanceof Laptop) { // 랩탑 클래스의 인스턴스(객체)냐 탭 클래스의 인스턴스(객체)냐 물어보는 거다.
				System.out.println(((Laptop) c).rendering(100));
			}else {
				System.out.println(((Tab) c).rendering(100));
	
				}
			}
		}
		
//		arrays[0].operate(55);
//		arrays[1].operate(55);
//		arrays[2].operate(55);
//		arrays[3].operate(55);
//		System.out.println("name\tcpu\tmemory battery\t rendering time");
//		System.out.println("-------------------------------------------");
//		System.out.println(arrays[0]);
//		System.out.println(arrays[1]);
//		System.out.println(arrays[2]);
//		System.out.println(arrays[3]);
//	
//		((Laptop)arrays[0]).rendering(100);
//		System.out.println(((Laptop)arrays[0]).rendering(100));
//		((Laptop)arrays[1]).rendering(100);
//		System.out.println(((Laptop)arrays[1]).rendering(100));
//		((Tab)arrays[2]).rendering(100);
//		System.out.println(((Tab)arrays[2]).rendering(100));
//		((Tab)arrays[3]).rendering(100);
//		System.out.println(((Tab)arrays[3]).rendering(100));
//	
//	}
		
		
}
