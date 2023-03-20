package exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam05_Server extends Application {

	TextArea textArea;
	Button startbtn;
	Button stopbtn;
	ServerSocket server;
	Socket socket;

	PrintWriter pr;
	BufferedReader br;

	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textArea.appendText(msg + "\n");
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		textArea = new TextArea();
		root.setCenter(textArea);

		startbtn = new Button("Link Start");
		startbtn.setPrefSize(150, 40);
		startbtn.setOnAction(e -> {

			new Thread(() -> {

				try {
					server = new ServerSocket(7777);

					socket = server.accept();
					printMsg("Connecting server");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}).start();
		});
		stopbtn = new Button("Link Stop");
		stopbtn.setPrefSize(150, 40);
		stopbtn.setOnAction(null);

		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(700, 40);
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setHgap(10);

		flowPane.getChildren().add(startbtn);
		flowPane.getChildren().add(stopbtn);

		root.setBottom(flowPane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main Server Testing");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
