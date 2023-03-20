package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

public class BookController {

	public ObservableList<BookVO> getResult(String text) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.getResult(text);
		return list;
	}

}
