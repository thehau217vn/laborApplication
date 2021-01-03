package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();

	public static Connection getConnect() throws SQLException {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DB_QLLD;"
				+ "user=sa;password=231226738@SQL;";
		Connection con = DriverManager.getConnection(connectionUrl);
		return con;
	}

	public void disconnect() throws SQLException {
		Connection con = ConnectDB.getConnect();
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ConnectDB getInstance() {
		return instance;
	}

	public static ResultSet executeQuery(String sql) {
		try {
			Connection con = ConnectDB.getConnect();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Boolean executeNonQuery(String sql) {
		try {
			Connection con = ConnectDB.getConnect();
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
