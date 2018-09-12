package donnee;

import modele.Skieur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkieurDAO {

    private List<Skieur> simulerListeSkieur(){

        List<Skieur> listeSkieur = new ArrayList<Skieur>();

        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));

        return listeSkieur;
    }

    public List<Skieur> listerSkieur() {

        String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
        String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/skieur";
        String BASEDEDONNEES_USAGER = "postgres";
        String BASEDEDONNEES_MOTDEPASSE = "toto";

        try {
            Class.forName(BASEDEDONNEES_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);

            Statement requeteListeSkieurs = connection.createStatement();
            ResultSet curseurListeSkieurs = requeteListeSkieurs.executeQuery("SELECT * FROM skieur");
            curseurListeSkieurs.next();

            String nom = curseurListeSkieurs.getString("nom");
            String prenom = curseurListeSkieurs.getString("prenom");
            String age = curseurListeSkieurs.getString("age");
            String poids = curseurListeSkieurs.getString("poids");

            System.out.println("nom:"+nom+" prenom:"+prenom+" age:"+age+" poids"+poids);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return simulerListeSkieur();
    }
}
