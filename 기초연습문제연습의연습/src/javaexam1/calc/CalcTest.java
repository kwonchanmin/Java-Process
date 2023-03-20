package javaexam1.calc;

public class CalcTest {

	public static void main(String[] args) {
		
		String c = args[0];
		String d = args[1];
		int a = Integer.parseInt(c);
		int b = Integer.parseInt(d);
		
		Calc calc = new Calc();
		calc.sum(a , b);
		System.out.println("합 :" + calc.sum(a , b));
		calc.sbutract(a, b);
		System.out.println("차 :" + calc.sbutract(a, b));
		calc.multiply(a, b);
		System.out.println("곱 :" + calc.multiply(a, b));
		calc.divide(a, b);
		System.out.println("나누기 :" + calc.divide(a, b));
	}
}
