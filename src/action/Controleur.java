package action;

import donnee.SkieurDAO;
import vue.NavigateurVueSkieur;
import vue.VueAjouterSkieur;
import vue.VueListeSkieur;
import vue.VueSkieur;

public class Controleur {

    private static Controleur instance=null;

    private VueSkieur vueSkieur;
    private VueListeSkieur vueListeSkieur;
    private VueAjouterSkieur vueAjouterSkieur;
    private NavigateurVueSkieur navigateurVueSkieur;
    private SkieurDAO skieurDAO;

    private Controleur(NavigateurVueSkieur navigateurVueSkieur){
        this.navigateurVueSkieur = navigateurVueSkieur;

        this.vueSkieur = this.navigateurVueSkieur.getVueSkieur();
        this.vueListeSkieur = this.navigateurVueSkieur.getVueListeSkieur();
        this.vueAjouterSkieur = this.navigateurVueSkieur.getVueAjouterSkieur();
        this.skieurDAO = new SkieurDAO();

        vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());

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