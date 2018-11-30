package model;

import java.util.ArrayList;

public class Library {

	private String name;
	private ArrayList <Person> persons;
	private ArrayList <Book> booksInLibrary;
	
	private ArrayList <Loan> loans;
	
	public int book_return_deadline;		// số ngày lớn nhất phải tả sách : ví dụ , mượn sách sau tối đa 5 ngày là phải trả
	
	public double per_day_fine;				// tiền phạt tính theo ngày, ví dụ cứ quá hạn thêm 1 ngày mất  10k
	
	public int hold_request_expiry;
	
	private static Library obj;
	
	// Singleton
	public static Library getInstance() {
		if( obj == null) {
			obj = new Library();
		}
		
		return obj;
	}
	
	// constructor để private
	private Library() {
		name = null;
		persons = new ArrayList<>();
		booksInLibrary = new ArrayList<>();
		loans = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public ArrayList<Book> getBooksInLibrary() {
		return booksInLibrary;
	}

	public void setBooksInLibrary(ArrayList<Book> booksInLibrary) {
		this.booksInLibrary = booksInLibrary;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public int getBook_return_deadline() {
		return book_return_deadline;
	}

	public void setBook_return_deadline(int book_return_deadline) {
		this.book_return_deadline = book_return_deadline;
	}

	public double getPer_day_fine() {
		return per_day_fine;
	}

	public void setPer_day_fine(double per_day_fine) {
		this.per_day_fine = per_day_fine;
	}

	public int getHold_request_expiry() {
		return hold_request_expiry;
	}

	public void setHold_request_expiry(int hold_request_expiry) {
		this.hold_request_expiry = hold_request_expiry;
	}

	public static Library getObj() {
		return obj;
	}

	public static void setObj(Library obj) {
		Library.obj = obj;
	}
	
}

