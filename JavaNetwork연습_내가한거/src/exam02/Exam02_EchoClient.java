package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application{

	TextArea textarea;
	Button connbtn;
	TextField textfield;
	TextField idfield;

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
		
		connbtn = new Button("server link");
		connbtn.setPrefSize(150, 40);

		connbtn.setOnAction(e -> {      // event가 발생하면 {}안에 있는 작업을 수행하라는 코드를 축약하여 만든 코드 / 지렸다! 
			try {
				s = new Socket("127.0.0.1",5000);
				printMsg("서버 연결 성공");
				textfield.setDisable(false);
				pr = new PrintWriter(s.getOutputStream());
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		idfield = new TextField();
		idfield.setPrefSize(200, 40);
		
		textfield = new TextField();
		textfield.setPrefSize(200, 40);
		textfield.setDisable(true);
		textfield.setOnAction(e -> {
			String msg = textfield.getText(); // getText를 이용해서 입력상자 안에 있는 method를 가져온다.
			String id = idfield.getText();
			
		
			pr.println(id + ">" +  msg);
			pr.flush();
			
			if(!msg.equals("/exit")) { // if문을 걸어줌으로써 readLine()이 계속 해서 server에서 문자가 오는 것을 기다리는 것을 방지!!!!!
			try {
				printMsg(br.readLine());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}else {
				printMsg("클라이언트가 서버와 연결이 종료되었습니다.");
			}
			
			textfield.clear();
		
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10)); // 안쪽 여백객체를 만들어서 여백을 설정
		flowpane.setColumnHalignment(HPos.CENTER); // 정렬 
		flowpane.setHgap(10); // 버튼 사이의 좌우간격을 설정하는 코드
		
		flowpane.getChildren().add(connbtn); // flowpane에 startbtn을 붙이는 코드
		flowpane.getChildren().add(idfield);
		flowpane.getChildren().add(textfield);
		
		root.setBottom(flowpane);
		
		Scene scene= new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Client Program");
		primaryStage.show();
		
	
	}
	public static void main(String[] args) {
		launch();
	}
}
