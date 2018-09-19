package vue;

import action.Controleur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class VueAjouterPrix extends Scene {

    private TextField valeurNom;
    private TextField valeurDate;
    private TextField valeurTemps;

    private GridPane grilleAjouterPrix;
    private Controleur controleur;

    public VueAjouterPrix() {
        super(new GridPane(),400,400);
        grilleAjouterPrix = (GridPane) this.getRoot();

        this.grilleAjouterPrix.add(new Label("Nom : "), 0, 0);
        this.grilleAjouterPrix.add(new Label("Prenom : "), 1, 0);
        this.grilleAjouterPrix.add(new Label("Age : "), 2, 0);

        valeurNom = new TextField("");
        valeurDate = new TextField("");
        valeurTemps = new TextField("");

        this.grilleAjouterPrix.add(valeurNom,0,1);
        this.grilleAjouterPrix.add(valeurDate,1,1);
        this.grilleAjouterPrix.add(valeurTemps,2,1);

        this.grilleAjouterPrix.add(new Button("enregistrer"),0,2);
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
}
