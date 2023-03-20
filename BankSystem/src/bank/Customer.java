package bank;


public class Customer {

	// 1. 생성자
	// 생상자가 같은 package 안에 있는 다른 class에 의해서 사용된다면
	//public keyword가 필요 없어요,
	// 만약 생서자가 다른 package 안에 있는 class에 의해서 사용된다면
	//public keyword가 필요
	// 지금 우리는 같은 프로젝트 안에 다른 package에서 Customer class의 
	//instance를 생성할 예정이다. 따라서 생성자에 public을 붙여야 된다.
	public Customer() {
		//default 생성자 : parameter도 받지 않고 하는 일도 없는 생성자.
	}
	// 그런데 생성자는 1개 이상 있을 수 있다고 했습니다.
	//  하나의 클레스안의 생성자의 이름은 모두 동일하기 때문에 인자의 개수 혹은 인자의 타입으로 
	// 생성자를 구분해야한다.
	// 생성자는 무슨 일을 하나?  => 만들어진 인스턴스의 초기화를 담당!
	// 인스턴스의 필드초기값을 설정하는 일을 한다.
	public Customer(String name) {
		this.name = name;
	}
	
	// 2.field를 선언
	public String name; // 고객이름 => instance variable
	public String accountNumber; // 계좌번호 => instance variable
	public long balance; //잔액 => instance variable
	
	// 3.method 정의
	// 잔액을 확인한다 라는 기능을 만들꺼다. => 잔액을 알아내서 리턴한다.
	// -기능자체가 잔액을 조사해서 출력까지 진행할껀지...
	// -기능은 잔액을 조사해서 잔액의 값만 리턴시키고 출력은 따로 수행할건지...
	public long getBalance() {
		return this.balance;
		//this는 변수다... 그 안에 어떤 값이 들어있냐하면..메모리 주소값이 들어있다.
		// instance에 대한 reference주소가 들어가있다.
		// 현재 사용하는 객체의 대한 주소가 들어있게 된다.
	}
	
	// 입금하는 기능(리턴값이 없는 형태의 method로 만들꺼다.
	public void deposit(long money) {
		this.balance += money;  // this.balance = this balance + money;
	}
	
	//출금하는 기능(출금은 후 잔액을 리턴값으로 사용)
	public long withdraw(long money) {
		// 만약 잔액이 출금요쳥액보다 적으면 출금이 안된다.
		if(this.balance < money) {
			System.out.println("잔액부족");
		}else {
			this.balance -= money;
		}
		return this.balance;
	}
}