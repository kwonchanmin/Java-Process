package javaexam1;

public class Test03 {

	public static void main(String[] args) {
		
		String a = args[0];
		int b = Integer.parseInt(a);
		int c;
		int result;
		
		for(b=2; b<6;b++) {
			for(c=1;c<10;c++) {
			result =b*c;
			if(b%2 != 0) {
				System.out.println(b +"*" + c + "=" + result);
			}else if(b%2 == 0) {
				break;
			}
		
			}
		
		
		
		
		
		}
	}
}
