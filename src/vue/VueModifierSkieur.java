package vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Skieur;


public class VueModifierSkieur extends Scene {

    private Button actionModifierSkieur;
    private GridPane grilleModifierSkieur;

    public VueModifierSkieur() {
        super(new GridPane(),400,400);
        this.grilleModifierSkieur = (GridPane) this.getRoot();

        this.actionModifierSkieur = new Button("enregistrer");
    }

    public void afficherGrillerModifierSkieur(Skieur skieur)
    {
        this.grilleModifierSkieur.add(new Label("Nom : "), 0, 0);
        this.grilleModifierSkieur.add(new Label("Prenom : "), 0, 1);
        this.grilleModifierSkieur.add(new Label("Age : "), 0, 2);
        this.grilleModifierSkieur.add(new Label("Poids : "), 0, 3);

        this.grilleModifierSkieur.add(new TextField(skieur.getNom()),1,0);
        this.grilleModifierSkieur.add(new TextField(skieur.getPrenom()),1,1);
        this.grilleModifierSkieur.add(new TextField(skieur.getAge()),1,2);
        this.grilleModifierSkieur.add(new TextField(skieur.getPoids()),1,3);
        this.grilleModifierSkieur.add(actionModifierSkieur,0,4);

    }
}
