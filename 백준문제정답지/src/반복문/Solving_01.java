package 반복문;

import java.io.IOException;
import java.util.Scanner;

public class Solving_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= 9; i++) {
			int result = N * i;
			System.out.println(N + " * " + i + " = " + result);
		}

	}
}
