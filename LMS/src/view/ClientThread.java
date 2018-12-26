package view;

import control.BorrowerDAO;
import control.StaffDAO;
import control.BookDAO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Borrower;
import model.Staff;
import model.Book;

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
                            } catch (IOException ex) {
                                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
		
        }
}
