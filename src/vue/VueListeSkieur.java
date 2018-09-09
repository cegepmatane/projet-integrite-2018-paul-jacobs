package vue;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

 public class VueListeSkieur extends Scene {
	 
 	private GridPane grilleSkieurs;


	public VueListeSkieur() {
		super(new VBox(), 400,400);
		VBox panneau = (VBox) this.getRoot();
		grilleSkieurs = new GridPane();
		
		panneau.getChildren().add(grilleSkieurs);

		panneau.getChildren().add(new Button("ajouter un skieur"));
		
		// TODO Auto-generated constructor stub
	}


	public void afficherListeSkieur(List<Skieur> listeSkieurs)
	{
		
		int numero = 0;
		this.grilleSkieurs.add(new Label("Nom"), 0, numero);
		this.grilleSkieurs.add(new Label("Prenom"), 1, numero);
		this.grilleSkieurs.add(new Label("Age"), 2, numero);
		this.grilleSkieurs.add(new Label("Poids"), 3, numero);
		for(Skieur mouton : listeSkieurs)
		{
			numero++;
			this.grilleSkieurs.add(new Label(mouton.getNom()), 0, numero);
			this.grilleSkieurs.add(new Label(mouton.getPrenom()), 1, numero);
			this.grilleSkieurs.add(new Label(mouton.getAge()), 2, numero);
			this.grilleSkieurs.add(new Label(mouton.getPoids()), 3, numero);			
		}
	}
 }