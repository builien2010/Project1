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
	
	protected int idbook;
	protected String title;
	protected String subject;
	protected String author;
	protected int quantitySum;
        protected int quantityBorrowed;
	protected String status;	// true if the book is currently issued to some borrower
		// record of all hold request on that book

	
	public Book() {
		
	}
	
	public Book(int idbook, String title, String subject, String author,int quantitySum, int quantityBorrowed, String state) {
            this.idbook = idbook;
            this.title = title;
            this.subject = subject;
            this.author = author;
            this.quantitySum = quantitySum;
            this.quantityBorrowed = quantityBorrowed;
            this.status = state;	
			
	}
	
	public int getIdbook() {
		return idbook;
	}


	public void setIdbook(int idbook) {
		this.idbook = idbook;
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
	
	public int getQuantitySum() {
		return quantitySum;
	}
	
	public void setQuantitySum(int quantitySum) {
		this.quantitySum = quantitySum;
	}

        
        public int getQuantityBorrowed(){
            return quantityBorrowed;
        }
        
        public void setQuantityBorrowed( int quantityBorrowed){
            this.quantityBorrowed = quantityBorrowed;
        }


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


