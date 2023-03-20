package bookstore;

public class BookTest {

	public static void main(String[] args) {
		
		double a;
		double c;
		double d;
		double e;
		
		Book bookArray[] = new Book[5];
		bookArray[0] = new Book("IT", "SQL", 50000, 5);
		bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book("Nobel", "davincicode", 30000, 10);
		bookArray[4] = new Book("Nobel", "cloven hoof", 50000, 15);
	
		for( Book b : bookArray) {
			System.out.println(b);
		}
		d = ((Book)bookArray[0]).getBookPrice() + ((Book)bookArray[1]).getBookPrice()+ ((Book)bookArray[2]).getBookPrice();
		a = ((Book)bookArray[0]).getDiscountBookPrice() + ((Book)bookArray[1]).getDiscountBookPrice()+ ((Book)bookArray[2]).getDiscountBookPrice();
		System.out.println("IT Category의 책 가격 합 :" + d +"원");
		System.out.println("IT Category의 할인 된 책 가격 합 :" + a +"원");
		e =  ((Book)bookArray[3]).getBookPrice()+ ((Book)bookArray[4]).getBookPrice();
		c = ((Book)bookArray[3]).getDiscountBookPrice()+ ((Book)bookArray[4]).getDiscountBookPrice();
		System.out.println("Nobel Category의 책 가격 합 : " + e + "원");
		System.out.println("Nobel Category의 할인 된 책 가격 합 : " + c + "원");
	}
}