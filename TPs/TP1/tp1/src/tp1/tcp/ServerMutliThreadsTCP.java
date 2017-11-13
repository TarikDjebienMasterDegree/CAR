package tp1.tcp;

import java.net.ServerSocket;
import java.net.Socket;

import tp1.vue.IHM;

public class ServerMutliThreadsTCP {

	public static void main(String[] args) throws Exception {

		IHM panneau = new IHM("TCP exercice2");
		IHM.mettreListenerSortieProgramme(panneau);
		panneau.setVisible(true);

		int port = 6789;
		ServerSocket serverSocket = new ServerSocket(port);

		while(true){
			Socket connectionTCP = serverSocket.accept();
			new GestionnaireClient(connectionTCP, panneau);
		}
		
	}


}
