package lecture.jdbc.di.step6;

public class Main  {

	public static void main(String[] args) {
		
		User user = new User("Hong","홍길동","1234");
		
		// 생성자에 밀어넣어줘야하기 때문에 여기서 객체를 만든다.
		ConnectionMaker cm = new KosaConnectionMaker(); // 이놈이 의존성을 가지고 있는 dependency이다.
		// 만든 객체(dependency)를 넣어준다.
		UserDAO dao = new UserDAO(cm);
		dao.insert(user); 
		
		System.out.println("새로운 사용자 등록");
		
		User user2 = dao.select("Hong");
		
		System.out.println(user2.getName() + "," + user2.getPassword());
		System.out.println("조회 성공");
	}
}