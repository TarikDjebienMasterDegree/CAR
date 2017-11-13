import java.util.ArrayList;

public class RepertoireObserveImpl extends RepertoireImpl
implements RepertoireObserve
{
	protected ArrayList<ObservateurRepertoire> observateurs;

	public RepertoireObserveImpl ()
	throws java.rmi.RemoteException
	{
		super();
		this.observateurs = new ArrayList<ObservateurRepertoire>();
	}

	public void ajouterObservateur(ObservateurRepertoire obs)
	throws java.rmi.RemoteException
	{
		observateurs.add(obs);
		System.out.println(obs + "ajouté");
	}

	public void retirerObservateur(ObservateurRepertoire obs)
	throws java.rmi.RemoteException
	{ observateurs.add(obs); }

	public boolean ajouterPersonne(Personne pers)
	throws java.rmi.RemoteException
	{
		boolean result = super.ajouterPersonne (pers);

		for(ObservateurRepertoire o : observateurs)
			try {
				o.annoncerCreationPersonne(pers.getNom());
			} catch (java.rmi.RemoteException re) {
				re.printStackTrace();
				retirerObservateur(o);
			}
		return result;
	}

	public boolean modifierPersonne (Personne pers)
	throws java.rmi.RemoteException
	{
		boolean result = super.modifierPersonne (pers);

		for(ObservateurRepertoire o : observateurs)
			try {
				o.annoncerModificationPersonne(pers.getNom());
			} catch (java.rmi.RemoteException re) {
				retirerObservateur(o);
			}
		return result;
	}

	public boolean retirerPersonne (String nom)
	throws java.rmi.RemoteException
	{
		System.out.println("fils");
		boolean result = super.retirerPersonne (nom);
		System.out.println("fils");

		for(ObservateurRepertoire o : observateurs) {
			System.out.println("for");
			try {
				o.annoncerDestructionPersonne(nom);
			} catch (java.rmi.RemoteException re) {
				retirerObservateur(o);
			}
		}
		return result;
	}
}
