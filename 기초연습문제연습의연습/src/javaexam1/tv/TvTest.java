package javaexam1.tv;

public class TvTest {

	public static void main(String[] args) {
		
		Tv tvArray [] = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		for(Tv t : tvArray) {
			System.out.println(t);
		}
		int a = tvArray[0].getPrice() + tvArray[1].getPrice() +tvArray[2].getPrice();
			System.out.println("가격의 합 :" + a);
	}
}
