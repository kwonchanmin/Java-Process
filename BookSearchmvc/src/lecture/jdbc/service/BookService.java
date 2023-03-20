package lecture.jdbc.service;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> getResult(String text) {
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> list = dao.select(text);
		return list;
	}

	public ObservableList<BookVO> deleteISBN(String deleteISBN, String searchKeyword) {
		
		BookDAO dao = new BookDAO();
		
		int count = dao.delete(deleteISBN,searchKeyword);
		ObservableList<BookVO> list = dao.select(searchKeyword);
		return list;
	}

}
