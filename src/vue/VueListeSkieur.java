package vue;

import action.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

import java.util.Calendar;
import java.util.List;

 public class VueListeSkieur extends Scene {

     private Controleur controleur;

 	private GridPane grilleSkieurs;
 	private Button actionCreerSkieur;


	public VueListeSkieur() {
		super(new GridPane(), 400,400);
		grilleSkieurs = (GridPane) this.getRoot();
        actionCreerSkieur = new Button("ajouter un skieur");

        actionCreerSkieur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleur.naviguerVersVueAjouterSkieur();
            }
        });
		
		// TODO Auto-generated constructor stub
	}


	public void afficherListeSkieur(List<Skieur> listeSkieurs)
	{
		this.grilleSkieurs.getChildren().clear(); //nettoyage de la grille d'affichage
		int numero = 0;
		this.grilleSkieurs.add(new Label("Nom"), 0, numero);
		this.grilleSkieurs.add(new Label("Prenom"), 1, numero);
		for(Skieur skieur : listeSkieurs)
		{
            Button actionModifierSkieur = new Button("modifier");
            actionModifierSkieur.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controleur.naviguerVersVueModifierSkieur(skieur);
                }
            });

			numero++;
			this.grilleSkieurs.add(new Label(skieur.getNom()), 0, numero);
			this.grilleSkieurs.add(new Label(skieur.getPrenom()), 1, numero);
			this.grilleSkieurs.add(actionModifierSkieur, 2, numero);
			this.grilleSkieurs.add(new Button("supprimer"), 3, numero);
		}

		this.grilleSkieurs.add(this.actionCreerSkieur,0,numero+1);
	}

     public void setControleur(Controleur controleur) {
         this.controleur = controleur;
     }
 }