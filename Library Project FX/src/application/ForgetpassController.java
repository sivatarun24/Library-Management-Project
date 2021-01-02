package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ForgetpassController implements Initializable {
	@FXML private TextField tff1;
	@FXML private TextField tff2;
	@FXML private TextField tff3;
	@FXML private Button b1;
	@FXML private Button b2;
	@FXML private Button b3;
	@FXML private Label l;
	
	
	
	Connection conncc;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conncc = MySqlConnectionAdmin.MySqlConnector();
	}
	public void Back(ActionEvent e) {
		try {
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Admin.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void getPassword(ActionEvent e) throws Exception {
		String u = tff1.getText();
		String p = tff2.getText();
		
		PreparedStatement ps2;
		ResultSet rs2;
		String query2 = "select password from data where unique_id = ? and phonenumber = ?";
		
		ps2 = conncc.prepareStatement(query2);
		ps2.setString(1, u);
		ps2.setString(2, p);
		if(u.length()>0 && p.length()>0) {
			rs2 = ps2.executeQuery();
			if(rs2.next()) tff3.setText(rs2.getString(1));
		}else {
			l.setText("Check Id and Phone Number..");
		}
	}
	public void Login(ActionEvent e) throws Exception {

		String u = tff1.getText();
		String p = tff2.getText();
		String pa = tff3.getText();
		
		PreparedStatement ps3;
		ResultSet rs3;
		String query3 = "select password from data where unique_id = ? and phonenumber = ? and password = ?";
		
		ps3 = conncc.prepareStatement(query3);
		ps3.setString(1, u);
		ps3.setString(2, p);
		ps3.setString(3, pa);
		
		rs3 = ps3.executeQuery();
		if(rs3.next()) {
			try {
				((Node)e.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/AdminMain.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}else {
			
		}
		
	}
}
