package 반복문;

import java.io.IOException;
import java.util.Scanner;

public class Solving_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		int[] arr = new int [T];
		
		for (int i =0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[i] = A+B;
		}
		for (int i =0; i < T; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
