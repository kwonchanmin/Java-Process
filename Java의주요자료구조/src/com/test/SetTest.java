package com.test;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		// set안의 데이터를 저장하는건 쉽다.
		set.add("123");
		set.add("홍길동");
		set.add("신사임당");
		set.add("Hello");
		
		// set안에 저장된 데이터를 꺼내는 법은?
		// set은 순서가 없다. 순서를 이용해서 꺼내는 방법은 불가능
		// set은 key가 없다. key를 이용해서 꺼내는 방법도 불가능
		for(String s : set) { //set에 있는 집합자료에서 정보를 하나씩 꺼내쓰세요.
			System.out.println(s);
			
		}
	}
}
