package exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Exam01_DataServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("서버소켓이 생성되었다 - 포트번호 3000");
			// 이 서버소켓을 통해 클라이언트의 접속을 기다려야된다.
			Socket s = server.accept(); // 클라이언트가 접속할 때까지 일단 대기....
			System.out.println("클라이언트의 접속이 들어왔다!"); // 중복 실행 시 에러가 나오는게 맞다.
			
			// 클라이언트와 연결된 outputStream(데이터를 내보내기 위한 스트림)을 
			// 사용하기 편한 PrintWriter로 만들어요!
			PrintWriter out = new PrintWriter(s.getOutputStream()); // 서버에서 자료를 보내기 위한 통로를 여는 코드
			
			// 현재 시간을 보내줄꺼다
			DateFormat dateFormat = DateFormat.getDateInstance(); // 현재 날짜 시간을 구하는 코드
			String currentDate = dateFormat.format(new Date());
			
			out.println(currentDate); // 데이터를 stream에 있는 저장소에 저장.(아직 전송 x)
			out.flush(); // 데이터를 실제로 보내는 코드
			
			//stream을 닫는다.
			out.close();
			
			// socket을 닫는다. 혼자 쓰는게 아니라 여러 명이 사용하는 것이기 때문에 닫아준다.
			s.close();
			
			// server socket을 닫는다.
			server.close();
			
			System.out.println("서버 종료");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // port번호가 겹칠 가능성이 있기 때문에 try catch 를 해줘야된다.
	}
}
