package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

import java.util.List;

 public class VueListeSkieur extends Scene {

 	private GridPane grilleSkieurs;

 	private Button actionCreerSkieur;


	public VueListeSkieur() {
		super(new GridPane(), 400,400);
		grilleSkieurs = (GridPane) this.getRoot();
        actionCreerSkieur = new Button("ajouter un skieur");
		
		// TODO Auto-generated constructor stub
	}


	public void afficherListeSkieur(List<Skieur> listeSkieurs)
	{
		this.grilleSkieurs.getChildren().clear(); //nettoyage de la grille d'affichage
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
			this.grilleSkieurs.add(new Button("modifier"), 4, numero);
			this.grilleSkieurs.add(new Button("supprimer"), 5, numero);
		}

		this.grilleSkieurs.add(this.actionCreerSkieur,1,numero+1);
	}
 }