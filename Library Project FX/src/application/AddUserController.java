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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddUserController implements Initializable {
	@FXML private TextField t1;
	@FXML private TextField t2;
	@FXML private TextField t3;
	@FXML private TextField t4;
	@FXML private TextField t5;
	@FXML private TextField t6;
	@FXML private Label status;
	Connection conne;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conne = UsersDataConnection.MySqlConnectorData();
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
	public void Submit(ActionEvent e) throws Exception {
		
		String a = t1.getText();
		String b = t2.getText();
		String c = t3.getText();
		String d = t4.getText();
		String f = t5.getText();
		String g = t6.getText();
		
		PreparedStatement ps4 ;
		String query4 = "insert into userdata( unique_id , userName , password , name , address , phonenumber ) values(?,?,?,?,?,? )";

		ps4 = conne.prepareStatement(query4);
		
		ps4.setString(1, a);
		ps4.setString(2, b);
		ps4.setString(3, c);
		ps4.setString(4, d);
		ps4.setString(5, f);
		ps4.setString(6, g);
		
		a = a.replace(" ","");
		b = b.replace(" ","");
		c = c.replace(" ","");
		d = d.replace(" ","");
		f = f.replace(" ","");
		g = g.replace(" ","");
		
		int i=-1;
		if(a.length()>0 && b.length()>0 && c.length()>0 && d.length()>0 && f.length()>0 && g.length()>0) {
			 i = ps4.executeUpdate();
		} 
		if(i > 0) {
			try {
				((Node)e.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/AddUserDialog.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}else status.setText("Please enter the fields....");
		
	}
	
	
	
	
}
