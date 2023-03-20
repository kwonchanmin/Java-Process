package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture_jdbc_vo.BookVO;

public class BookDeleteByISBNController {

	public ObservableList<BookVO> getResult(String deleteISBN,String searchKeyword) {
		// Service를 이용해서 로직처리를 해야된다.
		BookService service = new BookService();
		ObservableList<BookVO> list = service.deleteISBN(deleteISBN,searchKeyword);
		return list;
	}

}
