public class ClientSimple {

 public static void main(String args[]) throws Exception
 {
   // Obtenir la souche sur l�OD via l'annuaire RMI.
   Repertoire rep = (Repertoire)
           java.rmi.Naming.lookup("//localhost/"+args[0]);

   // Invoquer des m�thodes comme si l'objet �tait local.
    traitement (rep);
    System.exit(0);
 }

static void traitement(Repertoire repertoire) throws Exception
 {
  Personne pers=new Personne("Roos","roos@lifl.fr","www.lifl.fr/~roos","enseignant/chercheur");
  if(!repertoire.ajouterPersonne(pers))
    System.out.println("ATTENTION : Roos a d�j� �t� ajout�");
  repertoire.modifierPersonne (pers);
  String[] noms = repertoire.listerPersonnes();
  for (String n : noms) {
      pers = repertoire.chercherPersonne(n);
      System.out.println("Nom : " + pers.getNom());
      System.out.println("Informations : " + pers.getInfo());
      System.out.println("Email : " + pers.getEmail());
      System.out.println("URL : " + pers.getUrl());
    }
  repertoire.retirerPersonne ("Roos");
  System.out.println("traitement termin�");
 }
}
