package lecture.jdbc.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPConnectionPoll {
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

}
