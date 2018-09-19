package donnee;

import modele.Skieur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkieurDAO {

    Connection connection=null;

    public SkieurDAO(){
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

     /*private List<Skieur> simulerListeSkieur(){

        List<Skieur> listeSkieur = new ArrayList<Skieur>();

        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));

        return listeSkieur;
    }*/

    public List<Skieur> listerSkieur() {

        List<Skieur> listeSkieur = new ArrayList<Skieur>();


        Statement requeteListeSkieurs = null;
        try {
            requeteListeSkieurs = connection.createStatement();
            ResultSet curseurListeSkieurs = requeteListeSkieurs.executeQuery("SELECT * FROM skieur");
             while (curseurListeSkieurs.next())
             {
                 int id = curseurListeSkieurs.getInt("id");
                 String nom = curseurListeSkieurs.getString("nom");
                 String prenom = curseurListeSkieurs.getString("prenom");
                 String age = curseurListeSkieurs.getString("age");
                 String poids = curseurListeSkieurs.getString("poids");

                 listeSkieur.add(raporterSkieur(id,nom,prenom,age,poids));

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeSkieur;
    }

    public Skieur raporterSkieur(int id, String nom, String prenom, String age, String poids)
    {
        return new Skieur(id,nom,prenom,age,poids);
    }

    public void ajouterSkieur(Skieur skieur)
    {

        try {
            String requeteSQLAjouterSkieur = "INSERT  INTO skieur(nom,prenom,age,poids) VALUES('"+
                    skieur.getNom()+"','"+
                    skieur.getPrenom()+"','"+
                    skieur.getAge()+"','"+
                    skieur.getPoids()+"')";
            Statement requeteAjouterSkieurs = connection.createStatement();
            requeteAjouterSkieurs.execute(requeteSQLAjouterSkieur);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierSkieur(Skieur skieur) {
        try {
            String requeteSQLAjouterSkieur = "UPDATE skieur SET nom='"+skieur.getNom()+"',prenom='"+
                    skieur.getPrenom()+"',age='"+
                    skieur.getAge()+"',poids='"+
                    skieur.getPoids()+"' WHERE id = '"+skieur.getId()+"';";

            System.out.println(requeteSQLAjouterSkieur);

            Statement requeteAjouterSkieurs = connection.createStatement();
            requeteAjouterSkieurs.execute(requeteSQLAjouterSkieur);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerSkieur(Skieur skieur)
    {

    }
}
