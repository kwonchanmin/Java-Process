package exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exam05_Client extends Application {

	TextArea textArea;
	Button connbtn;
	TextField iptextField;
	TextField idtextField;
	TextField chattextField;
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg) {
		Platform.runLater(()-> {
			textArea.appendText(msg + "\n");
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
		
		connbtn = new Button("Link Connect");
		connbtn.setPrefSize(150, 40);
		connbtn.setOnAction(e -> {
		
			try {
				socket = new Socket(iptextField.getText(),7777);
				printMsg("Sucess Link");
				pr = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
				while(true) {
				try {
					String receive = br.readLine();
					printMsg(receive);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
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
		chattextField.setOnAction(e -> {
			String id = idtextField.getText();
			String msg = chattextField.getText();
			
			pr.println(id + ":" + msg);
			pr.flush();
			
			chattextField.clear();
		});
		
		
		
		
		downflowPane.getChildren().add(idtextField);
		downflowPane.getChildren().add(chattextField);
		
		root.setTop(upflowPane);
		root.setBottom(downflowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main Client Testing");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
