public class Serveur
{   
 public static void main(String args[]) throws Exception
 {
   // Créer l'objet accessible par Java RMI.
   RepertoireImpl obj = new RepertoireImpl();

   // Enregistrer cet objet dans l’annuaire RMI.
   java.rmi.Naming.rebind(args[0], obj);
   // Ici le programme ne se termine pas !
   // Car attente des invocations distantes sur l’OD.
  }
}
