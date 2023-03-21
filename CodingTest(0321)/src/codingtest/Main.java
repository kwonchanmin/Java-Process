package codingtest;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {

	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 개수
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 선수의 수
			N = sc.nextInt();
//			3 <- T
//			5 <- N(선수의 수)
//			-1 2 -3 2 -1 <- N (선수의 실력을 나타내는 N개의 정수) 
		int[] A = {1,2,3,4,5,6,7,8,9,10};
		System.out.println();
		int sum;
		int s = 0;
		int i = 0;
		int t = 0;
		
		if(1 <= s && s<=i&& i<=t&& t<=N) {
			for(int a = 0; a<=t; a++) {
				sum = A[s+a];
			}
		}
		
			System.out.println("#" + test_case + " " + AnswerN);
		}

	}

}
