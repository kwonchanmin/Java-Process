package workshop01;

public class Workshop01_6 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a+b);
		char ch = 'A';
		ch = 67;
		float f = 1.5f;
		long l = 27000000000L;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = ((float)d == f2);
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f ="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
	}
}
