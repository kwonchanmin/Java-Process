package bank;

public class Customer {
	
	// 1. constructor(생성자)
	// 인자도 없고 하는일도 없는 생성자 => default constructor
	public Customer() {
		
	}

	// 2.field
	public String name;
	public long balance;
	
	//3. method
	public void deposit(long money) {
		int myMoney = 100;
		this.balance += money;
	}
}
