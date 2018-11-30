// done 

package model;

import java.util.Date;

public class HoldRequest {
	
	Borrower borrower;
	Book book;
	Date requestDate;
	
	public HoldRequest(Borrower borrower, Book book, Date requestDate) {
		this.borrower = borrower;
		this.book = book;
		this.requestDate = requestDate;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	//Print Hold Request Information
	
	public void print() {
		System.out.println(book.getTitle() + "\t\t\t\t" + borrower.getName() + "\t\t\t\t" + requestDate + "\n");
	}

}
