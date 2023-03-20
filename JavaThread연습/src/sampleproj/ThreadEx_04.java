package sampleproj;


public class ThreadEx_04 implements Runnable {
	
	// field
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new ThreadEx_04());
		t.setDaemon(true); // 이 부분을 지우면 안끝난다. 
		
		t.start();
		
		for(int i =0; i<20 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if(i == 5 ) {
				autoSave = true;
			}
		}
	}

	@Override
	public void run() {
		
		while(true) {
			// Thread를 일정시간 동안 재울꺼다.
			try {
				Thread.sleep(3000); // 누워있는 sleep은 static이다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(autoSave) {
				System.out.println("자동저장 되었어요!");
			}
		}
	}
}
