public class ClientFabrique {

 public static void main(String args[]) throws Exception
 {
   // Obtenir la souche sur l’OD via l'annuaire RMI.
   Fabrique fab = (Fabrique)
           java.rmi.Naming.lookup("//localhost/"+args[0]);

   Repertoire rep = fab.creerRepertoire();

   java.rmi.Naming.rebind(args[1], rep);
   System.exit(0);
 }
}