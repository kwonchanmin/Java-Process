package javaexam1;

public class Test01 {

	public static void main(String[] args) {
		
		String a = args[0];
		int b = Integer.parseInt(a);
		
		
	
			if(b%2 == 0) {
				System.out.println("2의 배수입니다.");
			}else if(b%2 != 0) {
				System.out.println("2의 배수가 아닙니다");
			}
			
		
	}
}
