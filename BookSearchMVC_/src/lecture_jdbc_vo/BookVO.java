package lecture_jdbc_vo;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bdate;
	private int bpage;	
	private int bprice;
	private String bauthor;
	private String btranslator;
	private String supplement;
	private String publishrer;
	
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

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
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

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public String getPublishrer() {
		return publishrer;
	}

	public void setPublishrer(String publishrer) {
		this.publishrer = publishrer;
	}

	public BookVO(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String supplement, String publishrer) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.supplement = supplement;
		this.publishrer = publishrer;
	}

	@Override
	public String toString() {
		return bisbn + "\t " + btitle + "\t " + bauthor + "\t " + bprice;
	}

	
	
	
}
