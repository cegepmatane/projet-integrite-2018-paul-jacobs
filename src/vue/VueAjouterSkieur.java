package vue;

import action.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

import java.util.EventListener;

public class VueAjouterSkieur extends Scene{
 	 protected TextField valeurNom;
	 protected TextField valeurPrenom;
	 protected TextField valeurAge;
	 protected TextField valeurPoids;
     private Controleur controleur;
     private Button actionEnregistrerSkieur = null;

     public VueAjouterSkieur(){
		super(new VBox(), 400,400);
		VBox panneau = (VBox) this.getRoot();	
		GridPane grilleSkieur = new GridPane();

		actionEnregistrerSkieur = new Button("enregistrer");

		actionEnregistrerSkieur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Skieur skieur = demanderSkieur();
                controleur.enregistrerSkieur(skieur);
            }
        });

		 valeurNom = new TextField();
		 grilleSkieur.add(new Label("Nom : "), 0, 0);
		 grilleSkieur.add(valeurNom, 1, 0);
		
		 valeurPrenom = new TextField("");
		 grilleSkieur.add(new Label("Prenom : "), 0, 1);
		 grilleSkieur.add(valeurPrenom, 1, 1);
 		 valeurAge = new TextField("");
		 grilleSkieur.add(new Label("Poids : "), 0, 3);
		 grilleSkieur.add(valeurAge, 1, 2);
         valeurPoids = new TextField("");
         grilleSkieur.add(new Label("Age : "), 0, 2);
         grilleSkieur.add(valeurPoids, 1, 3);
			
		panneau.getChildren().add(new Label("Ajouter un skieur"));
		panneau.getChildren().add(grilleSkieur);
		panneau.getChildren().add(actionEnregistrerSkieur);
	}
	
	public Skieur demanderSkieur()
	{
		return new Skieur(valeurNom.getText(),valeurPrenom.getText(),valeurAge.getText(),valeurPoids.getText());
	}


	 public void setControleur(Controleur controleur) {
		 this.controleur = controleur;
	 }
 }