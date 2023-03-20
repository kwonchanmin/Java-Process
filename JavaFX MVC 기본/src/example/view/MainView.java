package example.view;

import example.controller.Button1Controller;
import example.controller.Button2Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Stage는 준비되었다.
		// 화면 구성을 해보자
		
		// Layout으로는 BorderPane 설정
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		Button btn1 = new Button("위쪽 버튼");
		// 이 코드는 view가 아니라 controller에서 나와야되는 코드다. 
		//하지만 현재 구조는 view에서 써야만 하는 구조이다. 
		btn1.setOnAction(e->{
			
		Button1Controller controller = new Button1Controller();
		// controller에게 일을 시킨다.
		String str = controller.getResult();
		// 결과로 받은 str을 이용해서 화면을 제어한다.
		});
		
		Button btn2 = new Button("아래쪽 버튼");
		btn2.setOnAction(e->{
			Button2Controller controller = new Button2Controller();
			String str = controller.getResult();
		});
		
		root.setTop(btn1);
		root.setBottom(btn2);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
