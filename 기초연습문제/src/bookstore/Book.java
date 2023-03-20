package bookstore;

public class Book {

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String category, String bookName, double bookPrice, double bookDiscountRate) {
		super();
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}

	private String category;
	private String bookName;
	private double bookPrice;
	private double bookDiscountRate;
	
		public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate*0.01 ;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public double getDiscountBookPrice() {
		return getBookPrice()-(getBookPrice() * getBookDiscountRate());
	}
	
	@Override
	public String toString() {
		return category + "\t " + bookName + " \t" + bookPrice + " 원\t" + bookDiscountRate + "%";
	}
	
}
