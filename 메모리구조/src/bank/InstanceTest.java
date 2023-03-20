package bank;

// javac InstanceTest.java => compile한 후
// java bank.InstanceTest = > JVM을 이용해서 실행
public class InstanceTest {

	// 1.생성자
	public InstanceTest() {
		
	}
	
	// 2. field
	//class variable : class 이름으로 사용할 수 있는 변수
	static int a = 100;  // a의 공간이 생성되는 곳은 method Area다.
	                     // instance를 만들지 않고도 사용할 수 있다.
	
	// instance variable : instance가 있어야지 사용할 수 있는 variable
	int b = 200; // b는 instance가 생성된 후에 그 안에 공간이 생성된다
	             // 공간이 생성되는 곳은 당연히 Heap
	
	// 3. method
	public void instanceCall(String msg) {
		System.out.println(msg);
	}
	public static void staticCall(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		int k = 100; //local variable(지역변수) => stack애 저장되고
		             //메소드가 종료하면 당연히 없어진다.
		InstanceTest hong = new InstanceTest();
		
		hong.a = 300; // instance를 이용해서 static field를 이용할 수 있다.
		InstanceTest.a = 500; //static field이기 때문에 class를 이용해서 사용할 수 있다.
		
		hong.b = 300;   //ok
		InstanceTest.b = 500; //error 이렇게 사용 x
	}
}
