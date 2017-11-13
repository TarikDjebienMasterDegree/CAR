public class ServeurFabriqueObserve
{   
 public static void main(String args[]) throws Exception
 {
   // Cr�er l'objet accessible par Java RMI.
   FabriqueObserveImpl obj = new FabriqueObserveImpl();

   // Enregistrer cet objet dans l�annuaire RMI.
   java.rmi.Naming.rebind(args[0], obj);

   // Ici le programme ne se termine pas !
   // Car attente des invocations distantes sur l�OD.
  }
}
