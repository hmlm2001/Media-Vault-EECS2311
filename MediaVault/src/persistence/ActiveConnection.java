package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActiveConnection {
	public Connection con;
	public ResultSet result;
	public Statement statement;

	public ActiveConnection(Connection con, Statement statement, ResultSet result){
		this.con = con;
		this.result = result;
		this.statement = statement;
		
	}
	public void closeConnection() {
		try {
			this.result.close();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
