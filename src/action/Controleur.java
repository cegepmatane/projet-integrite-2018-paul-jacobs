package action;

import donnee.SkieurDAO;
import modele.Prix;
import modele.Skieur;
import vue.*;

public class Controleur {

    private static Controleur instance=null;

    private VueSkieur vueSkieur;
    private VueListeSkieur vueListeSkieur;
    private VueAjouterSkieur vueAjouterSkieur;
    private VueModifierSkieur vueModifierSkieur;
    private VueModifierPrix vueModifierPrix;
    private VueAjouterPrix vueAjouterPrix;
    private NavigateurVueSkieur navigateurVueSkieur;
    private SkieurDAO skieurDAO;

    private Controleur(NavigateurVueSkieur navigateurVueSkieur){
        this.navigateurVueSkieur = navigateurVueSkieur;

        this.vueSkieur = this.navigateurVueSkieur.getVueSkieur();
        this.vueListeSkieur = this.navigateurVueSkieur.getVueListeSkieur();
        this.vueAjouterSkieur = this.navigateurVueSkieur.getVueAjouterSkieur();
        this.vueModifierSkieur = this.navigateurVueSkieur.getVueModifierSkieur();
        this.vueModifierPrix = this.navigateurVueSkieur.getVueModifierPrix();
        this.vueAjouterPrix = this.navigateurVueSkieur.getVueAjouterPrix();

        this.skieurDAO = new SkieurDAO();

        vueAjouterPrix.afficherVueAjouterPrix();
        this.navigateurVueSkieur.naviguerVersVueAjouterPrix();

        //vueModifierPrix.afficherVueModifierPrix(new Prix("temps","temps","temps","temps","temps"));
        //this.navigateurVueSkieur.naviguerVersVueModifierPrix();

        //vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());

        //this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }

    public void ajouterSkieur(Skieur skieur)
    {
        this.skieurDAO.ajouterSkieur(skieur);
        vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());
        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }

    public void modifierSkieur(Skieur skieur)
    {
        this.skieurDAO.modifierSkieur(skieur);
        vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());
        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }

    public void naviguerVersVueModifierSkieur(Skieur skieur)
    {
        vueModifierSkieur.afficherGrillerModifierSkieur(skieur);
        this.navigateurVueSkieur.naviguerVersVueModifierSkieur();
    }

    public void naviguerVersVueAjouterSkieur()
    {
        this.navigateurVueSkieur.naviguerVersVueAjouterSkieur();
    }

    //debut singleton
    public static Controleur getInstance(NavigateurVueSkieur navigateurVueSkieur){
        if (instance==null)
            instance = new Controleur(navigateurVueSkieur);
        return instance;
    }

    // fin singleton

}
