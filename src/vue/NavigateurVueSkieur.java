package vue;

import action.Controleur;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVueSkieur extends Application{

	private VueSkieur vueSkieur;
	private VueListeSkieur vueListeSkieur;
	private VueAjouterSkieur vueAjouterSkieur;
	private Stage stade;
    private Controleur controleur;

    @Override
	public void start(Stage stade) throws Exception {

		this.stade = stade;
		this.vueSkieur = new VueSkieur();
		this.vueListeSkieur = new VueListeSkieur();
		this.vueAjouterSkieur = new VueAjouterSkieur();

        this.stade.setScene(null); //a null pour afficher la page et eviter bog controleur
        this.stade.show();


        this.controleur = Controleur.getInstance(this);

        //transmission du controleurs dans les vues
        this.vueSkieur.setControleur(this.controleur);
        this.vueListeSkieur.setControleur(this.controleur);
        this.vueAjouterSkieur.setControleur(this.controleur);
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

    public VueSkieur getVueSkieur() {
        return vueSkieur;
    }

    public VueListeSkieur getVueListeSkieur() {
        return vueListeSkieur;
    }

    public VueAjouterSkieur getVueAjouterSkieur() {
        return vueAjouterSkieur;
    }
}
