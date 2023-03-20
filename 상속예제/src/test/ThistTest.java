package test;

public class ThistTest extends Object {

	// 1.constructor(생성자)
	// default constructor는 항상 명시적으로 작성해 주세요.
	public ThisTest() {
		this(100); // this()는 현재 class의 다른 생성자를 호출할 때 사용!
	}
	
	// constructor overloading으로 또 다른 생성자를 만들어요!
	public ThisTest(int k) {
		super();
		System.out.println("인자가 하나 있는 생성자!");{
			
		}
		
		//field와 methode는 따로 존재하지 않아요.
		
    public static void main(String[] arge ) {
    	ThisTest a = new ThisTest();
    }
}