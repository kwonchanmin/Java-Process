package assignment;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		System.out.println("입력 값 : " + a+" "+b+" "+ c);
		
		int max = a;
		if(b> max ) max = b;
		if(c> max ) max = c;
		
		System.out.println("최대값 : " + max );
		
		int min = a;
		if(b < min) min = b;
		if(c < min) min = c;
		System.out.println("최소값 : " + min);
		}
	
		
	}

