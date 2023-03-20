package workshop01;

public class Test07 {

	public static void main(String[] args) {
		
		int i = 5;
		String result = (i%2 ==0) ? "숫자 5는 짝수입니다":"숫자 5는 홀수입니다";
			
		System.out.println("선언 변수 " + i + " 일때 결과 :");
		System.out.println(result);
	}
}
