package builien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public void serve(){
		System.out.println("Server đang chạy.......");
		try {
			ServerSocket server = new ServerSocket(1998);
			Socket socket = server.accept();
			
			
			//Receive from Client
			BufferedReader br = new BufferedReader(new InputStreamReader ( socket.getInputStream()));
			
			String request  = br.readLine();
			
			if ( request != null) {
				System.out.println("Server nhận yêu cầu từ client : " + request);
				//Select database , calculator, ...
				//Response to client
				
				PrintStream ps = new PrintStream(socket.getOutputStream());
				
				ps.println(request.toUpperCase());
				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		Server server = new Server();
		server.serve();
	}

}
