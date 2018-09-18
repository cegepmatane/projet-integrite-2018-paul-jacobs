package donnee;

import modele.Prix;
import modele.Skieur;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PrixDAO {

    private String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
    private String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/skieur";
    private String BASEDEDONNEES_USAGER = "postgres";
    private String BASEDEDONNEES_MOTDEPASSE = "toto";
    Connection connection=null;

    public PrixDAO() {
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

    private List<Prix> simulerListePrix(){
        List<Prix> listePrix = new ArrayList<>();
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        return listePrix;
    }

    public List<Prix> listerPrixParPatente(Skieur skieur){
        return simulerListePrix();
    }

    public Prix raporterprix()
    {
        return null;
    }

    public void modifierPrix(Skieur skieur, Prix prix)
    {

    }

    public void ajouterPrix(Skieur skieur, Prix prix)
    {

    }

    public void effacerPrix(Prix prix)
    {

    }
}
