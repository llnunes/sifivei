package br.com.sifivei.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGresConnUtils {

	public static Connection getPostgresConnection() throws ClassNotFoundException, SQLException {
		// Note: Change the connection parameters accordingly.
		String hostName = "localhost";
		String dbName = "projimpoo";
		String userName = "postgres";
		String password = "postgres";
		return getPostgresConnection(hostName, dbName, userName, password);
	}

	public static Connection getPostgresConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		String connectionURL = "jdbc:postgresql://" + hostName + "/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}