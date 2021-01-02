package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminSignController implements Initializable {
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	@FXML private PasswordField pf1;
	@FXML private TextField tf3;
	@FXML private TextField tf4;
	@FXML private TextField tf5;
	@FXML private Label logginsttus;
	Connection connec;
	String x;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(true) {
			connec = MySqlConnectionAdmin.MySqlConnector();
			 x = String.valueOf((int)((Math.random()*1000)+(Math.random()*100)+(Math.random()*10)));
			tf1.setText(x);
		}
	}
	public int addAdmin(ActionEvent e) throws Exception {
		
		String a = tf2.getText();
		String b = pf1.getText();
		String y = String.valueOf(tf5.getText());
		String c = tf4.getText();
		String d = tf4.getText();
		
		PreparedStatement ps1 ;
		String query1 = "insert into data(unique_id , userName , password , name , address , phonenumber) values(?,?,?,?,?,?) ";
		
		ps1 = connec.prepareStatement(query1);
		ps1.setString(1, x);
		ps1.setString(2, a);
		ps1.setString(3, b);
		ps1.setString(4, c);
		ps1.setString(5, d);
		ps1.setString(6, y);
		
		
		a = a.replace(" ","");
		b = b.replace(" ","");
		c = c.replace(" ","");
		d = d.replace(" ","");
		y = y.replace(" ","");
		int i=-1;
		if(a.length()>0 && b.length()>0 && c.length()>0 && d.length()>0 && y.length()>0) {
			 i = ps1.executeUpdate();
		}else {
			logginsttus.setText("Enter UserName and Password");
		}
		if(i > 0) {
			try {
				((Node)e.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/Dialog.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return i;
				
		
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
	public void Check(ActionEvent e) {
		
	}
}
