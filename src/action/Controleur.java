package action;

import donnee.PrixDAO;
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
    private PrixDAO prixDAO;

    private Controleur(NavigateurVueSkieur navigateurVueSkieur){
        this.navigateurVueSkieur = navigateurVueSkieur;

        this.vueSkieur = this.navigateurVueSkieur.getVueSkieur();
        this.vueListeSkieur = this.navigateurVueSkieur.getVueListeSkieur();
        this.vueAjouterSkieur = this.navigateurVueSkieur.getVueAjouterSkieur();
        this.vueModifierSkieur = this.navigateurVueSkieur.getVueModifierSkieur();
        this.vueModifierPrix = this.navigateurVueSkieur.getVueModifierPrix();
        this.vueAjouterPrix = this.navigateurVueSkieur.getVueAjouterPrix();

        this.skieurDAO = new SkieurDAO();
        this.prixDAO = new PrixDAO();

        //vueAjouterPrix.afficherVueAjouterPrix();
        //this.navigateurVueSkieur.naviguerVersVueAjouterPrix();

        //vueModifierPrix.afficherVueModifierPrix(new Prix("temps","temps","temps","temps","temps"));
        //this.navigateurVueSkieur.naviguerVersVueModifierPrix();

        vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());
        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
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
        vueModifierSkieur.afficherGrillePrix(skieur, prixDAO.listerPrixParPatente(skieur));
        this.navigateurVueSkieur.naviguerVersVueModifierSkieur();
    }

    public void naviguerVersVueAjouterSkieur()
    {
        vueAjouterSkieur.nettoyer();
        this.navigateurVueSkieur.naviguerVersVueAjouterSkieur();
    }

    public void naviguerVersVueAjouterPrix()
    {
        this.vueAjouterPrix.nettoyer();
        this.navigateurVueSkieur.naviguerVersVueAjouterPrix();
    }

    public void naviguerVersVueModifierPrix(Prix prix, Skieur skieur)
    {
        vueModifierPrix.afficherVueModifierPrix(prix, skieur);
        this.navigateurVueSkieur.naviguerVersVueModifierPrix();
    }

    public void ajouterPrix(Skieur skieur, Prix prix)
    {
        this.prixDAO.ajouterPrix(skieur, prix);
        vueListeSkieur.afficherListeSkieur(skieurDAO.listerSkieur());
        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }

    public void modifierPrix(Skieur skieur, Prix prix)
    {
        this.prixDAO.modifierPrix(skieur, prix);
        vueModifierSkieur.afficherGrillerModifierSkieur(skieur);
        vueModifierSkieur.afficherGrillePrix(skieur, prixDAO.listerPrixParPatente(skieur));
        this.navigateurVueSkieur.naviguerVersVueModifierSkieur();
    }

    //debut singleton
    public static Controleur getInstance(NavigateurVueSkieur navigateurVueSkieur){
        if (instance==null)
            instance = new Controleur(navigateurVueSkieur);
        return instance;
    }

    // fin singleton

}
