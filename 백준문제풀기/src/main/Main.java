package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A =sc.nextInt();
		
		int[] arr = new int [A];
		
		for(int i =1; i<=A; i++) {
			arr[i]= A++;
			System.out.println(arr[i]);
		}
	}
}
