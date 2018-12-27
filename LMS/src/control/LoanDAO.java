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
import model.Loan;
import model.Borrower;
import model.Book;
import model.Staff;

/**
 *
 * @author lienb
 */
public class LoanDAO {
    static Connection conn = null;
    DBConnection dbc = new DBConnection();
    PreparedStatement pstmt = null;
    private ArrayList<Loan> loanList = new ArrayList<>();
        
    public LoanDAO(){
       // conn = dbc.getConnection();
        System.out.println("Kết nối đến loan");
    }

    // lấy thông tin tất cả các sách
    public ArrayList<Loan> getInfoAllLoan() {
        
	String sql = "select * from loan inner join borrower on loan.idborrower = borrower.idborrower "
                + "inner join staff on loan.idissuer = staff.idstaff "
                +  "inner join staff staff2 on loan.idreceiver = staff2.idstaff " 
                + "inner join book on loan.idbook = book.idbook";
	try {
                conn = dbc.getConnection();
                System.out.println("Kết nối đến loan");
		System.out.println("lấy thông tin");
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
                    
                    Loan loan = new Loan();
                    Borrower borrower = new Borrower();
                    Book book = new Book();
                    Staff issuer = new Staff();
                    Staff receiver = new Staff();
                    
                    loan.setIdLoan(rs.getInt("idloan"));
                   
                    borrower.setIdPerson(rs.getInt("idborrower"));
                    borrower.setName(rs.getString("borrower.name"));
                    borrower.setEmail(rs.getString("borrower.email"));
                    borrower.setPassword(rs.getString("borrower.password"));
                    borrower.setAddress(rs.getString("borrower.address"));
                    borrower.setPhone(rs.getString("borrower.phone"));
                    
                    loan.setBorrower(borrower);
                    book.setIdbook (rs.getInt("idbook"));
                    book.setTitle(rs.getString("title"));
                    book.setSubject(rs.getString("subject"));
                    book.setAuthor(rs.getString("author"));
                    book.setQuantitySum(rs.getInt("quantitySum"));
                    book.setQuantityBorrowed(rs.getInt("quantityBorrowed"));
                    book.setStatus(rs.getString("status"));
                    loan.setBook(book);
                    
                    issuer.setIdPerson(rs.getInt("staff.idstaff"));
                    issuer.setName(rs.getString("staff.name"));
                    issuer.setEmail(rs.getString("staff.email"));
                    issuer.setPassword(rs.getString("staff.password"));
                    issuer.setAddress(rs.getString("staff.address"));
                    issuer.setPhone(rs.getString("staff.phone"));
                    issuer.setSalary(rs.getDouble("staff.salary"));
                    loan.setIssuer(issuer);
                    
                    receiver.setIdPerson(rs.getInt("staff2.idstaff"));
                    receiver.setName(rs.getString("staff2.name"));
                    receiver.setEmail(rs.getString("staff2.email"));
                    receiver.setPassword(rs.getString("staff2.password"));
                    receiver.setAddress(rs.getString("staff2.address"));
                    receiver.setSalary(rs.getDouble("staff2.salary"));
                    loan.setReceiver(receiver);
                    
                    loan.setIssuedDate(rs.getDate("issueddate"));
                    loan.setReturnedDate(rs.getDate("returneddate"));
                    loan.setFinePaid(rs.getDouble("finepaid"));
                    
                    loanList.add(loan);
				
		}
                        
                pstmt.close();		
	} catch (SQLException e) {		
            System.out.println("Error: LOanDao" );
            e.printStackTrace();
	}finally{
            dbc.closeConnection(conn);
        }	
        
        for ( Loan loan: loanList){
            System.out.println(loan.getIdLoan() + loan.getBorrower().getName());
        }
	return loanList;
    }
        
    
}
