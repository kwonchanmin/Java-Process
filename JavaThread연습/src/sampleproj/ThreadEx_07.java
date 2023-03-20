package sampleproj;

import java.util.spi.CurrencyNameProvider;

class ThreadEx_07_1 implements Runnable {

	@Override
	public void run() {
		
		while(true) {
			// 현재 수행중인 스레드의 이름을 찾아 스레드의 이름을 출력한다.
			System.out.println(Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
		}
	}
	
}
public class ThreadEx_07 {

	public static void main(String[] args) {
		//Runnable interface를 구현한 class의 instance를 생성.
		Runnable r = new ThreadEx_07_1();
		
		Thread t1 =  new Thread(r,"*");
		Thread t2 =  new Thread(r,"**");
		Thread t3 =  new Thread(r,"***");
		
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000); // main thread가 잔다.
			t1.suspend();       // t1을 일시중지.  //실행시 메인 스레드가 잠들고 운영되는 동안에는 t1이 나오는데, 메인 스레드가 깨고나면 t1을 재워 2,3 번만 나온다.
			Thread.sleep(2000); 
			t2.suspend();   
			Thread.sleep(2000); 
			t1.resume();   
			Thread.sleep(2000); 
			t1.stop();   
			t2.stop();
			Thread.sleep(2000); 
			t3.stop();  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
