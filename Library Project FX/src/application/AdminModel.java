package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
	Connection conne;
	public AdminModel() {
		conne = MySqlConnectionAdmin.MySqlConnector();
		if(conne == null) {
			System.out.println("No Connection");
			System.exit(1);
		}	
	}
	public boolean isConnected() {
		try {
			return !conne.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean loginAccess(String user , String pass) {
		PreparedStatement ps;
		ResultSet rs;
		String query = "select * from data where userName = ? and password = ?";
		
		try {
			ps = conne.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next())return true;
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
