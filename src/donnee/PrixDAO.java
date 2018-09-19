package donnee;

import modele.Prix;
import modele.Skieur;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PrixDAO {

    Connection connection=null;

    public PrixDAO() {
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

    private List<Prix> simulerListePrix(){
        List<Prix> listePrix = new ArrayList<>();
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        return listePrix;
    }

    public List<Prix> listerPrixParPatente(Skieur skieur){
        return simulerListePrix();
    }

    public Prix raporterprix(String idSkieur, String titre, String date, String temps)
    {
        return new Prix(idSkieur,titre, date,temps);
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
