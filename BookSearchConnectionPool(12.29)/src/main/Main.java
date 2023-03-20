package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {

	private static BasicDataSource basicDS; // datasource라고 하는것이 커넥팅 풀이다. static으로 해준 이유는 인스턴스 생성없이 바로 사용이 가능하기 때문이다. 
	// 메인이 호출되기 전에 특정코드를 실행시키고 싶다.
	// 일반적으로 프로그램에서 사용하는 resource 같은 거 로딩할 때 사용한다.
	static {
		// connection pool을 만들어보자
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/mysql_test_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10); // 데이터베이스 초기 크기를 10개로 잡는다는 소리이다.
		basicDS.setMaxTotal(20); // 전체 커넥션 풀을 최대 20개 까지만 만든다는 소리이다. 처음에는 위에 잡아놓은 10개밖에 없겠지만 무한정 늘릴수 없기때문에 20개로 설정을 해주는 것이다.
	}
	
	public static DataSource getDataSource() {  // 베이직데이타소스의 상위소스인 데이터소스를 사용해서 basicDS를 외부에서 사용하기 위해서 만들어주는 코드 
		return basicDS;
	}
	
	public static void main(String[] args) {
		DataSource ds = getDataSource();  // connection pool을 가져오자
		Connection con = null;
		try {
			con = ds.getConnection(); // connection pool에서 connection을 빌려온다.
			String sql = "SELECT btitle,bauthor FROM library.book ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("btitle"));
			}
			rs.close();
			pstmt.close();
			con.close(); // 연결을 끝는 작업을 하는 것이 아니라 pool에 반납을 하는 것이다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
