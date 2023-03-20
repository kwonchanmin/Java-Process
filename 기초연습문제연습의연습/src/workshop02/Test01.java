package workshop02;

public class Test01 {

	public static void main(String[] args) {
		
		int x = 15;
		if(x>10 && x<20) {
			System.out.println("true");
		}
		char ch1 = ' ';
		if(ch1 == ' '&&  ch1 != '\t') {
			System.out.println("true");
		}
		char ch2 = 'x';
		if(ch2 == x && ch2 == 'X') {
			System.out.println("true");
		}
		char ch3 = '0';
		if('0' <= ch3 && ch3 <= '9') {
			System.out.println("true");
		}
		char ch4 = 'a';
		if(Character.isLetterOrDigit(ch4)) {
			System.out.println("true");
		}
	
	}
}
