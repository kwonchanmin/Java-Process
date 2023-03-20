package sampleproj;

class ThreadEx_03_1 extends Thread{
	
	public ThreadEx_03_1(String name) {
		super();
		this.setName(name); 
	}	
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(this.getName());
		}
	}
}
public class ThreadEx_03 {

	public ThreadEx_03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Thread t1 = new ThreadEx_03_1("Thread-01");
		Thread t2 = new ThreadEx_03_1("Thread-02");
		
		// 실행시키기 전에 우선순위를 매겨보자. 
		t1.setPriority(1); // 지금은 듀얼코어를 사용하기 때문에 우선순위가 안먹힌다. 예전에 싱글코어일때는 잘먹힘.
		t2.setPriority(9);
		
		t1.start();
		t2.start();
	}
}

