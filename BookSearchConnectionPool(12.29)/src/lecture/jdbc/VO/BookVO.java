package lecture.jdbc.VO;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public BookVO() {
		
	}

	public BookVO(String bisbn, String btitle, String bauthor, int bprice) {
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

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	@Override
	public String toString() {
		return bisbn + "\t " + btitle + "\t " + bauthor + "\t " + bprice ;
	}
	
	
}
