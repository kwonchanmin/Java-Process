package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture_jdbc_vo.BookVO;

public class BookDetailByISBNController {

	public ObservableList<BookVO> getResult(String bisbn) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectBooksByKeyword(bisbn);
		return list;
	
	}
}
