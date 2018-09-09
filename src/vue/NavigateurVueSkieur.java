package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVueSkieur extends Application{

	private VueSkieur vueSkieur;
	private VueListeSkieur vueListeSkieur;
	private VueAjouterSkieur vueAjouterSkieur;
	private Stage stade;

	@Override
	public void start(Stage stade) throws Exception {

		this.stade = stade;
		this.vueSkieur = new VueSkieur();
		this.vueListeSkieur = new VueListeSkieur();
		this.vueAjouterSkieur = new VueAjouterSkieur();

		naviguerVersVueListeSkieur();
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
}
