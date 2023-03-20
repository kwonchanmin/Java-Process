package sampleproj;

class Account {
	
	// construct
	public Account() {
	}
	
	public Account(int balance) {
		super();
		this.balance = balance;
	}

	// field
	
	private int balance;

	// business method
	// synchronized method(동기화 메소드)
	// 이 메소드를 실행한 thread가 먼저 lock(Monitor)획득.
	// 하나의 thread가 메소드를 호출하면 나머지 하나는 첫번째 thread가 끝날때까지 블락된다.
	public  void withdraw(int money) {
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// 여기는 코드는 동기화가 안되요!
		//~~~~~~~~~~~~~~~~~~~~~~~~~~  
			synchronized (this) {
			
		}
		
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			balance -= money;
		}
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}


class ThreadEx_12_1 implements Runnable{
	
	//field
	Account acc = new Account(1000);
	
	@Override
	public void run() {
		
		while(acc.getBalance() > 0) {
			int money = ((int)(Math.random() * 3+ 1 ))*100;
			acc.withdraw(money); // 공용객체의 출금처리
			System.out.println("남은 잔액은 :" + acc.getBalance());
		}
	}
	
}
public class ThreadEx_12 {
	
	public static void main(String[] args) {

		ThreadEx_12_1 r = new ThreadEx_12_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		
		t1.start();
		t2.start();
		
	}
}






