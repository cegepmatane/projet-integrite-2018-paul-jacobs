package vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

 public class VueAjouterSkieur extends Scene{
 	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	public VueAjouterSkieur(){
		super(new VBox(), 400,400);
		VBox panneau = (VBox) this.getRoot();	
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
	}
	
	public Skieur demanderSkieur()
	{
		return null;
	}
 }