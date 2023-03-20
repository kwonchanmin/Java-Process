package 조건문;

import java.io.IOException;
import java.util.Scanner;

public class Solving_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if( A == B && A== C && B==C) {
			int result = 10000+A*1000;
			System.out.println(result);
		}else if(A == B & A != C) {
			int result = 1000+A*100;
			System.out.println(result);
		}else if(C == A && C != B) {
			int result =1000+C*100;
			System.out.println(result);
		}else if(B == C && B != A) {
			int result =1000+B*100;
			System.out.println(result);
		}else if(A != B && A != C && B != C) {
			if(A >B && A >C) {
				int result = A*100;
				System.out.println(result);
			}else if(B>A && B >C) {
				int result = B*100;
				System.out.println(result);
			}else if(C>A && C > B) {
				int result = C*100;
				System.out.println(result);
			}
		}

}
}
