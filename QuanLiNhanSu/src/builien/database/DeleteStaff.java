package builien.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStaff {
	
	Connection conn = null;
	Scanner scan = new Scanner(System.in);
	PreparedStatement pstmt = null;
	
	
	
	public DeleteStaff() {
		super();
	}
	
	
	public void delete() {
		System.out.println("Nhập mã nhân viên muốn xóa : ");
		int ma = scan.nextInt();
		
		DBConnection dbc = new DBConnection();
		conn = dbc.connect();
		String sql = "delete from nhanvien where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ma);
			int check = pstmt.executeUpdate();
			
			if ( check != 0) {
				System.out.println("Xóa thành công");
			}else {
				System.out.println("Xóa thất bại");
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
	}

}
