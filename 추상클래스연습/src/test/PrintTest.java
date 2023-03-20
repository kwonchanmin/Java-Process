package test;

public class PrintTest {

	// 생성자
	
	// 필드
	private String name;
	private int age;
	
	//메소드
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름은 : " + name + " "+ "나이는 : " + age;
	}
	
	public static void main(String[] args) {
		//PrintTest 라는 class의 instance를 생성
		PrintTest a = new PrintTest();
		// 객체의 정보를 출력하고 싶다.
		
		
		System.out.println("안녕하세요!"); // 인자는 문자열로 변환이 가능한 값이 와야 한다.
		System.out.println(100);
	 	System.out.println(a); // a는 instance를 지칭하고 있다.
	 	                       // 이 메모리 주소값을 문자열로 어떻게 변경하나요?
	 	                       // test.PrintTest@626b2d4a <=객체를 문자열로 변환한 값.
	 	System.out.println(a.toString());
	 	//Object.toString() => 이 메소드는 원래 메모리 주소의 해쉬값을 문자열로 변환하는 일을 한다.
	}
}
