package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;


public class BookDAO{
   
    
    static Connection conn = null;
    DBConnection dbc = new DBConnection();
    PreparedStatement pstmt = null;
    private ArrayList<Book> bookList = new ArrayList<>();
        
    public BookDAO(){
       // conn = dbc.getConnection();
        System.out.println("Kết nối đến BookDAO");
    }

    // lấy thông tin tất cả các sách
    public ArrayList<Book> getInfoAllBook() {
        
	String sql = "select * from book";
	try {
                conn = dbc.getConnection();
                 System.out.println("Kết nối đến BookDAO");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
                    
                    Book book = new Book();
                    book.setIdbook (rs.getInt("idbook"));
                    book.setTitle(rs.getString("title"));
                    book.setSubject(rs.getString("subject"));
                    book.setAuthor(rs.getString("author"));
                    book.setQuantitySum(rs.getInt("quantitySum"));
                    book.setQuantityBorrowed(rs.getInt("quantityBorrowed"));
                    book.setStatus(rs.getString("status"));

                    bookList.add(book);
				
		}
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: BookDAO1" );
	}finally{
            dbc.closeConnection(conn);
        }	
	return bookList;
    }
        
        // tìm kiếm sách theo từ khóa
        
    public ArrayList<Book> searchBooksByKeyword( String keyWordBook){
           
        String sql = "select * from book" + " where idbook like '%"
                  + keyWordBook.trim()
                    + "%'"
                    + " or title like '%"
                    + keyWordBook.trim()
                    + "%'"
                    + " or subject like '%"
                    + keyWordBook.trim()
                    + "%'"
                    + " or author like '%"
                    + keyWordBook.trim()
                    + "%'"
                    + " or quantitySum like '%"
                    + keyWordBook.trim()
                    + "%'"
                    + " or quantityBorrowed like '%"
                    + keyWordBook.trim()
                    + "%'"
                    + " or status like '%"
                    + keyWordBook.trim()
                    + "%'";
            
        System.out.println(sql);
            
        try{
            conn = dbc.getConnection();
             System.out.println("Kết nối đến BookDAO");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setIdbook(rs.getInt("idbook"));
                book.setTitle(rs.getString("title"));
                book.setSubject(rs.getString("subject"));
                book.setAuthor(rs.getString("author"));
                book.setQuantitySum(rs.getInt("quantitySum"));
                book.setQuantityBorrowed(rs.getInt("quantityBorrowed"));
                book.setStatus(rs.getString("status"));
				
                bookList.add(book);
                    
                System.out.println("BookDAO " + book.getIdbook() + " "  + book.getTitle());
				  
            }
                
            pstmt.close();
			
        } catch (SQLException e) {	
            System.out.println("Error: BookDAO2" );
            e.printStackTrace();
        }finally {
            dbc.closeConnection(conn);
        }

        return bookList;
    }
        
    public void insertBook(Book book){
        
        String sql = "insert into book(title,subject,author,quantitySum,quantityBorrowed,status) values(?,?,?,?,?,?)";
        
        try{
            conn = dbc.getConnection();
             System.out.println("Kết nối đến BookDAO");
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setString( 1, book.getTitle());
            pstmt.setString( 2, book.getSubject());
            pstmt.setString( 3, book.getAuthor());
            pstmt.setInt( 4, book.getQuantitySum());
            pstmt.setInt(5, book.getQuantityBorrowed());
            pstmt.setString(6, book.getStatus());
            
            int check =  pstmt.executeUpdate();
            
            if ( check != 0){
                System.out.println("Thêm sách vào CSDL thành công");    
            }else{
                System.out.println("Thêm thất bại");
            }
            
            pstmt.close();
                 
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        }
        
    }
    
    public boolean deleteBook(int id){
        
        String sql = "delete from book where idbook = ?";
        
        int check = 0;
        
        try{
           conn = dbc.getConnection();
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, id);
           
           check = pstmt.executeUpdate();
           
        }catch( SQLException e){
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        }
        
        if( check != 0)
            return true;
        else
            return false;
            
    }
    
    public int sumBookBorrowed(){
        String sql = "select sum(quantityBorrowed) from book";
        
        int sum = 0;
        try {
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            System.out.println("lấy thông tin");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //sum = Integer.parseInt(rs.getString(1));
                //sum = rs.getInt("sum1");
                int c = rs.getInt(1);
                sum = sum + c;
            }
            System.out.println("Tổng số lượng sách mượn là: " + sum);
            
            //count = rs.getInt("count(*)");
            
            pstmt.close();
            
        }catch(Exception e){
            System.out.println("Tính tổng số lượng sách mượn lỗi");
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        } 
        
        return sum;

        
    }
    
    public int sumBook(){
        String sql = "select sum(quantitySum) as sum2 from book";     
        int sum = 0;
        try {
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            System.out.println("lấy thông tin");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //sum = Integer.parseInt(rs.getString(1));
                //sum = rs.getInt("sum2");
                int c = rs.getInt(1);
                sum = sum + c;
            }
            System.out.println("Tổng số lượng sách là: " + sum);
            
            //count = rs.getInt("count(*)");
            
            pstmt.close();
            
        }catch(Exception e){
            System.out.println("Tính tổng số lượng sách lỗi");
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        } 
        
        return sum;

      
    }
    
    public double sumFinePaid(){    
        String sql = "select sum(finepaid) from loan";
        
        double sum = 0;
        try {
            conn = dbc.getConnection();
            System.out.println("Kết nối đến loan");
            System.out.println("lấy thông tin");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //sum = Integer.parseInt(rs.getString(1));
                //sum = rs.getInt("sum2");
                double c = rs.getDouble(1);
                sum = sum + c;
            }
            System.out.println("Tổng số tiền phạt là: " + sum);
            
            //count = rs.getInt("count(*)");
            
            pstmt.close();
            
        }catch(Exception e){
            System.out.println("Tính tổng số tiền phạt");
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        } 
        
        return sum;

      
    }
    
  
	

        
                
			
	
}
