package sampleproj;

// 공유객체를 생성하기 위한 class
class Shared {
	
	
	// 공유 객체의 공유 메소드
	public synchronized void printName() {   // thread가 가진 이름을 찍는 메소드생성/이놈을 동기화 실시 첫번째 스레드가 끝나야지 두번째 쓰레드 실시
		
		try {
			for(int i=0; i<10;i++) { // thread 이름을 몇번 찍을껀지 생각하면서 for문 작성
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()); // 현재 수행중인 스레드의 이름을 가져온다.
				notify(); // 노티파이가 먼저 위에 객체를 꺼내주고 실행되어야 되기 때문에 위에 있는거다.
				wait(); // 여기에 웨잇을 적으면 첫번째 쓰레드가 이름 출력후 웨잇이 있어 멈추고 두번째 스레드가 오고 또 멈춘다 그럼 결국 둘다 멈추고 시스템만 돌아간다.
				
			}
		} catch (Exception e) {
		
		}
	}
}
class ThreadEx_14_1 implements Runnable{

	public ThreadEx_14_1() {
	}
	
	
	public ThreadEx_14_1(Shared shared) {
		super();
		this.shared = shared;
	}

	private Shared shared;
	
	@Override
	public void run() {
		shared.printName(); // 자기가 가지고 있는 공유객체를 호출해주면 공유객체의 run 실행
	}
}

public class ThreadEx_14 {

	public static void main(String[] args) {
		// 공유객체
		Shared shared = new Shared(); // 공유객체를 만들어서 Runnable 객체를 만들자
		Thread t1 = new Thread(new ThreadEx_14_1(shared), "첫번째 쓰레드");
		Thread t2 = new Thread(new ThreadEx_14_1(shared), "두번째 쓰레드");

		t1.start();
		t2.start();
		
	}
}
