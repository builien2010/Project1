package control.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;

public class BookDAO extends Book{
	
	private ArrayList<Book> bookList = new ArrayList<>();
	
	public BookDAO(int id, String title, String subject, String author, boolean isIssued) {
		super(id, title, subject, author, isIssued);
		
	}

	static Connection conn = null;
	PreparedStatement pstmt = null;
	
	static void ketnoi() {
		DBConnection dbc = new DBConnection();
		conn = dbc.connect();
	}
	
	// chèn thêm sách
	public void getInfoBook() {
		ketnoi();
		String sql = "select * from book";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("yes");
			while(rs.next()) {
				bookId = rs.getInt("Mã sách");
				title = rs.getString("Tên sách");
				subject = rs.getString("Thể loại");
				author = rs.getString("Tác giả");
				
				
				
				System.out.println(id + " " + name + " " + birthday+ " " + phone + " " + email + " " + salary);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	// lấy ra tất cả các sách
	public void getBook() {
		
	}
	
	// xóa sách
	
}
