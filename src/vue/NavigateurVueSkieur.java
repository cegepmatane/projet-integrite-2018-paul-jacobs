package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVueSkieur extends Application{

	private VueSkieur vueSkieur;

	@Override
	public void start(Stage stade) throws Exception {
		
		this.vueSkieur = new VueSkieur();
		
		stade.setScene(this.vueSkieur);
		stade.show();	
	}
}
