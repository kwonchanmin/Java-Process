package lecture.jdbc.mbc;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.controller.BookController;
import lecture.jdbc.controller.BookDeleteController1;

import lecture.jdbc.vo.BookVO;

public class BookMVC<BookDeleteController> extends Application {
	TableView<BookVO> tableView;
	
	TextField textField;
	Button deleteBtn;

	String deleteISBN;
	String searchKeyword;
	
	public void start(Stage primaryStage) throws Exception {
		
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
			BookController controller = new BookController();
			ObservableList<BookVO> list = controller.getResult(textField.getText());
			tableView.setItems(list);
			});
		
		//삭제버튼도 만들어서 붙이자
		deleteBtn = new Button("Delete");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true); // 버튼을 사용할 수 없게 할까요 물을 때 false로 설정하면 자료 값이 없는데도 동작을 하기 때문에 true로 설정해 놔서 선택할 자료가 없을 때 버튼이 동작하지 못하게 막아놓는 것이다.
		deleteBtn.setOnAction(e->{
			
			BookDeleteController1 controller = new BookDeleteController1();
			ObservableList<BookVO> list = controller.getResult(deleteISBN,searchKeyword);
			
			
			
			
		});
		
		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(deleteBtn);
		
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
		
		TableColumn<BookVO,Integer> priceColumn = new TableColumn<>("PRICE"); //ISBN 은 화면에 보여지는 컬럼
		priceColumn.setMinWidth(150); // 해당 컬럼의 크기를 설
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));	// 해당 컬럼의 데이터는 VO의 어떤 field에서 값을 가져오는지 설정	
		// TableView에 표현할 데이터를 만들어보자.
		// TableViewdp 데이터를 밀어넣을때는 ..ArrayList와 유사한 List를 사용


		tableView = new TableView<BookVO>();
		
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		
		// 나중에 TableView에 데이터가 표현될 것이다.
		// 이때 각 행들에 대해 이벤트를 설정할 수 있다.
		// 정확하게 얘기하자면 각 행들에 대한 특정 설절을 할 수 있다.
		tableView.setRowFactory(e-> {
			// TableRow(테이블의 각 행)을 만들어서 해당 행에 이벤트 처리를 설정한 다음 해당 행을 리턴하는 방
			TableRow<BookVO> row = new TableRow();
			row.setOnMouseClicked(e1->{
				deleteBtn.setDisable(false); // 삭제버튼 활성화
				BookVO book = row.getItem();
				// 삭제할 책의 ISBN의 버튼이 클릭되었을 때 알아내야 한다.
				deleteISBN = book.getBisbn();
				});
			
				return row;
			});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Book");

	
		primaryStage.show();
		}

	
	public static void main(String[] args) {
	
		launch();
	}
		
}
