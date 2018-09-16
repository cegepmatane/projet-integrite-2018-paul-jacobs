package donnee;

import modele.Prix;
import modele.Skieur;

import java.util.ArrayList;
import java.util.List;

public class prixDAO {

    private List<Prix> simulerListePrix(){
        List<Prix> listePrix = new ArrayList<>();
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000"));
        return listePrix;
    }

    public List<Prix> recupererListePrixSkieur(Skieur skieur){
        return simulerListePrix();
    }
}
