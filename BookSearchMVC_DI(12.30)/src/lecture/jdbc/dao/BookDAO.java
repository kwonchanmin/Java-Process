package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture_jdbc_vo.BookVO;

// 데이터베이스 처리 전문객체를 만들기위한 class
public class BookDAO {

	Connection con;
	
	public BookDAO() {
	
	}
	
	public BookDAO(Connection con) {
		super();
		this.con = con;
	}

	public ObservableList<BookVO> select(String text) {
		
		
		ObservableList<BookVO> list = null;
		
		try {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn,btitle,bauthor,bprice ");
		sql.append("FROM library.book ");
		sql.append("WHERE btitle LIKE ? ");
		sql.append("ORDER BY btitle ASC ");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
	
	
		pstmt.setString(1,"%"+ text + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		list = FXCollections.observableArrayList();
		
		while(rs.next()) {
			BookVO bookvo = new BookVO(rs.getString("bisbn"),
					rs.getString("btitle"),
					rs.getString("bauthor"),
					rs.getInt("bprice"));
			list.add(bookvo);
		}
		rs.close();
		pstmt.close();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return list;
	}
	public int delete(String deleteISBN) {
		
		int count = 0;
		
		try {
			String deletesql = ("DELETE FROM library.book WHERE bisbn = ? ");
			PreparedStatement pstmt = con.prepareStatement(deletesql);
			pstmt.setString(1 , deleteISBN);
			
				
			count = pstmt.executeUpdate();
			
			System.out.println("삭제한 row의 수 : " + count );
			
			pstmt.close();
					
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		return count;
	}

	
}
