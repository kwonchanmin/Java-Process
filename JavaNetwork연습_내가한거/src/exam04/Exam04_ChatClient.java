package exam04;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class Exam04_ChatClient extends Application{

	TextArea textArea;
	TextField iptextField;
	TextField idtextField;
	TextField chattextField;
	Button connbtn;
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textArea.appendText(msg + "\n ");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textArea = new TextArea();
		root.setCenter(textArea);
		
		FlowPane upflowPane = new FlowPane();
		upflowPane.setPrefSize(700, 40);
		upflowPane.setPadding(new Insets(10,10,10,10));
		upflowPane.setColumnHalignment(HPos.CENTER);
		upflowPane.setHgap(10);
		
		iptextField = new TextField();
		iptextField.setPrefSize(200, 40);
		
		connbtn = new Button("server connect");
		connbtn.setPrefSize(150, 40);
		connbtn.setOnAction( e -> {
			// 서버에 접속
			// 특정 IP와 port를 이용해서 Socket객체 생성 시도.
			// 만약 성공하면 서버와 연결된 socket객체를 하나 얻는다.
			try {
				socket = new Socket(iptextField.getText(),7777);
				pr = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				(new Thread(()->{
				  while(true) {
					try {
						String receive = br.readLine();
						printMsg(receive);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }
				})).start();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		upflowPane.getChildren().add(iptextField);
		upflowPane.getChildren().add(connbtn);
		
		FlowPane downflowPane = new FlowPane();
		downflowPane.setPrefSize(700, 40);
		downflowPane.setPadding(new Insets(10,10,10,10));
		downflowPane.setColumnHalignment(HPos.CENTER);
		downflowPane.setHgap(10);
		
		idtextField = new TextField();
		idtextField.setPrefSize(150, 40);
		
		chattextField = new TextField();
		chattextField.setPrefSize(300, 40);
		chattextField.setOnAction(e->{
			// 채팅 입력창에서 enter를 치면 action 이벤트가 발생해서 이 코드가 실행된다.
			String id = idtextField.getText();
			String msg = chattextField.getText();
			
			pr.println(id + ">" + msg);
			pr.flush();
			
		
			chattextField.clear();
 		});
		
		downflowPane.getChildren().add(idtextField);
		downflowPane.getChildren().add(chattextField);
		
		root.setTop(upflowPane);
		root.setBottom(downflowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Client Program");
		primaryStage.show();
		
		
		
		
	}

	public static void main(String[] args) {
		launch();
	}
}
