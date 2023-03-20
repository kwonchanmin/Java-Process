package assignment.month;

public class MonthsTest {

	public static void main(String[] args) {
		
		Months months = new Months();
		
		try {                                                                   
			int month = Integer.parseInt(args[0]);                               \
			if(!(month >= 1 && month <= 12)) {                      --------------\
				System.out.println("입력된 값이 잘못 되었습니다.");                        \
				System.exit(0); 										         	/      예외 발생할 가능성이 있는 문장
			}                                                       ---------------/
			System.out.println(months.getDays(month) + "일");                      /
		
		} catch (Exception e) {
			System.out.println("다시 입력해 주세요");                  Exception이 발생하였을 때 이를 처리하기 위한 문장     
		}														보통 이곳에 예외메세지를 출력하고 로그남김
	}
}
