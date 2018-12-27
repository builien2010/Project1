package control;

import static control.BorrowerDAO.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Borrower;

import model.Staff;

public class StaffDAO{
   
    static Connection conn = null;
    DBConnection dbc = new DBConnection();
    PreparedStatement pstmt = null;
    private ArrayList<Staff> staffList = new ArrayList<>();
        
    public StaffDAO(){
       // conn = dbc.getConnection();
        System.out.println("Kết nối đến bảng staff");
    }

    // lấy tất cả thông tin của các đọc giả
    public ArrayList<Staff> getInfoAllStaff() {
        
	String sql = "select * from staff";
	try {
                conn = dbc.getConnection();
                System.out.println("Kết nối đến staff");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
             
                    Staff  staff = new Staff();
                    
                    staff.setIdPerson(rs.getInt("idstaff"));
                    staff.setName(rs.getString("name"));
                    staff.setEmail(rs.getString("email"));
                    staff.setPassword(rs.getString("password"));
                    staff.setAddress(rs.getString("address"));
                    staff.setPhone(rs.getString("phone"));
                    staff.setSalary(rs.getDouble("salary"));
                    
                    staffList.add(staff);
				
		}
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: Lỗi kết bối với bảng staff" );
	}finally{
            dbc.closeConnection(conn);
        }	
	return staffList;
    }
        
        // tìm kiếm staff theo từ khóa
        
    public ArrayList<Staff> searchStaffsByKeyword( String keyWordStaff){
           
        String sql = "select * from staff" + " where idstaff like '%"
                  + keyWordStaff.trim()
                    + "%'"
                    + " or name like '%"
                    + keyWordStaff.trim()
                    + "%'"
                    + " or email like '%"
                    + keyWordStaff.trim()
                    + "%'"
                    + " or address like '%"
                    + keyWordStaff.trim()
                    + "%'" 
                    + " or phone like '%"
                    + keyWordStaff.trim()
                    + "%'"
                    + " or salary like '%"
                    + keyWordStaff.trim()
                    +"%'";
        
                    
            
        System.out.println(sql);
            
        try{
            conn = dbc.getConnection();
            System.out.println("Kết nối đến staff");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Staff  staff = new Staff();
                    
                staff.setIdPerson(rs.getInt("idstaff"));
                staff.setName(rs.getString("name"));
                staff.setEmail(rs.getString("email"));
                staff.setPassword(rs.getString("password"));
                staff.setAddress(rs.getString("address"));
                staff.setPhone(rs.getString("phone"));
                staff.setSalary(rs.getDouble("salary"));
                
                staffList.add(staff);
				
               
				  
            }
                
            pstmt.close();
			
        } catch (SQLException e) {	
            System.out.println("Error: Tìm kiếm lỗi" );
            e.printStackTrace();
        }finally {
            dbc.closeConnection(conn);
        }

        return staffList;
    }
        
    public int insertStaff(Staff staff){
        
        String sql = "insert into staff(idstaff,name,email,password,address,phone,salary) values(?,?,?,?,?,?,?)";
         
        try{
            conn = dbc.getConnection();
            System.out.println("Kết nối đến staff");
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, staff.getIdPerson());
            pstmt.setString(2, staff.getName());
            pstmt.setString(3, staff.getEmail());
            pstmt.setString(4, staff.getPassword());
            pstmt.setString(5, staff.getAddress());
            pstmt.setString(6, staff.getPhone());
            pstmt.setDouble(7, staff.getSalary());
            
            int check =  pstmt.executeUpdate();
            
            if ( check != 0){
                System.out.println("Thêm staff vào CSDL thành công");    
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
    
    public boolean deleteStaff(int id){
        
        String sql = "delete from staff where idstaff = ?";
        
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
    
    public Staff check(String email, String password){
        
        String sql = "select * from staff where email = '" + email + "' and password = '" + password + "'";
        System.out.println(sql);
        /*
        Staff  staff = new Staff();
        
    
        try {
                conn = dbc.getConnection();
                System.out.println("Kết nối đến staff");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
                System.out.println("pstmt");
		ResultSet rs = pstmt.executeQuery();
                System.out.println("rs");
                
                while(rs.next()){
                    staff.setIdPerson(rs.getInt("idstaff"));
                    staff.setName(rs.getString("name"));
                    staff.setEmail(rs.getString("email"));
                    staff.setPassword(rs.getString("password"));
                    staff.setAddress(rs.getString("address"));
                    staff.setPhone(rs.getInt("phone"));
                    staff.setSalary(rs.getDouble("salary"));
                  
                }		
		
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: Lỗi kết bối với bảng staff" );
            e.printStackTrace();
	}finally{
            dbc.closeConnection(conn);
        }	
	return staff;

*/
        staffList = this.getInfoAllStaff();
        
        for ( Staff staff: staffList){
            if(staff.getEmail().equals(email) && staff.getPassword().equals(password)){
                return staff;
            }    
        }
        
        return null;
    }
    
    public int countStaff(){
        String sql = "select count(*) from borrower";
        
        int count = 0;
        try {
            conn = dbc.getConnection();
            System.out.println("Kết nối đến borrower");
            System.out.println("lấy thông tin");
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                count = Integer.parseInt(rs.getString(1));
}
            System.out.println("Tổng số lượng nhân viên là: " + count);
            
            //count = rs.getInt("count(*)");
            
            pstmt.close();
            
        }catch(Exception e){
            System.out.println("Tính tổng số lượng sách lỗi");
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        } 
        
        return count;

        
    }
}
    
    
    
	

        
                
			
	

