package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Skieur;

 public class VueAjouterSkieur extends Application{
 	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	@Override
	public void start(Stage stade) throws Exception {
		VBox panneau = new VBox();	
		GridPane grilleSkieur = new GridPane();
 		
		valeurNom = new TextField();
		grilleSkieur.add(new Label("Nom : "), 0, 0);
		grilleSkieur.add(valeurNom, 1, 0);
		
		valeurCouleur = new TextField("");
		grilleSkieur.add(new Label("Prenom : "), 0, 1);
		grilleSkieur.add(valeurCouleur, 1, 1);
 		valeurPoids = new TextField("");
		grilleSkieur.add(new Label("Age : "), 0, 2);
		grilleSkieur.add(valeurPoids, 1, 2);		
 		valeurNaissance = new TextField("");
		grilleSkieur.add(new Label("Poids : "), 0, 3);
		grilleSkieur.add(valeurNaissance, 1, 3);				
			
		panneau.getChildren().add(new Label("Ajouter un skieur"));
		panneau.getChildren().add(grilleSkieur);
		panneau.getChildren().add(new Button("Enregistrer"));
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();		
	}
	
	public Skieur demanderSkieur()
	{
		return null;
	}
 }