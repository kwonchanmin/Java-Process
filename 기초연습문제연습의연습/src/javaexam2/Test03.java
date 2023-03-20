package javaexam2;

import java.util.StringTokenizer;

public class Test03 {

	public static void main(String[] args) {
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		
		double data[] = new double[5];
		double sum = 0;
		

		// StringTokenizer를 이용하여 데이터를 꺼낸다.
		StringTokenizer st = new StringTokenizer(str,",");
		
		for(int i = 0; st.hasMoreElements(); i++) {
			//배열에 실수 데이터를 넣는다.
			data[i] = Double.parseDouble(st.nextToken());
		}	
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		System.out.printf("합계 : %.3f %n",sum);
		System.out.println("평균 :" + sum/5);// or sum/data.length도 가능
		
	}
}
