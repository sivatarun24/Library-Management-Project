package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewAllBooksController implements Initializable {
	
	@FXML private TableView<BooksData> tv;
	@FXML private TableColumn<BooksData , String> tc1;
	@FXML private TableColumn<BooksData , String> tc2;
	@FXML private TableColumn<BooksData , String> tc3;
	@FXML private TableColumn<BooksData , String> tc4;
	@FXML private TableColumn<BooksData , String> tc5;
	Connection conc;
	

	public ObservableList<BooksData> list = FXCollections.observableArrayList();	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
		PreparedStatement ps5;
		ResultSet rs5;
		String query5 = "select * from books;";
		
		conc = MySqlConnectionUser.MySqlConnectionUserConnector();
		try {
			ps5 = conc.prepareStatement(query5);
			rs5 = ps5.executeQuery();
			
			while(rs5.next()) {
				list.add(new BooksData(rs5.getString(1),rs5.getString(2),rs5.getString(3),rs5.getString(4),rs5.getString(5)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		tc1.setCellValueFactory(new PropertyValueFactory<BooksData, String>("bookId"));
		tc2.setCellValueFactory(new PropertyValueFactory<BooksData, String>("name"));
		tc3.setCellValueFactory(new PropertyValueFactory<BooksData, String>("isbn"));
		tc4.setCellValueFactory(new PropertyValueFactory<BooksData, String>("publisher"));
		tc5.setCellValueFactory(new PropertyValueFactory<BooksData, String>("cost"));
		
		tv.setItems(list);
	}

	public void Back(ActionEvent e) {
		try {

			((Node)e.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/UserMain.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
}
