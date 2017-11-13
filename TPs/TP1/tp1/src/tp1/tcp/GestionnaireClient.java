package tp1.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import tp1.vue.IHM;

public class GestionnaireClient extends Thread {
	
	private Socket client;
	private IHM panneau;

	public GestionnaireClient(Socket client, IHM panneau){
		this.client = client;
		this.panneau = panneau;
		super.start();
	}

	public void run() {
		try{
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());

			boolean anotherMessage = true;
			while(anotherMessage){

				String clientOrder = inFromClient.readLine();

				if(clientOrder.startsWith("afficher")){
					panneau.ajouterLigne(clientOrder.substring("afficher".length()));
					outToClient.writeBytes("OK : Ordre execute\n");
				}else if(clientOrder.startsWith("effacer")){
					panneau.raz();
					outToClient.writeBytes("OK : Ordre execute\n");
				}else{
					outToClient.writeBytes("ERREUR : Ordre inconnu\n");
				}

				outToClient.writeBytes("Do another order ? yes:1 no:0\n");
				if(inFromClient.readLine().equals("0")){
					anotherMessage=false;
				}
			}
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}