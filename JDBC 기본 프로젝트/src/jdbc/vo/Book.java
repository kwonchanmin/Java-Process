package jdbc.vo;

// VO는 데이터를 표현하는 객체이다.
// VO에는 비지니스 로직이 들어오면 절대 안된다.( 덧셈 뺄셈 등등)
// Database의 table을 참조해서 만든다.

public class Book {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public Book() {

	}

	public Book(String bisbn, String btitle, String bauthor, int bprice) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	@Override
	public String toString() {
		return bisbn + "\t " + btitle + " \t" + bauthor + " \t" + bprice;
	}
}
