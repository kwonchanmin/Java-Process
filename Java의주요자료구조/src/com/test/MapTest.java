package com.test;

import java.util.HashMap;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String,String> map = new HashMap<String,String>(); // key와 value를 같이 넣어야되기때문에 generic에 2개의 데이터 타입을 넣는다.
		
		// Map에서 데이터를 저장할 때
		map.put("123", "hello");
		map.put("4", "안녕!");
		map.put("kk", "홍길동");
		map.put("aa", "신사임당");
		map.put("123", "소리없는 아우성"); // key 갑이 겹치는 경우 기존은 문장은 지워지고 새로운 문장이 들어온다.
		
		// Map에서 데이터를 추출할 때
		System.out.println(map.get("123"));
		
		// Map안에 있는 모든 key를 알고싶다.
		Set<String> s = map.keySet(); // HashSet은 Set의 하위클래스 임으로 HashSet대신 Set을 사용 가능 is-a관계
		for(String a : s ) {
			System.out.println(a);
		}
	}
}
//exception은 예외상황인데 코드작성 중 갑자기 instance가 생성되는데 그걸 처리하지 않으면 강제종료가 되어버린다. 그래서 이 instance를 exceoption handling을 통해 처리해주면 강제종료가 되지 않는다.
// 이런 의도치 않은 상황들을 exception class로 java에서 class로 해놨다.