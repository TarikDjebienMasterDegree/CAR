public class ClientFabriqueObserve {

 public static void main(String args[]) throws Exception
 {
   // Obtenir la souche sur l’OD via l'annuaire RMI.
   FabriqueObserve fab = (FabriqueObserve)
           java.rmi.Naming.lookup("//localhost/"+args[0]);

   RepertoireObserve rep = fab.creerRepertoireObserve();

   java.rmi.Naming.rebind(args[1], rep);
   System.exit(0);
 }
}