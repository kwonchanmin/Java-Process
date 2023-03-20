package lecture.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
import lecture.jdbc.VO.BookVO;

public class BookSearchJavaFXConnectionPool extends Application {

//	TextArea textArea;
	// TableView 안에 데이터를 표현할 때 VO를 가져다가 한 줄씩 표현하게 된다.
	// 그 때 어떤 VO를 사용하는지 class이름을 generic으로 지정해야된다.
	TableView<BookVO> tableView;
	
	TextField textField;
	Button deleteBtn;

	String deleteISBN;
	

	private static BasicDataSource basicDS;  
	
	static {
		
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/mysql_test_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10); 
		basicDS.setMaxTotal(20); 
		}
	
	public static DataSource getDataSource() {  
		return basicDS;
	}
	
	
	@Override
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
			
			DataSource ds = getDataSource();
			Connection con = null;
			
			try {
			con = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT bisbn,btitle,bauthor,bprice ");
			sql.append("FROM library.book ");
			sql.append("WHERE btitle LIKE ? ");
			sql.append("ORDER BY btitle ASC ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		
			pstmt.setString(1,"%"+ textField.getText() + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			ObservableList<BookVO> list = FXCollections.observableArrayList();
			
			while(rs.next()) {
				BookVO bookvo = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("bauthor"),
						rs.getInt("bprice"));
				list.add(bookvo);
			}
			tableView.setItems(list);
			textField.clear();
			
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			});
		
		//삭제버튼도 만들어서 붙이자
		deleteBtn = new Button("Delete");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true); // 버튼을 사용할 수 없게 할까요 물을 때 false로 설정하면 자료 값이 없는데도 동작을 하기 때문에 true로 설정해 놔서 선택할 자료가 없을 때 버튼이 동작하지 못하게 막아놓는 것이다.
		deleteBtn.setOnAction(e->{
			//버튼을 누르면 여기가 실행된다.
			DataSource ds = getDataSource();
			Connection con = null;
			
			try {
				con = ds.getConnection();
				con.setAutoCommit(false);
				
				String deletesql = ("DELETE FROM library.book WHERE bisbn = ? ");
				PreparedStatement pstmt = con.prepareStatement(deletesql);
				pstmt.setString(1 , deleteISBN);
				
					
				int count = pstmt.executeUpdate();
				
				System.out.println("삭제한 row의 수 : " + count );
				
				if(count==1) {
					con.commit();
					reset();
				} else {
					con.rollback();
				}
				
				pstmt.close();
				con.close();
				
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		
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
		primaryStage.setTitle("Simple JavaFX TableView");
	
		primaryStage.setOnCloseRequest(e->{
			try {
				((BasicDataSource)getDataSource()).close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		primaryStage.show();
		}
		
		public void reset() {
			DataSource ds = getDataSource();
			Connection con = null;
			try {
				con = ds.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT bisbn,btitle,bauthor,bprice ");
				sql.append("FROM library.book ");
				sql.append("WHERE btitle LIKE ? ");
				sql.append("ORDER BY btitle ASC ");
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			
				pstmt.setString(1,"%"+ textField.getText() + "%");
				
				ResultSet rs = pstmt.executeQuery();
				
				ObservableList<BookVO> list = FXCollections.observableArrayList();
				
				while(rs.next()) {
					BookVO bookvo = new BookVO(rs.getString("bisbn"),
							rs.getString("btitle"),
							rs.getString("bauthor"),
							rs.getInt("bprice"));
					list.add(bookvo);
				}
				tableView.setItems(list);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		launch();
	}
		

	
}
