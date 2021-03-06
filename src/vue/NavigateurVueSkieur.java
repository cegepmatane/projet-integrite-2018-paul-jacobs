package vue;

import action.Controleur;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVueSkieur extends Application{

	private VueSkieur vueSkieur;
	private VueListeSkieur vueListeSkieur;
	private VueAjouterSkieur vueAjouterSkieur;
	private VueModifierSkieur vueModifierSkieur;
	private VueModifierPrix vueModifierPrix;
	private VueAjouterPrix vueAjouterPrix;
	private Stage stade;
    private Controleur controleur;

    @Override
	public void start(Stage stade) throws Exception {

		this.stade = stade;
		this.vueSkieur = new VueSkieur();
		this.vueListeSkieur = new VueListeSkieur();
		this.vueAjouterSkieur = new VueAjouterSkieur();
		this.vueModifierSkieur = new VueModifierSkieur();
		this.vueModifierPrix = new VueModifierPrix();
		this.vueAjouterPrix = new VueAjouterPrix();

        this.stade.setScene(null); //a null pour afficher la page et eviter bog controleur
        this.stade.show();


        this.controleur = Controleur.getInstance(this);

        //transmission du controleurs dans les vues
        this.vueSkieur.setControleur(this.controleur);
        this.vueListeSkieur.setControleur(this.controleur);
        this.vueAjouterSkieur.setControleur(this.controleur);
        this.vueModifierSkieur.setControleur(this.controleur);
        this.vueAjouterPrix.setControleur(this.controleur);
        this.vueModifierPrix.setControleur(this.controleur);
	}

    public void naviguerVersVueSkieur(){
        this.stade.setScene(this.vueSkieur);
        this.stade.show();
    }


    public void naviguerVersVueListeSkieur(){
        this.stade.setScene(this.vueListeSkieur);
        this.stade.show();
    }


    public void naviguerVersVueAjouterSkieur(){
		this.stade.setScene(this.vueAjouterSkieur);
		this.stade.show();
	}

	public void naviguerVersVueModifierSkieur(){
        this.stade.setScene(this.vueModifierSkieur);
        this.stade.show();
    }

    public void naviguerVersVueModifierPrix(){
        this.stade.setScene(this.vueModifierPrix);
        this.stade.show();
    }

    public void naviguerVersVueAjouterPrix(){
        this.stade.setScene(this.vueAjouterPrix);
        this.stade.show();
    }

    public VueSkieur getVueSkieur() {
        return vueSkieur;
    }

    public VueListeSkieur getVueListeSkieur() {
        return vueListeSkieur;
    }

    public VueAjouterSkieur getVueAjouterSkieur() {
        return vueAjouterSkieur;
    }

    public VueModifierSkieur getVueModifierSkieur() { return vueModifierSkieur; }

    public VueModifierPrix getVueModifierPrix() { return vueModifierPrix; }

    public VueAjouterPrix getVueAjouterPrix() { return vueAjouterPrix; }
}