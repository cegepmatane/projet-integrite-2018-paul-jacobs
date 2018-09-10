package accesseur;

import modele.Skieur;

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
        return simulerListeSkieur();
    }
}
