public interface RepertoireObserve extends Repertoire
{

  public void ajouterObservateur(ObservateurRepertoire obs)
                   throws java.rmi.RemoteException;

  public void retirerObservateur(ObservateurRepertoire obs)
                   throws java.rmi.RemoteException;
}
