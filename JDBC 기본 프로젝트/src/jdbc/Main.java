package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			// 1. JDBC Driver Loading 단계
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Dirver Loading 성공");
			String jdbc_url ="jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; // 컴퓨터 안에 있는 mysql과 연결하는 코드
			String id = "root";
			String pw = "test1234";
			// 2. DataBase 접속
			Connection con = DriverManager.getConnection(jdbc_url ,id , pw); // 접속하는 방법 코드 //connection은 접속이 되면 객체가 하나 주어지는거다.
			System.out.println("데이터베이스 접속 성공");
			
			// 일반 Statement 사용
			// 3. Statement 생성
//			Statement stmt = con.createStatement(); // statement의 객체를 만들땐 2단계에서 연결한 con 을 사용
//			// 4. Query를 작성해서 실행시킬거다.(SELECT 구문을 실행시켰다)
//			String keyword = "자바";
//			String sql = "SELECT bisbn, btitle,bauthor,bprice FROM  book WHERE btitle LIKE '%" + keyword + "%'";
//			ResultSet rs = stmt.executeQuery(sql);
			
			// PreparedStatement로 사용해야 된다.
			// PreparedStatement는 SQL을 가지고 생성한다.
			// PreparedStatement는 IN Parameter를 이용할 수 있다 => ?로 표현한다!
			// 주의할 점은 keyword 부분에는 ?(IN Parameter)를 사용할 수 없다. 즉, 조건절에만 사용할 수 있다. 
			String keyword = "자바";
			String sql = "SELECT bisbn, btitle,bauthor,bprice FROM  book WHERE btitle LIKE?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 실행하기 전에 ?를 채워야된다.
			pstmt.setString(1,"%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 결과처리
//			rs.next();
//			String title = rs.getString("btitle"); // 책 이름으로 가져올때  데이터 타입을 가능한 맞춰줄 필요가 있다. 데이터 타입이 안맞아도 출력은 된다 . 자체적으로 변환해서 출력하기 때문에
//			int price = rs.getInt("bprice"); // 책 값을 가져올 때  () 안에 숫자로 써도 되지만 일반적으로 그 명칭을 적어주는게 맞다.
//			System.out.println("책 제목은 : " + title);
			
			while(rs.next()) {
				String title = rs.getString("btitle"); 
				System.out.println("책 제목은 : " + title);  // 이렇게 반복문을 통해 책을 전체 다 가져올 수도 있다.
			}
			
			// 6.사용한 자원 해제.
			rs.close();
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
