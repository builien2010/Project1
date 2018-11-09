package control.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Staff;

public class StaffDAO{
	
	static Connection conn = null;
	DBConnection dbc = new DBConnection();
	PreparedStatement pstmt = null;
	private ArrayList<Staff> staffList = new ArrayList<>();

	
	public ArrayList<Staff> getInfoAllStaff() {
		
		conn = dbc.connect();
		
		String sql = "seclect * from staff";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Staff st = new Staff();
				st.setId( rs.getInt("Mã nhân viên"));
				st.setName( rs.getString("Tên nhân viên"));
				st.setPassword( rs.getString("Mật khẩu"));
				st.setAddress( rs.getString("Địa chỉ"));
				st.setPhone(rs.getInt("Số điện thoại"));
				st.setSalary(rs.getDouble("Tiền lương"));
				staffList.add(st);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return staffList;
			
	}
	
	
	public void insertStaff() {
		conn = dbc.connect();
		
		String sql = "insert into staff(Mã nhân viên,Tên nhân viên,Mật khẩu,Địa chỉ,Số điện thoại,Tiền lương) values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
