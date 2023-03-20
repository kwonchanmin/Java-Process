package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {

	public static void main(String[] args) {
		
		// 특정책을 지워보자
		try {
			// 1단계 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			
			// 2단계 데이터베이스 연결
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			con.setAutoCommit(false); // transaction 시작!
			
			// 3단계 PreparedStatement 생성
			String sql = "DELETE FROM book WHERE btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%여행%");
			
			// 4단계 실행
			int count = pstmt.executeUpdate();
			// 앗.. 리턴값은 정수값이 온다. 영향을 받은 row의 수
			
			// 5단계 결과처리
			System.out.println("삭제한 row의 수 : " + count );
//			con.commit(); transaction을 종료하고 지금까지 실행한 SQL문을 실제로 데이터베이스에 적용

//			con.rollback(); // transaction을 종료하고 지금까지 실행한 SQL문을 무효화!
			// 만약 transaction을 종료하지 않고 connetion을 close하면 transaction을 종료하고 지금까지 실행한 SQL문을 실제로 적용 
			
			// 6단계 사용한 자원 반납
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
