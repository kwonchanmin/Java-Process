package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture_jdbc_vo.BookVO;

public class BookSearchByKeywordController {

	public ObservableList<BookVO> getResult(String text) {
		// Controller의 역할은 View와 service 와의 연결
		// Service 객체가 있어야지 일을 시킬 수 있다.
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectBooksByKeyword(text); 
		
		return list;
	}

}
