package javafxexam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하는 작업을 여기서 한다.
		Button btn = new Button();
		btn.setText("Start");
		// 버튼에 이벤트 처리를 해야된다.
		// java는 delegation model을 이용한다 => Web의 JavaScript도 이방식을 이용!
		// button에 Action이라는 Event를 처리할 수 있는 Listener객체를 붙인다.
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// event가 발생하면 자동으로 호출된다.
				System.out.println("안녕하세요!!");
			}
		});
		
		
		// Layout을 설정한다(컴포넌트가 붙은 방식을 결정하는 객체)
		StackPane root = new StackPane(); // StackPane => Layout 중 추가되는 순서대로 덧붙여서 시각화하는 Layout
		
		root.getChildren().add(btn);
		
		// Scene 객체를 생성
		Scene scene = new Scene(root, 300, 150);
		
		primaryStage.setTitle("연습입니다.");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		
		launch();
		// GUI Thread가 실행되고 화면에 창이 뜬다!
	}
		
}
