package test;

//import java.lang.*; // 기본적으로 생략이 가능
//extends Object는 내가 안써도 무조건 붙는다.
public class Person {

	// 1.constructor
	public Person() {
		super(); // 현재 class의 상위 class인 Object class의 생성자를 호출
		         // Object() 가 호출되서 실행!
		//인자도 받아 들이지 않고 하는 일도 없는 constructor
		//default constructor
		
	}
	// 2. field
	private String name;
	private String gender;
	private int age;
	

	// 3. method
	// business logic method
	public void eat() {
		System.out.println("밥을 먹어요!");
	}
	
}
