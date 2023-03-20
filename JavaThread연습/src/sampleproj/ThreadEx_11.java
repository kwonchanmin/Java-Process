package sampleproj;

// 이 Thread의 instance를 생성해서 실행하면..
// 10초마다 일정량의 메모리사용량을 감소시켜요!
class ThreadEx_11_1 extends Thread{
	
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
			gc();
			System.out.println("남은 메모리량은 : " + freeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300; // usedMemory = usedMemory - 300;
		if(usedMemory < 0 ) {
			usedMemory = 0;
		}
	}
	public int totalMemory() {
		return MAX_MEMORY;
	}
	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}
public class ThreadEx_11 {

	public static void main(String[] args) {
		
		ThreadEx_11_1 t = new ThreadEx_11_1();
		t.setDaemon(true);
		t.start();
		
		int requiredMemory = 0;
		
		for(int i = 0; i<20; i++) {
			requiredMemory = ((int)(Math.random() * 10))* 20;//  Math.random = 0과 1 사이의 난수 값을 나타내는 단어 0과 1은 포함하지 않는다.
			// 0 , 20,40,60,...,180 의 값이 나온다,.
			
			// 위에서 구한 필요한 메모리 양이 사용할 수 있는 메모리 양보다 크거나 
			// 혹은 전체 메모리의 60% 이상을 사용했을 때 gc를 깨울꺼다!
			if((t.freeMemory() < requiredMemory) || 
					t.freeMemory()  < t.totalMemory() * 0.4) {
				t.interrupt();
				
				try {
					t.join(100); // 0.1초동안 위에 t라는 ㄴ
				} catch (InterruptedException e) {
				}
			}
			
			t.usedMemory += requiredMemory;
			System.out.println("남은 메모리량 : " + t.freeMemory());
		
		}
	}
}
