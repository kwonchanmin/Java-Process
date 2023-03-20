package 조건문;

import java.io.IOException;
import java.util.Scanner;

public class Solving_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A>=0 && A<=23 && B>=0 && B<=59 && C>=0 && C<=1000) {
			int min = A*60+B+C;
			
			int hour = (min/60)%24;
			int minute = min%60;
			System.out.println(hour+" "+minute);
		}

	}
}
