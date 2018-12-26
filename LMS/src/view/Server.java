/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lienb
 */
public class Server {
    
    private ServerSocket listener;
    public void startServer() throws IOException{
		listener = new ServerSocket(1998);
		while(true){
                    System.out.println("Server đang chạy");
			//tạo 1 cổng nghe.
			Socket socketOfServer = listener.accept();
			
			ClientThread ct = new ClientThread(socketOfServer);
                        // bắt đầu chạy ClientThread
			ct.start();
		}
	}
	public static void main(String[] args) throws IOException{
		new Server().startServer();
	}
    
}
