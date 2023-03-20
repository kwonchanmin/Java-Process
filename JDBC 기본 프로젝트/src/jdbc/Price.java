package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Price {

	public static void main(String[] args) {
		String keyword;
		Scanner sc = new Scanner(System.in);
		keyword = sc.next();
		
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
			String sql = "SELECT btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
		
			
			// 5단계 결과처리
			while(rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				int price = rs.getInt("bprice");
				System.out.println("책 제목은 : " + title);
				System.out.println("책 저자은 : " + author);
				System.out.println("책 가격은 : " + price);
				System.out.println("--------------------------------------------------------------------------------");
		}		
			// 6단계 사용한 자원 반납
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}}
		
}


// 데이터베이스 안의 테이블 안의 필드들이 도메인에 들어가는 정보들이다. 테이블을 기반으로 테이블안의 필드들을 이용해서 VO를 설계한다.
// 테이블의 row 하나가 하나의 VO가 되는 것이다. 테이블의 모든 컬럼을 다 가지고 class를 만들어서 객체를 만들면 DO에 가깝고 테이블이 너무많은데 그중 일부만 가지고 만들면 VO에 가깝다








