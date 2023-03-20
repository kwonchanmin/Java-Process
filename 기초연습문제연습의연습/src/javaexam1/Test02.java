package javaexam1;

public class Test02 {

	public static void main(String[] args) {
		String a = args[0];
		String b = args[1];
		int c = Integer.parseInt(a);
		int d = Integer.parseInt(b);
		int e = c*d;
		
		int length = (int)(Math.log10(e)+1);
		
		if(length == 1) {
			System.out.println("한자리 수 입니다");
			}else if(length == 2) {
				System.out.println("두자리 수 입니다");
			}
//		System.out.println(length);
	}
}
