package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
	public static int getId(String username) {
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT userID FROM users WHERE username='"+username+"';");
		try {
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
