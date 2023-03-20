package com.test;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동",20);
		Student s2 = new Student("홍길동",20);
		
		// 두 객체가 같은 객체인가??
		// 1. 진짜 2개의 instance가 같은 메모리 공간을 공유하고 있나?
		// 2. instance의 내용이 같은가?
		
		// 일반적으로 똑같은가? => 이 연산자는 "==" => 비교연산자
		// 이 연산의 결과는 같으면 true, 다르면 false 논리값으로 결과가 리턴된다.
		
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // false => true
		
		System.out.println(s1.toString()); // 원래 값:com.test.Student@5e91993f, Student 클래스에서 overriding을 통해 설정해 놓으면 홍길동,20으로 나온다.
	}
}
//b=ㅠ+"kk"; 를 새로 한다고 해서 String pool 안의 b 가 바뀌지는 않는다(immotable=>불변의)
// 대신 새로 Heap의 String pool 안에 hellokk로 생긴다.
// String 은 한번 기준을 정해놓으면 그것은 바뀌지 않는다.
