import java.rmi.RemoteException;

public class FabriqueObserveImpl extends FabriqueImpl
                          implements FabriqueObserve
{

  public FabriqueObserveImpl() throws RemoteException {
		super();
	}

public RepertoireObserve creerRepertoireObserve () throws RemoteException
  {
    return new RepertoireObserveImpl();
  }

}
