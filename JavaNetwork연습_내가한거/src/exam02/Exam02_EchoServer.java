package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Flow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoServer extends Application{
		
	
	
		TextArea textarea;
		Button startbtn;          // 필드를 오버라이딩 안에 놓으면 지역변수로 변경될 수 있어 곤란해진다
		Button stopbtn;
		ServerSocket server;
		Socket s;
		
		PrintWriter pr;
		BufferedReader br;
	
		private void printMsg(String msg) {
			Platform.runLater(() -> {
				textarea.appendText(msg + "\n"); // thread를 계속해서 사용할 것이기 때문에 메소드로 잡아서 사용을 하고
			});
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception { // start는 실제로 창을 만드는 method, 
		// 창의 화면 구성을 하자!
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);  // Layout의 사이즈(가로 세로) 설정
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startbtn = new Button("server start");
		startbtn.setPrefSize(150, 40);
		// 버튼을 클릭했을 때 ( 클릭은 ActionEvent) 이벤트처리가 나온다. 리스너 객체
		// 이벤트 처리는 리스너 객체 or 핸들러 객체가 담당 = > deligation model
		startbtn.setOnAction(e -> {      // event가 발생하면 {}안에 있는 작업을 수행하라는 코드를 축약하여 만든 코드 / 지렸다! 
			//원래 코드
//			startbtn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
			
			printMsg("서버가 실행중");
			try {
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기중");
				
				(new Thread(()->{
					try {
						
						s = server.accept();
						printMsg("클라이언트 접속 성공");
						
						pr = new PrintWriter(s.getOutputStream());
						br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						
						while(true) {
						String msg = br.readLine(); // client에서 메세지를 보낸 것을 받는을려고 대기하는 코드
						printMsg("클라이언트의 메세지 : " + msg );
						
						if(msg.equals("/exit")){
							break;
						}
						pr.println(msg);
						pr.flush();
					}
						
					printMsg("클라이언트 종료 & 서버 종료");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				})).start(); // 그냥 server.accept()를 쓰면 블락이 걸려서 사용할 수가 없기 때문에 Thread를 통해 운용될 수 있게 만들자
				
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
//			textarea.appendText("서버가 시작된다!" + "\n"); // appendtext는 우리가 문장을 쓰면 여러줄 쓰기때문에 작성해주는 코드 , \n은 줄바꿈 코드
			// blocking method!! 실행되는 동안 수행이 잠시 중지된다.
			// 아하 이렇게 하면 안된다!
			// 순차처리를 안하기 위해서 당연히 Thread를 사용해야 된다.
//			Platform.runLater(() -> {}); // Thread가 실행될려면 run()이라는 메소드가 필요한데 이 run은 Runnable안에 들어가있다.  
//		});                              // 그래서 ()안에 Runnable 객체를 넣어주면 되서 new Runnable을 넣어서 오버라이딩 시킨다. 하지만 run() 안에 아무것도 없기 때문에 () -> {}로 표현
		                                 //runLater()는 지연 처리 라는 뜻. => 주어진 매개값을 Runnable이 바로 처리하는 것이 아니라 이벤트 큐에 먼저 저장된 Runnable을 처리한 후 처리.	
//		new Thread(()->{}); 이렇게 작성해도 thread가 완성되서 실행시킬 수 있지만 javafx 특성상 Platform.runLater 이 코드로 thread를 실행시켜줘야된다.
		
		
		stopbtn = new Button("server stop");
		stopbtn.setPrefSize(150, 40);
		stopbtn.setOnAction(null);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10)); // 안쪽 여백객체를 만들어서 여백을 설정
		flowpane.setColumnHalignment(HPos.CENTER); // 정렬 
		flowpane.setHgap(10); // 버튼 사이의 좌우간격을 설정하는 코드
		
		flowpane.getChildren().add(startbtn); // flowpane에 startbtn을 붙이는 코드
		flowpane.getChildren().add(stopbtn);
		
		root.setBottom(flowpane);
		
		Scene scene= new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo server Program");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(); // GUI Thread가 생성되서 우리 창이 실행된다.
	}
}
