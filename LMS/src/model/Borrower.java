// done

package model;

import java.util.ArrayList;

public class Borrower extends Person{
    

	private ArrayList<Loan> borrowedBooks;		// danh sách các phiếu mượn sách ( mỗi phiếu gắn với 1 cuốn sách )
	private ArrayList<HoldRequest> onHoldBooks;	// danh sách các yêu cầu mượn sách
	
	public Borrower( String name, String email, String password, String address, String phone) {
		super(name, email, password, address, phone);
		borrowedBooks = new ArrayList<>();
		onHoldBooks = new ArrayList<>();
	}

    public Borrower() {
        super();
    }
    
    public Borrower( int id,String name, String email, String password, String address, String phone) {
		super(id,name, email, password, address, phone);
		borrowedBooks = new ArrayList<>();
		onHoldBooks = new ArrayList<>();
	}

    
    

	public ArrayList<Loan> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Loan> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public ArrayList<HoldRequest> getOnHoldBooks() {
		return onHoldBooks;
	}

	public void setOnHoldBooks(ArrayList<HoldRequest> onHoldBooks) {
		this.onHoldBooks = onHoldBooks;
	}
	
	
	
	
	
	

	
	
	
}
