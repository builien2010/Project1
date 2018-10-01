package builien.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/quanlinhansu?characterEncoding=UTF-8&useSSL=false";
	String username = "root";
	String password = "20101998";
	
	public Connection connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error Class Not Found: " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("Error SQL : " + e.getMessage());
		}
		
		return conn;
		
		
	}
	

}
