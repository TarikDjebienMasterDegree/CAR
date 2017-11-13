package tp1.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTCP {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		int portClient = 6789;
		Socket clientSocket = new Socket("localhost",portClient);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String request = inFromUser.readLine();
		
		outToServer.writeBytes(request+"\n");
		
		String response = inFromServer.readLine();
		
		System.out.println("FROM SERVER : "+response);
		
		clientSocket.close();
	}

}
