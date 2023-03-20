package com.test;

class MyClass extends Exception{
	
}
public class CustomExceptionTest {

	public static void main(String[] args) throws MyClass {
		System.out.println("시작");
		
			try {
			throw new MyClass(); // exception 객체가 생성 ( 아직은 그냥 객체 단계)
			}catch(NullPointerException MyClass) {
				// 이런 exception객체를 던져야된다.
			}
		
		System.out.println("끝");
	}
}
