package lecture.jdbc.di.step4;

public class Main  {

	public static void main(String[] args) {
		
		User user = new User("Hong","홍길동","1234");
		
		UserDAO dao = new UserDAO();
		dao.insert(user); 
		
		System.out.println("새로운 사용자 등록");
		
		User user2 = dao.select("Hong");
		
		System.out.println(user2.getName() + "," + user2.getPassword());
		System.out.println("조회 성공");
	}
}
