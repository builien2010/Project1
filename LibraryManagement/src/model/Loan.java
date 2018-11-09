// done

package model;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Loan {
	
	private Borrower borrower;
	private Book book;
	
	private Staff issuer;
	private Date issuedDate;
	
	private Staff receiver;
	private Date returnedDate;
	
	private boolean finePaid;

	public Loan(Borrower borrower, Book book, Staff issuer, Date issuedDate, Staff receiver, Date returnedDate,
			boolean finePaid) {
		super();
		this.borrower = borrower;
		this.book = book;
		this.issuer = issuer;
		this.issuedDate = issuedDate;
		this.receiver = receiver;
		this.returnedDate = returnedDate;
		this.finePaid = finePaid;
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

	public Staff getIssuer() {
		return issuer;
	}

	public void setIssuer(Staff issuer) {
		this.issuer = issuer;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Staff getReceiver() {
		return receiver;
	}

	public void setReceiver(Staff receiver) {
		this.receiver = receiver;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public boolean isFinePaid() {
		return finePaid;
	}

	public void setFinePaid(boolean finePaid) {
		this.finePaid = finePaid;
	}
	
	// compute fine for a particular loan only
	// chỉ tính tiền cho các khoản vay cụ thể
	// chỉ tính tiền cho 1 phiếu mượn
	
	public double computeFine1() {
		double totalFine = 0;
		
		if ( !finePaid) {
			Date iDate = issuedDate;
			Date rDate = new Date();		// ngày hiện tại : ngày trả 
			
			// tính số ngày khi biết mượn sách và ngày hiện tại
			long days = ChronoUnit.DAYS.between(rDate.toInstant(), iDate.toInstant());
			days = 0 - days;
			
			// tính xem đã vượt qua số ngày trả sách chưa
			days = days - Library.getInstance().book_return_deadline;
			
			if ( days > 0)
				totalFine = days * Library.getInstance().per_day_fine;
			else
				totalFine = 0;
			
		}
		
		return totalFine;
	}

	// trả tiền phạt
	public void payFine() {	
		
		double totalFine = computeFine1();
		if ( totalFine > 0) {
			System.out.println("Tổng số tiền phạt phải trả là : " + totalFine);
			System.out.println("Bạn có muốn trả không ? ( y/n) : ");
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();
			
			if ( choice.equals("y") || choice.equals("Y"))
				finePaid = true;
			if ( choice.equals("n") || choice.equals("N"))
				finePaid = false;
					
		}else {
			
			System.out.println("Bạn không phải trả tiền nợ !");
			finePaid = true;
		}	
		
	}
	
	// mở rộng ngày mượn sách, gia hạn : nhập ngày gia hạn : ngày mượn đc cập nhật thành ngày gia hạn
	
	public void renewIssuedBook(Date date) {
		issuedDate = date;
		System.out.println("Cuốn sách " + book.getTitle() + " đã được gia hạn thành công");	
		
	}
	
}
	
