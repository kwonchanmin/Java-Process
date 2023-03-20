package finaltest;

// java finaltest.SubClass => 실행
// 제일 먼저 class에 대한 정보가 method area에 올라가야 된다.
//method area에 class의 정보가 잘 저장되면 그 다음에는 당연히 프로그램의 시작 포인트에서 
// 프로그램을 시작해야 한다. => main()

public class SubClass extends SuperClass {

	// constructor
	public SubClass() {
		super(100); // 상위 클래스의 instance 생성부분.
		// 메모리에 공간을 확보(인스턴스를 위해) => 6번이 출력!
		
	    // 이 아래가 객체의 초기화 진행
		staticCall("8번 문장입니다!");
	    super.myFunc();
	}
	
	// field
	int c = staticCall("6번 문장입니다!");
	static int d = staticCall("7번 문장입니다!");

	// method
	//overriding을 할 것이다.
	@Override // annotation이라고 한다,
	public void myFunc() {
		System.out.println("9번 문장입니다!");
	}
	
	public static void main(String[] args) {
		System.out.println("10번 문장입니다!");
		SuperClass obj = new SubClass();
		obj.myFunc();
	}
	
}
