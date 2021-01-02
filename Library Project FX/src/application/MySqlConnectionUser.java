package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionUser {
	
	public static Connection MySqlConnectionUserConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cc = DriverManager.getConnection("jdbc:mysql:///library","root","");
			return cc;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
