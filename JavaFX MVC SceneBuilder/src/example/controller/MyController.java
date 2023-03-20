package example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

//JavaFX View와 연결된 Controller다.
//View가 생성되면 연결된 Controller객체도 자동으로 생성된다.
// 이 Controller안에서 버튼에 대한 이벤트 처리를 해야된다.
//여기에 버튼에 대한 reference가 있어야 버튼 클릭 처리를 하던말던 한다.

public class MyController implements Initializable{

	@FXML private Button upperBtn;
	@FXML private Button bottomBtn;
	
	public MyController() {
		System.out.println("controller 호출");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 초기화할 내용이 있으면 여기에 작성
		// 일반적으로 이벤트 등록,처리코드가 나온다.
		
		upperBtn.setOnAction(e->{
			// 서비스 객체를 만들어서 일을 시키면 된다.
		});
		
		bottomBtn.setOnAction(e->{
			// 서비스 객체를 만들어서 일을 시키면 된다.
		});
	}
}
