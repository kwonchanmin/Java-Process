package sampleproj;

// 이렇게 만든 클래스는 당연히 Thread가 아니다. 단지 Runnable이라는 특별한 interface를 구현한 class일 뿐이다.
// 그래서 getName() method를 이용하려면...

class ThreadEx_01_2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
}
// 이 밑에 있는 클래스는 당연히 Thread다. is-a 관계에 의해!
class ThreadEx_01_1 extends Thread {

	public ThreadEx_01_1() {
		// TODO Auto-generated constructor stub
	}
	// 새로운 독립적인 실행 흐름이라고 했는데..
	// 프로그램에 entry point에 준하는 무언가 시작 method가 있다는 의미다.
	@Override
	public void run() {
		// 내가 실행하고 싶은 코드를 작성!
		// for문 같은 경우..
		// 1. 집합자료구조를 이용하는 경우 => for ~ else 구문
		// for(String s : list){}
		// 2. 원하는 횟수만큼 반복할 경우 => 일반 for문
		for(int i = 0; i<5; i++) {
			System.out.println(getName());
		}
	}
}

// 예전섶명
// java ThreadEx_01 => 실행하면..
// JVM이 main method를 호출해서 프로그램을 시작한다!

// Thread 관점에서 다시 설명
// java ThreadEx_01 => 실행하면
// JVM이 내부적으로 Thread를 하나 생성.
// 이 Thread가 main method를 호출해서 실행
// 이 Thread를 main thread라고 부른다.
// process(program)의 종류는 main method가 시작하면 시작하는거고 
// main method가 종료되는 전체 프로그램이 종료된다 => 틀리다.

// 정확하게는 process안에 있는 모든 Thread가 종료되어야지 
// process가 종료되게 된다.
public class ThreadEx_01{
	
	public static void main(String[] args) {
		// 이 main method는 당연히 하나의 Thread에 의해서 실행되는 method
		Runnable r2 = new ThreadEx_01_2(); // 이것은 Thread가 아니다.
		Thread t2 = new Thread(r2); // 얘가 우리의 Thread가 된다.		
		
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		//t1은 Thread instance가 된다!
		// t1은 현재 객체일 쁜이다.. 아직 동작하고 있지 않다.
		// 이 Thread는 독립적인 실행 흐름을 가지고 있다.
		// run()안에 그 내용을 기술하고 있다.
		// 이제 이 Thread를 실행시킬꺼다.
//		t1.run();
		// 이렇게 호출하면 .. 단순히 객체의 method를 호출하는거지
		// Thread를 실행시킨건 아니다.!
		// 거의 대부분의 method는 blocking method(메소드가 수행이 끝나고 리턴될때까지 대기)다.
		
		// 이렇게 하는게 아니라 다른 method를 이용해야한다.
		t1.start(); // thread-0
		t2.start(); // thread-1
		// start 는 non-blocking method다.
		// start를 이용해서 Thread를 실행시킨다.
		System.out.println("main thread 종료!!");
	} 
}
