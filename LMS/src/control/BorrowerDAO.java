package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import model.Borrower;

public class BorrowerDAO{
   
    static Connection conn = null;
    DBConnection dbc = new DBConnection();
    PreparedStatement pstmt = null;
    private ArrayList<Borrower> borrowerList = new ArrayList<>();
        
    public BorrowerDAO(){
       // conn = dbc.getConnection();
        System.out.println("Kết nối đến bảng borrower");
    }

    // lấy tất cả thông tin của các đọc giả
    public ArrayList<Borrower> getInfoAllBorrower() {
        
	String sql = "select * from borrower";
	try {
                conn = dbc.getConnection();
                System.out.println("Kết nối đến borrower");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
             
                    Borrower  borrower = new Borrower();
                    
                    borrower.setIdPerson(rs.getInt("idborrower"));
                    borrower.setName(rs.getString("name"));
                    borrower.setEmail(rs.getString("email"));
                    borrower.setPassword(rs.getString("password"));
                    borrower.setAddress(rs.getString("address"));
                    borrower.setPhone(rs.getInt("phone"));
                    
                    borrowerList.add(borrower);
				
		}
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: Lỗi kết bối với bảng borrower" );
	}finally{
            dbc.closeConnection(conn);
        }	
	return borrowerList;
    }
        
        // tìm kiếm borrower theo từ khóa
        
    public ArrayList<Borrower> searchBorrowersByKeyword( String keyWordBorrower){
           
        String sql = "select * from borrower" + " where idborrower like '%"
                  + keyWordBorrower.trim()
                    + "%'"
                    + " or name like '%"
                    + keyWordBorrower.trim()
                    + "%'"
                    + " or email like '%"
                    + keyWordBorrower.trim()
                    + "%'"
                    + " or address like '%"
                    + keyWordBorrower.trim()
                    + "%'" 
                    + " or phone like '%"
                    + keyWordBorrower.trim()
                    + "%'";
            
        System.out.println(sql);
            
        try{
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Borrower  borrower = new Borrower();
                    
                borrower.setIdPerson(rs.getInt("idborrower"));
                borrower.setName(rs.getString("name"));
                borrower.setEmail(rs.getString("email"));
                borrower.setPassword(rs.getString("password"));
                borrower.setAddress(rs.getString("address"));
                borrower.setPhone(rs.getInt("phone"));
                    
                borrowerList.add(borrower);
				
                System.out.println("BookDAO " + borrower.getIdPerson() + " "  + borrower.getName());
				  
            }
                
            pstmt.close();
			
        } catch (SQLException e) {	
            System.out.println("Error: Tìm kiếm lỗi" );
            e.printStackTrace();
        }finally {
            dbc.closeConnection(conn);
        }

        return borrowerList;
    }
        
    public int insertBorrower(Borrower borrower){
        
        String sql = "insert into borrower(idborrower,name,email,password,address,phone) values(?,?,?,?,?,?)";
        String sql2 = "select idborrower from borrower";
        
        try{
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                if ( rs.getInt("idborrower") == borrower.getIdPerson()){
                    System.out.println("đã có id trong csdl");
                    return -1;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return 0;
              
        }
        
        try{
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, borrower.getIdPerson());
            pstmt.setString(2, borrower.getName());
            pstmt.setString(3, borrower.getEmail());
            pstmt.setString(4, borrower.getPassword());
            pstmt.setString(5, borrower.getAddress());
            pstmt.setInt(6, borrower.getPhone());
            
            int check =  pstmt.executeUpdate();
            
            if ( check != 0){
                System.out.println("Thêm borrower vào CSDL thành công");    
            }else{
                System.out.println("Thêm thất bại");
            }
            
            pstmt.close();
                 
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }finally{
            dbc.closeConnection(conn);
        }
        return 1;
        
    }
    
    public boolean deleteBorrower(int id){
        
        String sql = "delete from borrower where idborrower = ?";
        
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
    
    
    // đăng nhập
    
    public Borrower check(String email, String password){
        
        String sql = "select * from borrower where email = '" + email + "' and password = '" + password + "'";
        System.out.println(sql);
        //Borrower  borrower = new Borrower();
        //borrower = null;
    /*
        try {
                conn = dbc.getConnection();
                System.out.println("Kết nối đến borrower");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
                System.out.println("pstmt");
		ResultSet rs = pstmt.executeQuery();
                System.out.println("rs");
                
                while(rs.next()){
                System.out.println(rs.getInt("idborrower"));
                    borrower.setIdPerson(rs.getInt("idborrower"));
                    borrower.setName(rs.getString("name"));
                    borrower.setEmail(rs.getString("email"));
                    borrower.setPassword(rs.getString("password"));
                    borrower.setAddress(rs.getString("address"));
                    borrower.setPhone(rs.getInt("phone"));
                  
                }		
		
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: Lỗi kết bối với bảng borrower" );
            e.printStackTrace();
	}finally{
            dbc.closeConnection(conn);
        }
        System.out.println(borrower);
	return borrower;
    }
        */
        borrowerList = this.getInfoAllBorrower();
        
        for ( Borrower borrower: borrowerList){
            if(borrower.getEmail().equals(email) && borrower.getPassword().equals(password)){
                return borrower;
            }    
        }
        
        return null;
    }
    
    
    public void updateBorrower( Borrower borrower){
        String sql = "update borrower set "
                + "name = " + "'" + borrower.getName() + "',"
                + "email = " + "'" + borrower.getEmail() + "',"
                + "password = " + "'" + borrower.getPassword()+ "',"
                + "address = " + "'" + borrower.getAddress()+ "',"
                + "phone = " + "'" + borrower.getPhone() + "'"
                + " where idborrower = " + borrower.getIdPerson();
        System.out.println(sql);
        
        try {
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            System.out.println("lấy thông tin");
            pstmt = conn.prepareStatement(sql);
            pstmt.close();
            
        }catch(Exception e){
            System.out.println("Cap nhat loi");
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        } 

        
    }
         
}

   
    



    
    
    
	

        
                
			
	
