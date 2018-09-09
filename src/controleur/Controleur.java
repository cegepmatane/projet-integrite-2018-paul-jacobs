package controleur;

import modele.Skieur;
import vue.NavigateurVueSkieur;
import vue.VueAjouterSkieur;
import vue.VueListeSkieur;
import vue.VueSkieur;

import java.util.ArrayList;
import java.util.List;

public class Controleur {

    private static Controleur instance=null;

    private VueSkieur vueSkieur;
    private VueListeSkieur vueListeSkieur;
    private VueAjouterSkieur vueAjouterSkieur;
    private NavigateurVueSkieur navigateurVueSkieur;

    private Controleur(NavigateurVueSkieur navigateurVueSkieur){
        this.navigateurVueSkieur = navigateurVueSkieur;

        this.vueSkieur = this.navigateurVueSkieur.getVueSkieur();
        this.vueListeSkieur = this.navigateurVueSkieur.getVueListeSkieur();
        this.vueAjouterSkieur = this.navigateurVueSkieur.getVueAjouterSkieur();

        List<Skieur> listeSkieur = new ArrayList<Skieur>();
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));

        vueListeSkieur.afficherListeSkieur(listeSkieur);

        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }

    //debut singleton
    public static Controleur getInstance(NavigateurVueSkieur navigateurVueSkieur){
        if (instance==null)
            instance = new Controleur(navigateurVueSkieur);
        return instance;
    }

    // fin singleton

}
