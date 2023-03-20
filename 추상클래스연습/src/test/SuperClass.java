package test;

public abstract class SuperClass {

	// 생성자
	public SuperClass() {
		
	}
	// field
	
	// method
	//일반 method(method 정의)
    public void sayHello() {
    	System.out.println("안녕하세요!");
    }
    
    // method 선언 => 완전한 형태의 method가 아니다. => abstract keyword 를 이용해서 표시!
    public abstract void eat();
}

class SubClass extends SuperClass {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	
}
