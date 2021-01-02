package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	Connection connee;
	public UserModel() {
		connee = MySqlConnectionUser.MySqlConnectionUserConnector();
		if(connee == null) {
			System.out.println("No Connection");
			System.exit(1);
		}	
	}
	public boolean isConnectedUser() {
		try {
			return !connee.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean loginAccess(String user , String pass) {
		PreparedStatement ps;
		ResultSet rs;
		String query = "select * from userdata where userName = ? and password = ?";
		
		try {
			ps = connee.prepareStatement(query);
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
