import java.rmi.RemoteException;

public class FabriqueImpl extends java.rmi.server.UnicastRemoteObject
                          implements Fabrique
{

  public FabriqueImpl() throws RemoteException {
		super();
	}

public Repertoire creerRepertoire () throws RemoteException
  {
    return new RepertoireImpl();
  }

}
