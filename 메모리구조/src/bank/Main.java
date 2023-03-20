package bank;

public class Main {

	public static void main(String[] args) {
		
		// 프로그램 시작
		//hong은 지역변수이다.
		
		Customer hong = new Customer();
		hong.name = "홍길동";
		
		hong.deposit(2000);
	}
}
