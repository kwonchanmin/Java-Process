package lecture.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.vo.BookVO;

public class SimpleJavaFXTableView extends Application {

//	TextArea textArea;
	// TableView 안에 데이터를 표현할 때 VO를 가져다가 한 줄씩 표현하게 된다.
	// 그 때 어떤 VO를 사용하는지 class이름을 generic으로 지정해야된다.
	TableView<BookVO> tableView;
	
	TextField textField;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// 1. layout부터 설정해야 된다.
		// borderpane을 이용 (동서남북중앙)
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// 2. BorderPane 아래쪽에 붙일 상자 flowPane 하나 생성
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));;
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			
		});
		flowpane.getChildren().add(textField);
		
		
		// 컬럼객체를 생성한다.
//		TableColumn<해당컬럼에 나오는 데이터를 어떤 VO에서 가져오는지는 그 VO의 클래스 명시, VO에서 값을 가져올 때 사용하는 데이터 타>
		TableColumn<BookVO,String> isbnColumn = new TableColumn<>("ISBN"); //ISBN 은 화면에 보여지는 컬럼의 이
		isbnColumn.setMinWidth(150); // 해당 컬럼의 데이터는 VO의 어떤 field에서 값을 가져오는지 설정
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		
		TableColumn<BookVO,String> titleColumn = new TableColumn<>("TITLE"); //ISBN 은 화면에 보여지는 컬럼의 이
		titleColumn.setMinWidth(150); // 해당 컬럼의 데이터는 VO의 어떤 field에서 값을 가져오는지 설정
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		TableColumn<BookVO,String> authorColumn = new TableColumn<>("AUTHOR"); //ISBN 은 화면에 보여지는 컬럼의 이
		authorColumn.setMinWidth(150); // 해당 컬럼의 데이터는 VO의 어떤 field에서 값을 가져오는지 설정
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		TableColumn<BookVO,Integer> priceColumn = new TableColumn<>("PRICE"); //ISBN 은 화면에 보여지는 컬럼의 이
		priceColumn.setMinWidth(150); // 해당 컬럼의 데이터는 VO의 어떤 field에서 값을 가져오는지 설정
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		
		
		// TableView에 표현할 데이터를 만들어보자.
		// TableViewdp 데이터를 밀어넣을때는 ..ArrayList와 유사한 List를 사용
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		list.add(new BookVO("123", "java 30일 완성" , " 홍길동 " , 2000));
		list.add(new BookVO("456","java 이제 그만", "신사임당",5000));
		list.add(new BookVO("789","java 어려워요!!", "강감찬",8000));

		tableView = new TableView<BookVO>();
		
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		
		tableView.setItems(list);
		root.setCenter(tableView);
		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple JavaFX TableView");
		
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch();
	}
		

	
}
