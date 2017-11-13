public interface ObservateurRepertoire extends java.rmi.Remote
{

   public void annoncerCreationPersonne (String nom)
                   throws java.rmi.RemoteException;

   public void annoncerDestructionPersonne (String nom )
                   throws java.rmi.RemoteException;

   public void annoncerModificationPersonne (String nom)
                   throws java.rmi.RemoteException;
}
