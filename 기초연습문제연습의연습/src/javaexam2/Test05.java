package javaexam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Test05 {

	public static void main(String[] args) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		double sum = 0.0;
		
		for(int inx = 0; inx <10; inx++) {
			map.put(inx, (int)(Math.random() * 100 +1));
			}
		for(int jnx=0; jnx <10; jnx++) {
			System.out.print(map.get(jnx)+" ");
		}
		for(int jnx=0; jnx <10; jnx++) {
			sum += ((Integer)(map.get(jnx))).intValue(); 
		}
		System.out.println(" ");
		System.out.printf("합계:%.2f", sum);
		System.out.println(" ");
		System.out.printf("평균:%.2f", sum / 10);
	}
}
