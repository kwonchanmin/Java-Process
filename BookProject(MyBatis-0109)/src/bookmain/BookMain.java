package bookmain;

import java.util.List;

import BookController.BookBorrowController;
import BookController.BookReturnBorrowController;
import BookController.BookSearchController;
import Use.vo.UserVO;
import book.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import usermemberinfo.UserMemberInfo;

public class BookMain {

	TableView<BookVO> tableView;
	TextField textField;
	Button userbtn;
	String deleteISBN;
	String searchKeyword;
	String borrow;
	String userID;
	UserVO user;
	BookVO book;

	public BookMain(UserVO user) {
		this.user = user;

	}

	public BorderPane getLayout() {

		BorderPane root = new BorderPane();
		root.setPrefSize(500, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);

		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {

			BookSearchController controller = new BookSearchController();
			List<BookVO> list = controller.getResult(textField.getText());

			ObservableList<BookVO> lists = FXCollections.observableArrayList();

			if (list != null) {
				for (BookVO book : list) {
					lists.add(book);
				}
			}

			tableView.setItems(lists);
			searchKeyword = textField.getText();
			textField.clear();
		});

		userbtn = new Button("내 정보 수정");
		userbtn.setPrefSize(150, 40);
		userbtn.setOnAction(e -> {

			Parent layout = new UserMemberInfo(user).getLayout(); // Parent layout은 부모의 레이아웃에 UserMemberInfo의 레이아웃을 새롭게
																	// 만들준다는 의미다.
			Scene scene = new Scene(layout); // Scene 안에 새롭게 만든 UserMemberInfo의 레이아웃을 넣어서 새로운 씬을 만들어주는 것이다.
			Stage stage = new Stage(); // Stage를 새롭게 만들어준다는 것이다.
			stage.setScene(scene); // 새롭게 만든 스테이지에 지금까지 만들어놓은 레이아웃이 담긴 씬을 스테이지에 넣어준다는 의미다.
			stage.show(); // 이러한 과정을 통해 만들어진 스테이지를 새로운 창으로 보여준다는 의미이다.
			stage.setTitle("내 정보 수정");

		});

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(userbtn);

		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<BookVO, String> dateColumn = new TableColumn<>("DATE");
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("bdate"));

		TableColumn<BookVO, Integer> pageColumn = new TableColumn<>("PAGE");
		pageColumn.setMinWidth(150);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("bpage"));

		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		TableColumn<BookVO, String> translatorColumn = new TableColumn<>("TRANSLATOR");
		translatorColumn.setMinWidth(150);
		translatorColumn.setCellValueFactory(new PropertyValueFactory<>("btranslator"));

		TableColumn<BookVO, String> supplementColumn = new TableColumn<>("SUPPLEMENT");
		supplementColumn.setMinWidth(150);
		supplementColumn.setCellValueFactory(new PropertyValueFactory<>("bsupplement"));

		TableColumn<BookVO, String> publisherColumn = new TableColumn<>("PUBLISHER");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));

		TableColumn<BookVO, Integer> borrowColumn = new TableColumn<>("BORROW");
		borrowColumn.setMinWidth(150);
		borrowColumn.setCellValueFactory(new PropertyValueFactory<>("bborrow"));

		tableView = new TableView<BookVO>();

		tableView.getColumns().addAll(isbnColumn, titleColumn, dateColumn, pageColumn, priceColumn, authorColumn,
				translatorColumn, supplementColumn, publisherColumn, borrowColumn);

		tableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow();
			row.setOnMouseClicked(e1 -> {
				book = row.getItem();
				if (e1.getClickCount() == 2) {

//					BookBorrowSearchController controller = new BookBorrowSearchController();
//					ObservableList<Book> list = controller.getResult(borrow);

					if (book != null) {
						if (book.getBborrow() == 0) {
							Dialog<String> dialog = new Dialog<String>();
							dialog.setTitle("대여 확인");
							ButtonType type = new ButtonType("대여", ButtonData.OK_DONE);
							String st = "대여하시겠습니까?";

							dialog.setContentText(st.toString());
							dialog.getDialogPane().getButtonTypes().add(type);
							dialog.getDialogPane().setMinHeight(100);
							dialog.showAndWait();

							BookBorrowController controller = new BookBorrowController();
							int count = controller.getResult(row.getItem().getBisbn());
							if (count == 1) {
								tableView.setItems(FXCollections.observableArrayList());

							}
						} else {
							if (book.getBborrow() == 1) {
								Dialog<String> dialog = new Dialog<String>();
								dialog.setTitle("반납 확인");
								ButtonType type = new ButtonType("반납", ButtonData.OK_DONE);
								String st = "반납하시겠습니까?";

								dialog.setContentText(st.toString());
								dialog.getDialogPane().getButtonTypes().add(type);
								dialog.getDialogPane().setMinHeight(100);
								dialog.showAndWait();

								BookReturnBorrowController controller = new BookReturnBorrowController();
								int count = controller.getResult(row.getItem().getBisbn());
								if (count == 1) {
									tableView.setItems(FXCollections.observableArrayList());
								}
							}

						}
					}
				} else {

					book = row.getItem();
					System.out.println(book.getBtitle());
					deleteISBN = book.getBisbn();

				}

			});

			return row;
		});

		root.setCenter(tableView);
		root.setBottom(flowpane);

		return root;

	}

}
