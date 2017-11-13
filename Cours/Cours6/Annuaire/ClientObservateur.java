import java.rmi.RemoteException;

public class ClientObservateur extends java.rmi.server.UnicastRemoteObject
                               implements ObservateurRepertoire
{

	
	   protected ClientObservateur() throws RemoteException {
		super();
	}


	public void annoncerCreationPersonne (String nom) throws RemoteException
       {
		   System.out.println("Creation de" + nom);
       }
       

public void annoncerDestructionPersonne (String nom ) throws RemoteException
       {
	   System.out.println("Destruction de" + nom);	
       }

public void annoncerModificationPersonne (String nom) throws RemoteException
       {
	   System.out.println("Modification de" + nom);	
       }
	

	
	
 public static void main(String args[]) throws Exception
 {
	ClientObservateur obs = new ClientObservateur();
	
   // Obtenir la souche sur l’OD via l'annuaire RMI.
   RepertoireObserve rep = (RepertoireObserve)
           java.rmi.Naming.lookup("//localhost/"+args[0]);
   rep.ajouterObservateur(obs);
 }

}
