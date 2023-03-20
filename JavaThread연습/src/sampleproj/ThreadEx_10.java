package sampleproj;

class ThreadEx_10_1 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx_10_2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("|");
		}
	}
}


public class ThreadEx_10 {

	public static void main(String[] args) {
		long startTime = 0;
		
		Thread t1 = new ThreadEx_10_1();
		Thread t2 = new ThreadEx_10_2();
		
		t1.start();
		t2.start();
		
		startTime =System.currentTimeMillis(); // 숫자로 현지시간을 표현
		
		try {
			t1.join(); // 메인 스레드가 실행되고 진행되는 와중에 메인스레드를 멈추고 티원스레드가 조인되어 티원스레드가 다 끝나면 메인이 다시 시작된다. 전문새치기범,개쌍양아치
//			t2.join(); // join은 try catch (내가 안끝내면 너는 못해 마인드)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}
