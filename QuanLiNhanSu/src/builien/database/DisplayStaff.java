package builien.database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import builien.model.Employee;

public class DisplayStaff extends Employee{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public DisplayStaff() {
		super();
	}

	public DisplayStaff(int id, String name, Date birthday, String phone, String email, int baseSalary) {
		super(id, name, birthday, phone, email, baseSalary);
	}
	
	public void display() {
		
		DBConnection dbc = new DBConnection();
		conn = dbc.connect();
		String sql = "select * from nhanvien";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("yes");
			while(rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				birthday = rs.getDate("birthday");
				phone = rs.getString("phone");
				email = rs.getString("email");
				salary = rs.getInt("salary");
				
				System.out.println(id + " " + name + " " + birthday+ " " + phone + " " + email + " " + salary);
				
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	
	
}
