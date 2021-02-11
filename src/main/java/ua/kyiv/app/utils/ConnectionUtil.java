package ua.kyiv.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtil {
	private static String USER_NAME = "krivasmile";
	private static String USER_PASSWORD = "2death!!";
	private static String URL = "jdbc:mysql://localhost/shop";
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("LoggerConfig.xml");
		Class.forName ("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
}
