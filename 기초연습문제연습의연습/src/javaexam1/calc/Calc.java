package javaexam1.calc;

public class Calc {
		
		public int sum(int a,int b) {
			return a+b;
		}
		
		public int sbutract(int a, int b) {
			return a-b;
		}
		
		public int multiply(int a,int b) {
			return a*b;
		}
		
		public int divide (int a, int b) {
			if(b<= 0) {
				return 0;
			}
			    return   a/b
					;
		}
}