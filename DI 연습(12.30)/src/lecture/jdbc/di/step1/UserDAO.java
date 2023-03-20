package lecture.jdbc.di.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO는 단순히 데이터 처리만을 담당한다. 왜냐하면 DAO에는 Business logic이 나올 수가 없기 때문이다.
public class UserDAO {

	public void insert(User user) {
		
		// 일단 JDBC Code가 나온다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql = "Insert INTO users VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			
			pstmt.executeUpdate(); // 사용자 등록
			
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

	public User select(String string) {
		// 일단 JDBC Code가 나온다.
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			
			Connection con = DriverManager.getConnection(jdbc_url,id,pw);
			
			String sql ="SELECT*FROM users WHERE id = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, string);
			
			
			ResultSet rs = pstmt.executeQuery(); // 사용자 등록
			rs.next();
			
			user = new User(string, rs.getString("name"),
					rs.getString("password")
					);
			
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
		
		return user;
	}
}
