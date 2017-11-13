package tp1.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {

	public static void main(String[] args) {

		int serverPort = 8000;
		
		//Adresse IP
		InetAddress ipAddress = null;
		try {
			//ipAddress = InetAddress.getByName("localhost");
			ipAddress = InetAddress.getByName("172.18.13.240");
		} catch (UnknownHostException e1) {
			System.out.println("Unknow localhost");
			e1.printStackTrace();
		} 
		
		// Ecriture du message sur l'entree standard
		byte[] sendData = new byte[1024];
		Reader in = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(in);
		String sentence;
		try {
			sentence = bufferedReader.readLine();
			sendData = sentence.getBytes();
		} catch (IOException e1) {
			System.out.println("Error in line reading");
			e1.printStackTrace();
		}
		

		// Creer une socket UDP anonyme
		DatagramSocket clientSocket = null;
		try {
			clientSocket = new DatagramSocket();
			clientSocket.setSoTimeout(10000);
		} catch (SocketException e) {
			System.out.println("Unaible to create datagramSocket on client");
			e.printStackTrace();
		}
		
		// Creer un datagramme UDP contenant l'adresse et le port de la socket UDP du serveur 
		// et l'ordre a envoyer au panneau
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, serverPort);
		
		// Envoyer le datagramme via la socket UDP.
		try {
			clientSocket.send(sendPacket);
		} catch (IOException e) {
			System.out.println("Error : message sending failure on port 9999");
			e.printStackTrace();
		}
		
		// Message de reception
		byte[] receiveData = new byte[1024];
		
		// Créer un datagramme pour recevoir la réponse du serveur.
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		try {
			// Attendre sur la socket UDP la réception du datagramme envoyé par le serveur.
			clientSocket.receive(receivePacket);
			
		} catch (IOException e) {
			System.out.println("Error : message receiving failure from server.");
			e.printStackTrace();
		}
		
		// Afficher la chaîne contenue dans le datagramme envoyé par le serveur.
		String responseFromServer = new String(receivePacket.getData());
		System.out.println("FROM SERVER : "+responseFromServer);
		
		//Fermer la socket UDP.
		clientSocket.close();

	}

}
