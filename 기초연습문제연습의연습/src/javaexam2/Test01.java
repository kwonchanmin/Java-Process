package javaexam2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		
		double sum = 0;
		int arg = 0;
		
		int[] [] array = {
						  {12,41,36,56},
						  {82,10,12,61},
						  {14,16,18,78},
						  {45,26,72,23}};
	

		for(int a = 0; a<array.length; a++) { // 1차원 배열 코드
			for(int b = 0; b<array[a].length; b++) {     // 2차원 배열 코드 = 1차원 배열 코드 밑에 2차원 배열코드를 바로 잡아줌으로써 사용가능
				arg++; 
				sum += Double.valueOf(array[a][b]) ;
			}
		}
		
		System.out.println(sum);
		System.out.println( (double)sum/arg);
	}
}
