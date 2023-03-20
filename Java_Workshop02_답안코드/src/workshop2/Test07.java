package workshop2;

public class Test07 {
	
	public static void main(String[] args) {

		int numberValue = Integer.parseInt(args[0]);

		int resultValue = 0;

		for (int inx = 0; inx <= 100; inx++) {

			if ((inx % numberValue) == 0) {
				resultValue += inx;
			}
		}

		System.out.print(resultValue);

	}

}
