public interface Repertoire extends java.rmi.Remote
{

  public boolean ajouterPersonne (Personne personne)
                   throws java.rmi.RemoteException;

  public boolean modifierPersonne (Personne personne)
                   throws java.rmi.RemoteException;


  public boolean retirerPersonne (String nom)
                   throws java.rmi.RemoteException;


  public Personne chercherPersonne (String nom)
                   throws java.rmi.RemoteException;


  public String[] listerPersonnes ()
                   throws java.rmi.RemoteException;

}
