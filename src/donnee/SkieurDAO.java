package donnee;

import modele.Skieur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkieurDAO {

    private String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
    private String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/skieur";
    private String BASEDEDONNEES_USAGER = "postgres";
    private String BASEDEDONNEES_MOTDEPASSE = "toto";
    Connection connection;

    public SkieurDAO(){
     try {
        Class.forName(BASEDEDONNEES_DRIVER);
     }catch (ClassNotFoundException e) {
        e.printStackTrace();
     }

         try {
             connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
         } catch (SQLException e) {
             e.printStackTrace();
         }

     }

     private List<Skieur> simulerListeSkieur(){

        List<Skieur> listeSkieur = new ArrayList<Skieur>();

        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));

        return listeSkieur;
    }

    public List<Skieur> listerSkieur() {

        List<Skieur> listeSkieur = new ArrayList<Skieur>();


        Statement requeteListeSkieurs = null;
        try {
            requeteListeSkieurs = connection.createStatement();
            ResultSet curseurListeSkieurs = requeteListeSkieurs.executeQuery("SELECT * FROM skieur");
             while (curseurListeSkieurs.next())
             {
                 String nom = curseurListeSkieurs.getString("nom");
                 String prenom = curseurListeSkieurs.getString("prenom");
                 String age = curseurListeSkieurs.getString("age");
                 String poids = curseurListeSkieurs.getString("poids");

                 System.out.println("nom:"+nom+" prenom:"+prenom+" age:"+age+" poids"+poids);
                 listeSkieur.add(new Skieur(nom,prenom,age,poids));

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeSkieur;
    }

    public void ajouterSkieur(Skieur skieur)
    {

        try {
            connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);

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
}
