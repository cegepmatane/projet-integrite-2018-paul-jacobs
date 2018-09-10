package donnee;

import modele.Skieur;

import java.sql.DriverManager;
import java.sql.SQLException;
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
            DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return simulerListeSkieur();
    }
}
