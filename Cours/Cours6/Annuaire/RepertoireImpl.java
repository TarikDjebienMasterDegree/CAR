public class RepertoireImpl extends java.rmi.server.UnicastRemoteObject
implements Repertoire
{
	// Žtat interne
	protected java.util.Hashtable<String,Personne> personnes;

	// le constructeur
	public RepertoireImpl ()
	throws java.rmi.RemoteException
	{
		super();
		this.personnes = new java.util.Hashtable<String,Personne>();
	}

	public boolean ajouterPersonne(Personne pers)
	throws java.rmi.RemoteException
	{
		if (personnes.containsKey (pers.getNom()))return false;
		this.personnes.put(pers.getNom(),pers);
		return true;
	}

	public boolean modifierPersonne (Personne personne)
	throws java.rmi.RemoteException
	{
		Personne p = personnes.get(personne.getNom());
		if ( p == null )return false;
		p.modifier(personne);
		return true;
	}

	public boolean retirerPersonne (String nom)
	throws java.rmi.RemoteException
	{
		return this.personnes.remove (nom) != null;
	}

	public Personne chercherPersonne (String nom)
	throws java.rmi.RemoteException
	{
		return this.personnes.get(nom);
	}

	public String[] listerPersonnes ()
    throws java.rmi.RemoteException
    {
		return personnes.keySet().toArray ( new String[0] );
    }
}

