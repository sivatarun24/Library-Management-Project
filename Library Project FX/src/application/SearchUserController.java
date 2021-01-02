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

public class SearchUserController implements Initializable {
	
	@FXML private TextField sea;
	@FXML private TableView<Usersdata> tv;
	@FXML private TableColumn<Usersdata , String> tc1;
	@FXML private TableColumn<Usersdata , String> tc2;
	@FXML private TableColumn<Usersdata , String> tc3;
	@FXML private TableColumn<Usersdata , String> tc4;
	@FXML private TableColumn<Usersdata , String> tc5;
	@FXML private TableColumn<Usersdata , String> tc6;
	Connection conc;
	

	public ObservableList<Usersdata> list = FXCollections.observableArrayList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conc = UsersDataConnection.MySqlConnectorData();

	}
	public void get(ActionEvent e) {
		
		PreparedStatement ps8;
		ResultSet rs8;
		String query8 = "select * from userdata where unique_id = ?";
		
		try {
			ps8 = conc.prepareStatement(query8);
			
			ps8.setString(1, sea.getText());
			
			rs8 = ps8.executeQuery();
			
			while(rs8.next()) {
				list.add(new Usersdata(rs8.getString(1),rs8.getString(2),rs8.getString(3),rs8.getString(4),rs8.getString(5),rs8.getString(6)));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		tc1.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("userid"));
		tc2.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("username"));
		tc3.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("password"));
		tc4.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("name"));
		tc5.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("address"));
		tc6.setCellValueFactory(new PropertyValueFactory<Usersdata, String>("phonenumber"));
		
		tv.setItems(list);
	}
	public void Back(ActionEvent e) {
		try {

			((Node)e.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Bookdetails.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
