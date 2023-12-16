package util;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionManager {
	private static Connection cn = null;

	// reading db properties from cnfig.properties files
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static String driver = null;

	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ConnectionManager.url = props.getProperty("mysql.url", "jdbc:mysql:localhost/cc2");
		ConnectionManager.username = props.getProperty("mysql.username", "root");
		ConnectionManager.password = props.getProperty("mysql.password", "Password@1234");
		ConnectionManager.driver = props.getProperty("mysql.driver", "com.mysql.jdbc.Driver");
	}

	// No one can instantiate this Class
	private ConnectionManager() {
	}

	public static Connection getConnection() {
		if (cn == null) {
			// create connection
			try {
				
				Class.forName(driver);
				cn = DriverManager.getConnection(url, username, password);

			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cn;
	}
	
	public static void CloseConnection() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}