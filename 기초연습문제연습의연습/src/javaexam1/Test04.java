package javaexam1;

public class Test04 {

	public static void main(String[] args) {
		
		int a = 1;
		int result = 0, b = 0;
		while(a <= 100) {
			a++;
		 	result += a;
		 	b = result/2;
		 	
		}
		 	double c = Double.valueOf(result);
		 	double d = Double.valueOf(b);
		
		 	
		 	System.out.println("합계 :" + c);
		 	System.out.println("평균 :" + d);
	}
}
