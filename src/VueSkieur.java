import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueSkieur extends Application{

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();	
		GridPane grilleSkieur = new GridPane();

		Label valeurNom = new Label("paul");
		grilleSkieur.add(new Label("Nom : "), 0, 0);
		grilleSkieur.add(valeurNom, 1, 0);
		
		Label valeurPrenom = new Label("Jacobs");
		grilleSkieur.add(new Label("Prenom : "), 0, 1);
		grilleSkieur.add(valeurPrenom, 1, 1);

		Label valeurAge = new Label("18 ans");
		grilleSkieur.add(new Label("Age : "), 0, 2);
		grilleSkieur.add(valeurAge, 1, 2);				
		
		Label valeurPoids = new Label("20 kg");
		grilleSkieur.add(new Label("Poids : "), 0, 3);
		grilleSkieur.add(valeurPoids, 1, 3);		
	
		panneau.getChildren().add(grilleSkieur);
		
		stade.setScene(new Scene(panneau, 400, 400));
		
		stade.show();
	}

}