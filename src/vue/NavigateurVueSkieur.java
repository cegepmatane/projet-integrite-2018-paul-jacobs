package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVueSkieur extends Application{

	private VueSkieur vueSkieur;
	private VueListeSkieur vueListeSkieur;

	@Override
	public void start(Stage stade) throws Exception {
		
		this.vueSkieur = new VueSkieur();
		this.vueListeSkieur = new VueListeSkieur();
		
		stade.setScene(this.vueListeSkieur);
		stade.show();	
	}
}
