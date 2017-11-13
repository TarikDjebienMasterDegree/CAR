
public class IHM extends javax.swing.JFrame
{ 
  /**
   **  Les éléments graphiques.
   **/
  protected javax.swing.JTextArea lignes;

  /**
   **  Le constructeur avec un titre.
   **/
  public IHM(String titre)
  {
    // Créer une fenêtre Swing.
    super(titre);

    // Fixer la taille de la fenêtre.
    super.setSize(400, 300);

    // Créer la liste des lignes affichées.
    lignes = new javax.swing.JTextArea(40, 20);
    lignes.setEditable(false);

    // Obtenir le panel contenu par la fenêtre.
    java.awt.Container contentPane = super.getContentPane();

    // Fixer la mise en forme du panel.
    contentPane.setLayout(new java.awt.BorderLayout());

    // Ajouter un panel scrollable pour afficher les lignes.
    contentPane.add(
      java.awt.BorderLayout.CENTER,
      new javax.swing.JScrollPane(lignes)
    );
  }

  /**
   **   Ajouter une ligne à la liste des lignes affichées.
   **/
  public void ajouterLigne(String ligne)
  {
    lignes.append(ligne + "\n");
  }

  /**
   **   Remettre à zéro de la liste des lignes affichées.
   **/
  public void raz()
  {
    lignes.setText("");
  }

  /**
   **  Mettre un listener de sortie de programme.
   **/

  public static void mettreListenerSortieProgramme(IHM ihm)
  {
    // Mettre un listener sur les événements de la fenêtre.
    ihm.addWindowListener(
      new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent e)
        {
          // Arrêter le programme.
          System.exit(0);
        }
      }
    );
  }

  /**
   **  Un exemple d'utilisation.
   **/

  public static void main(String[] args)
  {
    // Création de l'IHM du panneau d'affichage.
    IHM ihm = new IHM("Une borne d'affichage");

    // Mettre un listener sur les événements de la fenêtre.
    IHM.mettreListenerSortieProgramme(ihm);

    // Afficher la fenêtre.
    ihm.setVisible(true);

    // Ajouter des lignes de texte dans le panneau d'affichage.
    for (int i=0; i<30; i++)
    {
      ihm.ajouterLigne("Le message " + i);
    }

    // Effacer le contenu du panneau d'affichage.
    ihm.raz();

    // Ajouter d'autres lignes de texte dans le panneau d'affichage.
    for (int i=30; i<50; i++)
    {
      ihm.ajouterLigne("Le message " + i);
    }
  }
}

