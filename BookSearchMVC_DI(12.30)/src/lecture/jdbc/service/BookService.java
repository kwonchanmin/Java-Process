package lecture.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.dao.DBCPConnectionPoll;
import lecture_jdbc_vo.BookVO;

// 이놈이 로직담당하는 class
public class BookService {

	public ObservableList<BookVO> selectBooksByKeyword(String text) {
		// 검색 키워드를 받아서 Observable<BookList>를 리턴하는 하나의 작업(Transaction)을 처리
		// 이 작업을 하기 위해서 로직처리가 필요하고 (더하고 빼고, for , if)
		// 당엲시 데이터베이스 처리가 필요 !!
		// 그런데 우리 문제가 워낙 간단하다. 그냥 단순히 데이터베이스 테이블 뒤져
		// 결과를 가져오면 끝난다.
		//그럼 데이터베이스 처리를 해보자
		//여기서 데이터베이스 처리하면 안된다.
		// 그럼 누구한테 시키는가? =>DAO(Data Access Object)한테 시킨다
		Connection con = null;
		try {
			con = (DBCPConnectionPoll.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.select(text);
		return list;
	}

	public ObservableList<BookVO> deleteISBN(String deleteISBN, String searchKeyword) {
		// 로직처리해야된다.
		// DB처리만 있다.
		
		// 여기서부터 Transaction 시작이다.
		// Connection에 대헤서 setAutocommit()을 false로 지정해야 Transaction이 시작!
		
		// 여기에서 Connection을 얻어와야한다.
		Connection con = null;
		try {
			con = (DBCPConnectionPoll.getDataSource()).getConnection();
			con.setAutoCommit(false); // Transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list = dao.select(searchKeyword);
		
		// 여기가 Transaction 끝이다.
		// 서비스의 메소드 맨 마지막에 이 메소드가 잘 처리되었으면 
		// 이 로직코드는 우리가 처리해 줘야 된다.
		// Transaction을 commit 해야하고 그렇지 않으면 rollback 해야된다. 
		if(count == 1 && list != null) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}

}
