package lecture.jdbc.di.step4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// 상속도 안돼 데이터연결정보도 못 넣어 답이 없네..
// 연결정보를 class 단위로 분리하면 어떨까?

public class UserDAO {
	
	private SimpleConnectionMaker simpleConnectionMaker; // 다른 클래스이름을 명시해 줌으로써 두개의 클래스가 tightly coupled 되는 것이다.
	
	public UserDAO() {
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	public void insert(User user) {
		
		// 일단 JDBC Code가 나온다.
		try {
			Connection con = simpleConnectionMaker.getConnection();
			String sql = "Insert INTO users VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			
			pstmt.executeUpdate(); // 사용자 등록
			
			pstmt.close();
			con.close();				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User select(String string) {
		// 일단 JDBC Code가 나온다.
		User user = null;
		try {
			Connection con = simpleConnectionMaker.getConnection();
			
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
