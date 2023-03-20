package assignment;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		int a;
		int result = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하는 숫자 : ");
		a = sc.nextInt();
		
		for(int b= 1; b<=a; b++) {
			result = result * b;
		}
		System.out.println(result);
		
	}
}
