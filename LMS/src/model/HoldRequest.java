// done 

package model;

import java.sql.Date;


public class HoldRequest {
	
	int idborrower;
	int idbook;
	Date requestDate;
	
        public HoldRequest(){
        }
	public HoldRequest(int borrower, int book, Date requestDate) {
		this.idborrower = borrower;
		this.idbook = book;
		this.requestDate = requestDate;
	}
        
        public HoldRequest(int borrower, int book){
                this.idborrower = borrower;
		this.idbook = book;
		
	}

	public int getIdborrower() {
		return idborrower;
	}

	public void setIdborrower(int idborrower) {
		this.idborrower = idborrower;
	}

	public int getBook() {
		return idbook;
	}

	public void setBook(int book) {
		this.idbook = book;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	//Print Hold Request Information
	
    

}
