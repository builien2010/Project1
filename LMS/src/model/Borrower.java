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
	
	
	// printing Book's Information Borrowed by Borrower
	
	// in ra cac cuon sach ma hien tai nguoi do dang muon
	
	public void printBorrowedBooks() {
		if ( !borrowedBooks.isEmpty()) {
			System.out.println("\nCác cuốn sách đang mượn: ");
			
			for( int i = 0; i < borrowedBooks.size(); i++) {
				System.out.print(i + " - ");
				//borrowedBooks.get(i).getBook().printInfo();
			}
			
		}else
			System.out.println("Chưa mượn cuốn sách nào.");
	}
	
	
	// in ra tất cả thông tin yêu cầu mượn sách của borrower
	public void printOnHoldBooks() {
		
		
		if ( !onHoldBooks.isEmpty()) {
			
			System.out.println("Tất cả các yêu cầu mượn sách : ");
			System.out.println("  \t\tTitle\t\tAuthor\t\tSubject");
			
			for ( int i = 0; i < onHoldBooks.size(); i++) {
				System.out.print(i + " - " + "\t\t");
				onHoldBooks.get(i).print();
			}
			
		}else {
			System.out.println("Không có yêu cầu mượn sách nào! ");
		}
			
		
	}
	
	// cập nhật thông tin borrower
	public void updateBorrowerInfo() {
		// thay đổi tên , địa chỉ , email, số điện thoại
	}
	
	// mượn thêm 1 quyển sách , truyền vào phiếu mượn sách
	public void addBorrowerBook( Loan l) {
		borrowedBooks.add(l);
	}
	
	// xóa 1 quyển sách đã mượn
	public void removeBorrowedBook(Loan l) {
		borrowedBooks.remove(l);
	}
	
	// Thêm 1 yêu cầu mượn sách
	
	public void addHoldRequest ( HoldRequest hr) {
		onHoldBooks.add(hr);
	}
	
	// xóa 1 yêu cầu mượn sách
	
	public void removeHoldRequest(HoldRequest hr){
		onHoldBooks.remove(hr);
	}

	

	
	
	
}
