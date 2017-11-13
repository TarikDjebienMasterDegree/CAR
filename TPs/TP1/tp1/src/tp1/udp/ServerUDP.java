package tp1.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import tp1.vue.IHM;

public class ServerUDP {
	
	public static void main(String[] args) {
		
		// Instancier la classe IHM du panneau d’affichage électronique.
		IHM ihm = new IHM("Panneau d'affichage");
		IHM.mettreListenerSortieProgramme(ihm);
		
		// Afficher ce panneau d’affichage.
		ihm.setVisible(true);
		
		// Créer une socket UDP sur le port 8000 (par exemple).
		int serverPort = 8000;
		DatagramSocket serverSocket = null;
		try{
			serverSocket = new DatagramSocket(serverPort);
		}catch (SocketException se){
			System.out.println("Unaible to create datagramSocket on server");
			se.printStackTrace();
		}
		
		byte[] receiveData = new byte[1024];
		
		// Dans une boucle infinie :
		while(true){
			
			// Créer un datagramme UDP.
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			
			try {
				// Attendre la réception de ce datagramme via la socket créée.
				serverSocket.receive(receivePacket);
			} catch (IOException e) {
				System.out.println("Error : message receiving failure from client.");
				e.printStackTrace();
			}
			
			// Transformer le datagramme reçu en une chaîne de caractères qui contiendra l’ordre demandé par le client distant.
			String sentence = new String(receivePacket.getData());
			
			// Traiter l’ordre reçu en fonction de son contenu :
			String serverState = null;
			
			// Si l’ordre commence par la chaîne « afficher » 
			if(sentence.startsWith("afficher")){
				// alors ajouter au panneau d’affichage la fin de la chaîne contenant l’ordre.
				ihm.ajouterLigne(sentence.substring("afficher".length()));
				// « OK : Ordre exécuté »
				serverState = "OK : Ordre exécuté";
			}else
			
			// Si l’ordre commence par la chaîne « effacer » 
			if(sentence.startsWith("effacer")){
				// alors effacer le panneau d’affichage.
				ihm.raz();
				serverState = "OK : Ordre exécuté";
			}else{
			
			// Si l’ordre contient autre chose alors c’est une erreur.
				serverState = "ERREUR : Ordre inconnu";
			}
			
			// Construire une chaîne contenant la réponse du serveur
			byte[] sendData = new byte[1024];
			sendData = serverState.getBytes();
			
			// Créer un datagramme contenant la réponse au client.
			int clientPort = receivePacket.getPort();
			InetAddress clientIp = receivePacket.getAddress();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIp, clientPort);
			
			// Envoyer le datagramme à la socket UDP du client.
			try {
				serverSocket.send(sendPacket);
			} catch (IOException e) {
				System.out.println("Error : message sending failure from server to client ("+clientIp+") on port "+clientPort);
				e.printStackTrace();
			}
		}
	}
	
}
