package exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
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

public class Exam01_DataClient extends Application{

	//field
	TextArea textarea;
	Button connBtn; // 왜 필드를 잡아주었는가??
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성을 해보자!
		//Layout부터 만들어 보자!
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // stage (가로,세로) 크기 설정
		
		// component(구성요소) 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150,40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// 접속 버튼을 클릭하면 하는 일을 여기에 작성
				// 서버와 접속하는 코드를 만들어 주면 된다.
				textarea.clear(); // textarea 안의 내용을 싹 다 지운다! *안에 뭐가 있으면 안되는가??
				// 서버에 접속한다! => 소켓 객체 생성을 시도!
				// 서버에 접속하려면 IP와 port를 알아야한다.
				// 자신을 찾을 때 사용되는 IP : 127.0.0.1 or localhost
				try {
					Socket s = new Socket("127.0.0.1",3000);
					System.out.println("서버 접송 성공!");
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); // 서버에서 보내주는 것을 받아주는 Stream 코드.
					
					String msg = br.readLine(); // 통로로부터 오는 데이터를 읽는 코드 *통로를 통해 무언가 데이터가 들어올 때까지 대기를 한다.
					
					System.out.println(msg);
					
					br.close();
					s.close();
					
					System.out.println("서버와의 연결 종료");
							
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		FlowPane flowpane = new FlowPane(); // 아래쪽 영역에 붙은 Layout
		// 여백좀 잡아서 그나마 보기 좋게 만들자
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER); // 가운데 정렬로 붙여라!
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		
		//버튼을 flowpaned에 붙여라
		flowpane.getChildren().add(connBtn);
		
		// 이렇게 만든 flowpane(판때기)를 bolder layout의 아래쪽에 붙이는거다!
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch();
	}
	
}
