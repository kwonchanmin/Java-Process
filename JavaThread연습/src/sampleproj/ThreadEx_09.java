package sampleproj;

class ThreadEx_09_1 implements Runnable{

	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread t;
	
	void setThread(Thread t) {
		this.t = t;
		
	}
	public void run() {
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			} else {
				Thread.yield();
			}
		}
	}
	
	public void suspend() {
		suspended = true;
		//아마도 최대 1초뒤에 상태를 학인해서 일시중지 작업을 시행.
		//최대한 빨리 일시정지 상태에 돌입하려면 현재 thread에 대해서 interrupt를 걸어야 한다.
		t.interrupt();}
	
		public void resume() {suspended = false;}
	public void stop() {stopped = true;}
}

public class ThreadEx_09 {
			// Runnable 객체를 공유하면 안된다.
	public static void main(String[] args) {
		ThreadEx_09_1 r1 = new ThreadEx_09_1();
		ThreadEx_09_1 r2 = new ThreadEx_09_1();
		ThreadEx_09_1 r3 = new ThreadEx_09_1();

		Thread t1 = new Thread(r1,"*");// 스레드 3개가 필드를 공유하게 된다.로직처리해서 
		Thread t2 = new Thread(r2,"**");
		Thread t3 = new Thread(r3,"***");
	
		r1.setThread(t1);
		r2.setThread(t2);
		r3.setThread(t3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000); // main thread sleep
			// 첫번째 thread를 일시정지 할꺼다.
			// thread를 직접 제어하지 않고 thread가 가지고 있는 Runnable객체의 field 값을 조절해서 Runnable객체가 가지고 있는
			// run() method의 로직을 변화시키는 닥ㅓ다
			r1.suspend(); // thread를 제어하는게 아니다. t1. suspend()
			Thread.sleep(2000);
		    r2.suspend();
			Thread.sleep(2000);
			r1.resume(); // 이거 왜 안나와요 로직은 문제 없는거 같은데?
			Thread.sleep(2000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
