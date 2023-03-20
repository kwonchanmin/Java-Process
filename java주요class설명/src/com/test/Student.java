package com.test;
//import java.lang.*; // 기본으로 삽입된다!

public class Student {
	
	// constructor
	public Student() {
		
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// field
	private String name;
	private int age;
	
	// method
	
		@Override
	public boolean equals(Object obj) {
		// equals method의 기능을 재 정의
		// instance의 이름과 나이가 같으면 같다라고 새롭게 만들꺼다.
		Student target = (Student)obj;
		boolean result = false;
		if((this.name.equals(target.name)) &&
		   (this.age == target.age)) {
			result = true;
			// name은 문자열 이므로 equals로 바꿔주고 age는 숫자기 때문에 == 를 쓴다.
		}
		return result;
		
	}
	
		@Override
		public String toString() {
			return this.name + " ,  " + this.age;
		}

	// getter & setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
