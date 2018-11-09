// Còn method cho mượn sách nữa là xong

package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Book {
	
	protected int bookId;
	protected String title;
	protected String subject;
	protected String author;
	protected boolean isIssued;	// true if the book is currently issued to some borrower
	protected ArrayList<HoldRequest> holdRequests; 	// record of all hold request on that book
													// hồ sơ của tất cả yêu cầu lưu giữ trên cuốn sách đó
	
	
	static int currentIdNumber = 0;
	
	public Book(int id, String title, String subject, String author, boolean isIssued) {
		currentIdNumber++;	
		if( id == - 1) {
			bookId = currentIdNumber;
		}else {
			bookId = id;
		}
		
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.isIssued = isIssued;
		
		holdRequests = new ArrayList<>();
		
			
	}
	
	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public boolean isIssued() {
		return isIssued;
	}



	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}



	public ArrayList<HoldRequest> getHoldRequests() {
		return holdRequests;
	}



	public void setHoldRequest(ArrayList<HoldRequest> holdRequests) {
		this.holdRequests = holdRequests;
	}



	public static int getCurrentIdNumber() {
		return currentIdNumber;
	}



	public static void setCurrentIdNumber(int currentIdNumber) {
		Book.currentIdNumber = currentIdNumber;
	}



	// adding a hold request
	public void addHoldRequest( HoldRequest hr) {
		holdRequests.add(hr);
	}
	
	// removing a hold request
	
	public void removeHoldRequest() {
		if( !holdRequests.isEmpty()) {
			holdRequests.remove(0);
		}
	}
	
	// printing all hold request on a book
	public void printHoledRequests() {
		if( !holdRequests.isEmpty()) {
			System.out.println("\nHold Requests are: ");
			System.out.println("----------------------------------");
			System.out.println("No.\t\tBook's Title\t\tStudent's Name\t\tRequest Date");
			System.out.println("-------------------------------");
			
			for ( int i = 0; i < holdRequests.size(); i++) {
				System.out.print(i + "-" + "\t\t");
				holdRequests.get(i).print();
			}
		
		}else {
			System.out.println("No Holed Request.");
		}
		
	}
	
	
	// printing book's information
	public void printInfo(){
		System.out.println(title + "\t\t" + author + "\t\t" + subject);
	}
	
	// changing information of a book
	public void changeBookInfo() throws IOException{
		Scanner scanner = new Scanner(System.in);
		String input;
		
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("\nUpdate Author? (y/n)");
		input = scanner.next();
		
		if ( input.equals("y")) {
			System.out.println("Enter new Author: ");
			author = reader.readLine();
		}
		
		System.out.println("\nUpdate Subject? (y/n)");
		input = scanner.next();
		
		if ( input.equals("y")) {
			System.out.println("Enter new Subject: ");
			author = reader.readLine();
		}
		
		System.out.println("\nUpdate Title? (y/n)");
		input = scanner.next();
		
		if ( input.equals("y")) {
			System.out.println("Enter new Title: ");
			author = reader.readLine();
		}
		
	}
	
	
	// placing book on Hold
	public void placeBookOnHold(Borrower borrower) {
		
		HoldRequest hr = new HoldRequest(borrower, this, new Date());
		
		addHoldRequest(hr);
		borrower.addHoldRequest(hr);
		
		System.out.println("The book " + title + "has bean successfully placed on hold by borrower " + borrower.getName() + "\n");	
	}
	
	// Request for holding a book
	// Borrower đến yêu cầu mượn một cuốn sách 
	public void makeHoldRequest( Borrower borrower) {
		
		boolean makeRequest = true;
		/*
		 * If that borrower has already borrowed that particular book.
		 * Then he isn't allowed to make request for that book
		 * He will have to renew the issued book in order to extend the return deadline.
		 * 
		 * Nếu borrower đã mượn cuốn sách đó thì ko đc phép yêu cầu cuốn sách đó nữa 
		 * mà phải gia hạn thời gian trả lại của cuốn sách đã mượn
		 */
		
		for ( int i = 0; i < borrower.getBorrowedBooks().size(); i++) {
			
			if ( borrower.getBorrowedBooks().get(i).getBook() == this) {
				System.out.println("\nYou have already borrowed " + title);
				return;
			}
			
		}
		
		/*
		 * If that borrower has already requested for that particular book
		 * Then he isn't allowed to make the same request again
		 * 
		 * Nếu borrower đã yêu cầu cuốn sách đó, thì sau đó ko đc phép yêu cầu lại
		 * 
		 */
		
		
		for ( int i = 0; i < holdRequests.size(); i++) {
			
			if ( holdRequests.get(i).getBorrower() == borrower) {
				makeRequest = false;
				break;
			}
		}
		
		if (makeRequest) {
			placeBookOnHold(borrower);
		}else {
			System.out.println("You already have one hold request for this book.\n");	
		}
			
	}
	
	
	// Getting information of a hold request
	// Thông tin về yêu cầu
	
	public void serviceHoldRequest ( HoldRequest hr) {
		
		removeHoldRequest();
		//hr.getBorrower().removeHoldRequest(hr);
	}
	
	// Issuing a Book
	// Mượn 1 cuốn sách : chưa xong
	
	public void issueBook ( Borrower borrower , Staff staff) {
		
		// First deleting the expired hold requests
		// Xóa các yêu lưu trữ đã hết hạn
		
		Date today = new Date();
		
		ArrayList <HoldRequest> hRequests = holdRequests;
		
		for ( int i = 0; i < hRequests.size(); i++) {
			
			HoldRequest hr = hRequests.get(i);
			
			// Remove that hold request which has expired
			// Xóa yêu cầu lưu giữ hết hạn
			
			long days = ChronoUnit.DAYS.between(today.toInstant(), hr.getRequestDate().toInstant());
			
			days = 0 - days;	// chuyển thành số ngày dương
			
			if ( days > Library.getInstance().getHold_request_expiry()) {
				removeHoldRequest();
				hr.getBorrower().removeHoldRequest(hr);
			}
				
		}
		
		if ( isIssued) {
			System.out.println("The book " + title + " is already issued.");
			System.out.println("Would you like to place book on hold ? ( y/n) ");
			
			Scanner sc = new Scanner( System.in);
			String choice = sc.next();
		
			if ( choice.equals("y")){
				makeHoldRequest(borrower);
			}
		}else {
			
			if ( ! holdRequests.isEmpty()) {
				boolean hasRequest = false;
				
				for ( int i = 0; i < holdRequests.size() && !hasRequest ; i++) {
					
					if ( holdRequests.get(i).getBorrower() == borrower)
						hasRequest = true;
				}
				
				if ( hasRequest ) {
					
					// If this particular borrower has the earliest request for this book
					// Nếu người vay cụ thể có yêu cầu sớm nhất cho cuốn sách này
					
					if ( holdRequests.get(0).getBorrower() == borrower)
						serviceHoldRequest(holdRequests.get(0));
					else {
						// Rất tiếc , một số người dùng khác đã yêu cầu sách này sớm hơn bạn. Vì vậy , bạn phải đợi cho đến khi yêu cầu giữ của họ được xử lí
						System.out.println("Sorry some other users have requested for this book than you. So you have to wait until their hold requests are processed");
						return;
					}
					
				}else {
					
				}
			}
		}
	
	}
	
	// Returning a Book
	public void returnBook( Borrower borrower, Loan loan, Staff staff) {
		
		loan.getBook().setIssued(false);
		loan.setReturnedDate(new Date());
		loan.setReceiver(staff);
		
		borrower.removeBorrowedBook(loan);
		
		loan.payFine();
		
		System.out.println("\nThe book " + loan.getBook().getTitle() + " is successfully returned by " + borrower.getName() + " .");
		System.out.println("\nReceived by : " + staff.getName());
		
	}
	
	
	
	
	
	

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


