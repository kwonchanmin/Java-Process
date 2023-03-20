package javaexam1;

public class Test06 {

	public static void main(String[] args) {
		
		double result = 0;
		
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		for(int a = 0; a <array.length;a++) {
			if(a%2 !=0) {
				System.out.println(a);
				result =  Double.valueOf( result + a) ;
			}
		}
				System.out.println("합계 :" + result);
				
				
					
	}
}
