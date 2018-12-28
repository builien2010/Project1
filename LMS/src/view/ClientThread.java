package view;

import control.BorrowerDAO;
import control.StaffDAO;
import control.BookDAO;
import control.HoldRequestDAO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Borrower;
import model.Staff;
import model.Book;
import model.HoldRequest;

public class ClientThread extends Thread{
	private Socket socketOfServer;
	private DataInputStream is;
	private DataOutputStream os;
	private boolean active;
	
	public ClientThread(Socket socketOfServer){
		this.socketOfServer = socketOfServer;
	}
	
        public void sendMSG(String data) throws IOException{
		os.writeUTF(data);
		os.flush();
	}
	
	public String getMSG() throws IOException{
		String name = is.readUTF();
		return name;
	}
        
        public void sendBook(Book book) throws IOException{
            sendMSG(String.valueOf(book.getIdbook()));
            sendMSG(book.getTitle());
            sendMSG(book.getSubject());
            sendMSG(book.getAuthor());
            sendMSG(String.valueOf(book.getQuantitySum()));
            sendMSG(String.valueOf(book.getQuantityBorrowed()));
            sendMSG(book.getStatus());
            
	}
	
	public void sendBorrower(Borrower borrower) throws IOException{
		sendMSG(String.valueOf(borrower.getIdPerson()));
		sendMSG(borrower.getName());
                sendMSG(borrower.getEmail());
                sendMSG(borrower.getPassword());
                sendMSG(borrower.getAddress());
                sendMSG(borrower.getPhone());
	}

	 
	public void run(){
            
            String request = null;
            String respone = null;
            
            try {
                is = new DataInputStream(socketOfServer.getInputStream());
                System.out.println("is" + is);
		os = new DataOutputStream(socketOfServer.getOutputStream());
                System.out.println("os" + os);
            } catch (Exception e) {
		e.printStackTrace();
            }
            
            while(!active){	
			
                try {
                    request = is.readUTF();
                    System.out.println("request: " + request);
		} catch (Exception e) {
                    e.printStackTrace();
		}
                
		if(request.equals("login")){
                    try {
                        
			String email = is.readUTF();
                        System.out.println("email: " + email);
			String password = is.readUTF();
                        System.out.println("password" + password);
			
                        Borrower borrower = new Borrower();
                        borrower = null;
                        borrower = (new BorrowerDAO()).check(email, password);
                        if ( borrower != null){
                            respone = "borrower";
                            System.out.println("respone: " + respone);
                            
                        }else{
                            Staff staff = new Staff();
                            staff = (new StaffDAO()).check(email, password);
                            if ( staff != null){
                                respone = "admin";
                                System.out.println("respone: " + respone);
                            }
                            else{
                                respone = "fail";
                                System.out.println("respone: " + respone);
                            }
                            
                        }
                        
                    } catch (Exception e) {
			e.printStackTrace();
                    }
                    
                    if(!respone.equals("fail")){
                        try {
                            active = true;
                            sendMSG(respone);
                        } catch (Exception e) {
				e.printStackTrace();
                        }
                    }else{
			try {
                            sendMSG(respone);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                    
                }
                
                if ( request.equals("signup")){
                    try{
                        String name = is.readUTF();
                        String email = is.readUTF();
                        String password = is.readUTF();
                        String address = is.readUTF();
                        String phone = is.readUTF();
                        
                        Borrower borrower = new Borrower(name, email, password, address, phone);
                        int check = (new BorrowerDAO()).insertBorrower(borrower);
                        
                        
                        if( check == 1){
                            sendMSG("signupsuccess");
                            borrower = (new BorrowerDAO()).check(email, password);
                            sendBorrower(borrower);
                        }else{
                            sendMSG("signupfail");
                        }
                            
                        
                        
                        
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
			
			
            }
            
            if (respone.equals("borrower")){
                while(active){
                    try{
                        request = getMSG();
                    }catch(Exception e){
                        e.printStackTrace();
                    
                    }
                    
                    ArrayList<Book> bookList = new ArrayList<>();
                    
                    if( request.equals("showBook")){
                        bookList = (new BookDAO()).getInfoAllBook();
                        
                        for(Book book: bookList){
                            try {
                                sendMSG("book");
                                sendBook(book);
                            } catch (IOException ex) {
                                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        try{
                            sendMSG("done");
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    
                    if( request.equals("holdRequest")){
                        try {
                            int idborrower = Integer.parseInt(is.readUTF());
                            System.out.println("idborrower" + idborrower);
                            
                            int idbook= Integer.parseInt(is.readUTF());
                            System.out.println("idbook" + idbook);
                            String date = is.readUTF();
                            Date requestDate = Date.valueOf(date);
                            
                            
                            Borrower borrower = new Borrower();
                            Book book = new Book();
                            HoldRequest holdRequest = new HoldRequest(borrower, book);
                            
                            holdRequest.getBorrower().setIdPerson(idborrower);
                            holdRequest.getBook().setIdbook(idbook);
                            holdRequest.setRequestDate(requestDate);
                            
                            int check = (new HoldRequestDAO()).insertHoldRequest(holdRequest);
                            
                            if ( check == 1){
                                sendMSG("holdsuccess");
                            }
                            else{
                                sendMSG("holdfail");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
            if ( respone.equals("admin")){
                while(active){
                    
                    try{
                        request = getMSG();   
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                    ArrayList<Borrower> borrowerList = new ArrayList<>();
                    ArrayList<Book> bookList = new ArrayList<>();
                    
                    if(request.equals("showBook")){
                        try {
                            bookList = (new BookDAO()).getInfoAllBook();
                            
                            for ( Book book : bookList){
                                try {
                                    sendMSG("book");
                                    sendBook(book);
                                } catch (IOException ex) {
                                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                                    
                            sendMSG("done");
                        } catch (IOException ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    
                }
            }
		
        }
}
