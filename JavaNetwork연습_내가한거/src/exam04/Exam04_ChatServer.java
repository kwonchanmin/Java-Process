package exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

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

class Shared {
	
	ArrayList<Socket> list = new ArrayList<Socket>(); // thread안에 있는 Socket들을 다 가져온다. / field
	HashMap<Socket, PrintWriter> map = new HashMap<Socket, PrintWriter>();
	
	// method
	// 서버에 새로운 클라이언트가 접속하면 해당 클라이언트에 대한 소켓이 서버쪽에 만들어지고
	// 이 소켓을 공유객체에 저장해야 한다.
	// 이 작업을 아래쪽에 있는 method가 수행할 것이다.
	
	public synchronized void addClient(Socket socket) { // thread는 동기화하는게 필수 이기 때문에 꼭 써줘야됨.
		list.add(socket);
		try {
			map.put(socket, new PrintWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void broadcast(String msg) {
		// 전달받은 문자열을 모든 클라이언트 PrintWriter를 통해 데이터를 내보낸다.
		for(Socket s : list) {
			(map.get(s)).println(msg); // (map.get(s)) 이게 Stream을 어레이 리스트와 해쉬맵에 쓰여진 Stream이다.
			(map.get(s)).flush();
		}
	}
}

class MyRunnable implements Runnable{

	Socket socket;
	BufferedReader br;
	Shared shared;
	
	public MyRunnable() {
	}
	
	
	public MyRunnable(Socket socket, Shared shared) {
		super();
		this.socket = socket;
		this.shared = shared;
		
		try {
			
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 원래는 Thread가 입출력을 다 했지만 이제는 그 역할을 공유객체에서 진행할 것이기 때문에 Thread에서 입출력 코드를 가지고 있을 필요가 없다.

	@Override
	public void run() { // 클라이언트와 통신하는 코드가 여기에 입력된다.
		
		try {
			while(true) {
	
			String msg = br.readLine();
			// 공유객체를 통해서 모든 클라이언트에게 데이터를 전달!
			shared.broadcast(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

public class Exam04_ChatServer extends Application{

	TextArea textarea;
	Button startbtn;
	Button stopbtn;
	
	Shared shared; // 공유객체를 필드로 설정해요.
	ServerSocket server;
	

	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n ");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성을 하자.
		// primaryStage => 이놈이 실제 window다!
		
		// 화면을 구성할 Layout을 먼저 만들어요.
		// 우리는 화면 구성을 BorderPane을 이용해서 구성할거다.(동서남북중앙 5등분)
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// 실제 화면구성을 해 보자.
		textarea = new TextArea(); // TextArea textarea = new TextArea(); 이렇게 되어있으면 textarea가 지역변수로 되어있어 이 메소드가 끝이나면 다른 곳에서 사용하기가 난감하다. 그래서 필드로 따로 잡아주는 것이 더 좋다.
		root.setCenter(textarea);
		
		startbtn = new Button("Link start");
		startbtn.setPrefSize(150, 40);
		startbtn.setOnAction(e -> {
			// 이벤트 처리 코드가 나온다. java Lambda
			// 여기가 실행될 동안 window는 잠시 block 된다.
			// 하필이면 클라이언트의 접속을 무한정 기다리는 코드가 나와야된다.
			// 이 문제를 해결하기 위해 Thread를 생성해서 사용한다.
		
			//공유객체 생성
			shared = new Shared();
			
			
			// 익명 class의 Thread 생성 및 실행
			(new Thread(() -> {
				// 서버소켓을 하나 생성해야된다. 클라이언트의 접속을 기다리는 놈이다.
				try {
					// port가 다른 프로그램에서 사용 중일 수도 있기 때문에 
					// 예외상황이 발생할 수 있다. 그래서 이 코드는 예외처리가 강제된다.
					server = new ServerSocket(7777);
					
					while(true) {
					Socket socket = server.accept(); // 클라이언트의 접속을 기다린다.
					// 대기하고 있다가 클라이언트가 접속하면 해당 클라이언트와 연결된 소켓객체를 하나 생성한다.ㄴ
					
					// Socket을 이용해서 직접 클라이언트와 통신하는 기능을 수정하는 Thread를 하나 만들어줘야된다.
					// Thread를 만들기 위한 클래스가 있어야 된다. 
					
					printMsg("새로운 클라이언트 접속");
					
					//공유객체의 클라이언트 소켓을 저장!!!!!!!!
					shared.addClient(socket);
					
					MyRunnable r = new MyRunnable(socket,shared); // Thread 안에 Runnable 이 있는데 이 러너블을 까보니 소켓이 있다 즉 Thread 안에 소켓이 있다. , 공유객체도 이 안에 넣어줘야되기때문에 입략
					Thread t = new Thread(r);
					t.start();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			})).start();
			
		});
		
		stopbtn = new Button("Link stop");
		stopbtn.setPrefSize(150, 40);
		stopbtn.setOnAction(null);
		
		// BorderPane의 아래부분(Bottom)에 버튼을 붙이자
		// 공간은 1개 인데 버튼이 2개 
		// 일단 판자(flowpane) 하나를 만들어서 버튼 2개를 붙이자
		// 이 판자를 BorderPane의 아래부분(Bottom)에 붙이자
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // new Insets는 패딩 잡는 객체
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(startbtn); // 판자에 내가 원하는 버튼을 붙이는 코드
		flowPane.getChildren().add(stopbtn);
		
		root.setBottom(flowPane);
		
		// 이런 Layout을 이용해서 장면(Scene)을 만든다.
		Scene scene = new Scene(root);
		// 이제 만들어진 장면을 window에 넣어라
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(); // main thread에 의해서 최초로 실행되는 method
		          // program의 entry point
		          // GUI Thread를 하나 생성한다.
	}
}
