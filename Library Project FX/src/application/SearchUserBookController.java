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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchUserBookController implements Initializable {

	@FXML private TableView<BooksUsers> tv;
	@FXML private TableColumn<BooksUsers , String> tc1;
	@FXML private TableColumn<BooksUsers , String> tc2;
	@FXML private TextField sea;
	Connection conc;
	

	public ObservableList<BooksUsers> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conc = MySqlConnectionUser.MySqlConnectionUserConnector();
		
	}
	
	public void Back(ActionEvent e) {
		try {

			((Node)e.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Action.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void Search(ActionEvent e) {
		
		PreparedStatement ps5;
		ResultSet rs5;
		String query5 = "select * from bookswithusers where book_id = ?";
		
		try {
			ps5 = conc.prepareStatement(query5);
			ps5.setString(1, sea.getText());
			rs5 = ps5.executeQuery();
			
			while(rs5.next()) {
				list.add(new BooksUsers(rs5.getString(1),rs5.getString(2)));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tc1.setCellValueFactory(new PropertyValueFactory<BooksUsers, String>("user"));
		tc2.setCellValueFactory(new PropertyValueFactory<BooksUsers, String>("book"));
		
		tv.setItems(list);
		
		
	}

}
