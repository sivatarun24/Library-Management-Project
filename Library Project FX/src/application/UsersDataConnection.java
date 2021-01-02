package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsersDataConnection {
		public static Connection MySqlConnectorData() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql:///library","root","");
				return c;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
	}

