package test;

// java test.Student => 1. method area에 class 정보를 올려요
//                      2.class 안에서 main을 찾는다. 만약 없으면 error
//                        만약 있으면 jvm에 의해서 main 이 호출되요.
//                      3. stack에 main method를 위한 공간을 할당!
                        

// 객체지향의 상속을 이용해서 class를 다시 만들어요
// java에서 extends라는 keyword를 제공해요!
// extends 뒤에 class가 나올 수 있는데 이 때, 자바는 단 하나의 class만 나올 수 있다.
// JAVA는 다중상속을 지원하지 않아요. . extends keyword다음에 단 1개만 나와요.!
// java는 단일상속을 지원해요!


public class Student extends Person  {

	public Student() {
		// 상위 클래스의 constructor를 호출
	    //만약 이 코드가 없으면 자동으로 삽입.
		         //상위 class의 생성자를 호출하는 코드
		         //Person() 이 형태의 생성자를 호출
		// 현재 객체의 field를 초기화하는 부분
	}
	
	// field
    private String dept; // 학과
	
	// method
	//상속받은 상위 클래스의 메소드를 하위 클래스 메소드에서 재정의(다시정의) 하는거다.
    // emthod overriding ( 메소드 오버라이딩)
    public void eat() {
    	super.eat(); // 상위 type의 method를 호출할 수 있어요.
		System.out.println("밥을 신나게 먹어요!");
	}
    public void study() {
    	System.out.println("공부를 해요!");
	}
    
    public static void main(String[] args) {
		// data type => 지정된 변수 안에 들어올 값에 대한 제한을 하는것
    	
    	Person s = new Student();
        //현재 s 로는 eat() method를 호출할 수 없다.
    	// 형(type)변환을 이용하면 가능하다. => casting 작업을 하면 된다. => () 괄호를 이용
//    	s.eat(); // 밥을 신나게 먹어요 ==> 이건 쉽다.
    	s.eat(); // 동적바인딩이 일어난다. (dynamic binding)
    	// 원래는 Person의 eat() method를 호출해야 되는데 .. 
    	//method overriding을 이용해 method를 다시 작성한 경우에는
    	// overriding된 method를 대신 호출한다.
    	
    	//이렇게 되면 결국 Person에 있는 eat은 호출할 방법이 없게된다.
		
	}
}
