package persistence;

import java.sql.*;

public class JDBC_Connection {
	
	public static ResultSet getResult(String query) {
		String url = "jdbc:mysql://localhost:3306/mediavault";
		String user = "admin";
		String password = "0000";

		try {
			// create connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			// create statement
			Statement statement = con.createStatement();
			
			// create resultset
			ResultSet result = statement.executeQuery(query);
			
			return result;
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void execute(String query) {
		String url = "jdbc:mysql://localhost:3306/mediavault";
		String user = "admin";
		String password = "0000";

		try {
			// create connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			// create statement
			Statement statement = con.createStatement();
			
			// create resultset
			statement.executeUpdate(query);
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
}
