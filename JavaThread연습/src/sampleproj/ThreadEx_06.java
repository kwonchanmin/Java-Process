package sampleproj;

import javax.swing.JOptionPane;

class ThreadEx_06_1 extends Thread{

	@Override
	public void run() {
		
		int i = 10;
		while(i != 0 && !isInterrupted()) { // !는 not의 의미.
			System.out.println(i--); // 10출력 후 i 값을 1 감소.
			/// busy-waiting
			for(long k = 0; k<250000000000000000L; k++);
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}


public class ThreadEx_06 {

	public static void main(String[] args) {
		
		Thread t = new ThreadEx_06_1(); // thread instance 생성
		
		t.start(); // thread를 Runnable 상태로 전이시켜요!
//		바로 실행은 안되지만 언젠가는 .. Thread scheduler에 의해 실행이 된다.
		String data = JOptionPane.showInputDialog("값을 입력하세요!");
		System.out.println(data);
	
		t.interrupt(); // thread를 interrupt 시켰다.
		               // thread가 중지된다는지 일시정지된다던지 하는 일은 생기지 않는다.
					   // logic으로 thread의 행동을 제어해야 한다.
	                   // 만약 interrupt를 걸었는데 이때 해당 thread가 
					   // sleep상태이면...
	}
}
