package vue;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Skieur;

 public class VueListeSkieur extends Scene {
	 
 	private GridPane grilleSkieurs;


	public VueListeSkieur() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		grilleSkieurs = new GridPane();
		
		panneau.getChildren().add(grilleSkieurs);
		
		List<Skieur> listeSkieur = new ArrayList<Skieur>();
		listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
		listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
		
		afficherListeSkieur(listeSkieur);
		
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