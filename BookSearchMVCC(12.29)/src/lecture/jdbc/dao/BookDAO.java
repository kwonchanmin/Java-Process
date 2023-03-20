package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture_jdbc_vo.BookVO;

// 데이터베이스 처리 전문객체를 만들기위한 class
public class BookDAO {

	private static BasicDataSource basicDS;  
	
	static {
		
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/mysql_test_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10); 
		basicDS.setMaxTotal(20); 
		}
	
	public static DataSource getDataSource() {  
		return basicDS;
	}
	public ObservableList<BookVO> select(String text) {
		DataSource ds = getDataSource();
		Connection con = null;
		ObservableList<BookVO> list = null;
		
		
		try {
		con = ds.getConnection();
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
		con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return list;
	}
	public int delete(String deleteISBN) {
		DataSource ds = getDataSource();
		Connection con = null;
		
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			String deletesql = ("DELETE FROM library.book WHERE bisbn = ? ");
			PreparedStatement pstmt = con.prepareStatement(deletesql);
			pstmt.setString(1 , deleteISBN);
			
				
			int count = pstmt.executeUpdate();
			
			System.out.println("삭제한 row의 수 : " + count );
			
			if(count==1) {
				con.commit();
				
			} else {
				con.rollback();
			}
			
			pstmt.close();
			con.close();
			
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		return 0;
	}

	
}
