package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/lms?characterEncoding=UTF-8&useSSL=false";
	String username = "root";
	String password = "20101998";
	
	public Connection getConnection() {
		System.out.println("DBConnection");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối MySQL thành công");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error Class Not Found: " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("Error SQL : " + e.getMessage());
		}
		
		return conn;
		
		
	}
        
        public void closeConnection(Connection conn){
            if( conn == null)
                return;
            
            try{
                conn.close();
            }catch(SQLException e){
                System.out.println("Đóng kết nối lỗi");
            }
        }

}
