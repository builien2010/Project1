/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HoldRequest;
import model.Book;
import model.Borrower;
/**
 *
 * @author lienb
 */
public class HoldRequestDAO {
    
    
    static Connection conn = null;
    DBConnection dbc = new DBConnection();
    PreparedStatement pstmt = null;
    private ArrayList<HoldRequest> holdRequests = new ArrayList<>();
        
    

    // lấy thông tin tất cả các sách
    public ArrayList<HoldRequest> getInfoAllRequest(int id) {
        
	String sql = "select * from holdrequest where idborrower = " + id + "";
	try {
                conn = dbc.getConnection();
                 System.out.println("Kết nối đến holdRequest");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
                    
                    HoldRequest holdRequest = new HoldRequest();
                    holdRequest.setIdborrower(rs.getInt("idborrower"));
                    holdRequest.setBook(rs.getInt("idbook"));
                    holdRequest.setRequestDate(rs.getDate("requestdate"));
                    
                    

                    holdRequests.add(holdRequest);
				
		}
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: Kết nối bookDao lỗi" );
            e.printStackTrace();
	}finally{
            dbc.closeConnection(conn);
        }	
	return holdRequests;
    }
    
     public int insertHoldRequest(HoldRequest holdRequest){
        
        String sql = "insert into holdrequest(idborrower,idbook,requestdate) values(?,?,?)";
        int check = 0;
        
        try{
            conn = dbc.getConnection();
             System.out.println("Kết nối đến holdrequest");
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setInt( 1, holdRequest.getIdborrower());
            pstmt.setInt( 2, holdRequest.getBook());
            pstmt.setDate(3,holdRequest.getRequestDate());
            
            check =  pstmt.executeUpdate();
            
            if ( check != 0){
                System.out.println("Thêm holdrequest vào CSDL thành công");    
            }else{
                System.out.println("Thêm holdrequest thất bại");
            }
            
            pstmt.close();
                 
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            dbc.closeConnection(conn);
        }
        
        return check;
        
    }
    
}
