package assignment;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a;
		double b;
		double c;
		double d;
		double e;
		double f;
		double g;
		double h;
		
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		d = sc.nextDouble();
		e = sc.nextDouble();
		
		f = (double)((a+b)/2) * 0.6;
		g = ((c+d)/2)*0.2;
		h = e*0.2;
		
		double result = f+g+h;
		System.out.println("평가점수 : " + result);
		
		if(result >=90) {
			System.out.println("class : Gold Class");
		}else if(result >= 80 && result < 90 ) {
			System.out.println("class : Silver Class");
		}else if(result >= 70 && result < 80) {
			System.out.println("class : Bronze Class");
		}else if(result < 70) {
			System.out.println("class : Normal Class");
		}
	}
}
