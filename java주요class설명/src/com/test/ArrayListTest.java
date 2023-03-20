package com.test;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// ArrayList를 하나 생성해 보자.
		ArrayList<Object> a = new ArrayList<Object>(); // <>안에 is-a관계를 통해 Object를 호출하면 경고 삭제!!!!!! primitive들이 Object의 sub class 이기 때문에 가능!
		a.add("hello");
		a.add(new Student("홍길동",20));
		a.add(100); // auto Boxing이 발생하고 사용하는 class는 Integer
		a.add(3.14); // auto Boxing 사용하고 Double class 사용.
		
		
		ArrayList<String> b = new ArrayList<String>(); // <>(generic)를 이용해 ArrayList의 데이터 타입을 고정해주는게 기본!
		b.add("hello");
		b.add("홍길동");
		b.add(new String("소리없는 아우성!"));

		System.out.println(a);
		System.out.println(b);
	}
}
