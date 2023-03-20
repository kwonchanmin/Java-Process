package example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 기존에는 화면구성을 일일이 다 자바코드로 작성을 했다.
		// 화면은 이미 XML로 만들어져 있다. 그거 가지고 오면 된다.
	
		// Scene Builder로 만들어진 XML 한번  확인해보자
		Parent root = null;
		// FXML 파일을 로드해야 하기 때문에 Loader를 만들어야 한다.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myView.fxml"));
		root =loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch();
	}
}
