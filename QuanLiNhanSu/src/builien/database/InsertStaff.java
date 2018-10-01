package builien.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import builien.model.Developer;
import builien.model.Employee;
import builien.model.Tester;

public class InsertStaff{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Employee nv;
	
	Scanner scan = new Scanner(System.in);
	public InsertStaff() {
		super();
	}

	public void insert() {
		
		DBConnection dbc = new DBConnection();
		conn = dbc.connect();
		String sql = "insert into nhanvien(id,name,birthday,phone,email,salary) values(?,?,?,?,?,?)";
		
		System.out.println("\nNhập thông tin cho nhân viên.");
		System.out.println("Chọn loại nhân viên ( 1 - Lập trình viên , 2- Kiểm thử viên ) : ");
		int c = scan.nextInt();
		if( c == 1) {
			nv = new Developer();
			nv.nhap();
			((Developer) nv).tinhLuong();
		}else if( c == 2) {
			nv = new Tester();
			nv.nhap();
			((Tester) nv).tinhLuong();
		}
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nv.getId());
			pstmt.setString(2, nv.getName());
			pstmt.setDate(3, nv.getBirthday());
			pstmt.setString(4, nv.getPhone());
			pstmt.setString(5, nv.getEmail());
			pstmt.setInt(6, nv.getSalary());
			
			int check = pstmt.executeUpdate();
			
			if(check != 0) {
				System.out.println("Them thanh cong");
			}else {
				System.out.println("Them that bai");
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	

}
