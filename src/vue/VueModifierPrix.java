package vue;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Prix;
import modele.Skieur;
import sun.security.acl.GroupImpl;

public class VueModifierPrix extends Scene {

    private TextField valeurNom;
    private TextField valeurDate;
    private TextField valeurTemps;
    private TextField valeurPlace;

    private GridPane grilleModifierPrix;

    public VueModifierPrix() {
        super(new GridPane(),400,400);
        grilleModifierPrix = (GridPane) this.getRoot();
    }

    public void afficherVueModifierPrix(Prix prix, Skieur skieur){
        this.grilleModifierPrix.add(new Label("Nom : "), 0, 0);
        this.grilleModifierPrix.add(new Label("Prenom : "), 1, 0);
        this.grilleModifierPrix.add(new Label("Age : "), 2, 0);
        this.grilleModifierPrix.add(new Label("Place : "), 3, 0);

        valeurNom = new TextField(prix.getNomPrix());
        valeurDate = new TextField(prix.getDatePrix());
        valeurTemps = new TextField(prix.getTemps());
        valeurPlace = new TextField(prix.getPlace());

        this.grilleModifierPrix.add(valeurNom,0,1);
        this.grilleModifierPrix.add(valeurDate,1,1);
        this.grilleModifierPrix.add(valeurTemps,2,1);
        this.grilleModifierPrix.add(valeurPlace ,3,1);

        this.grilleModifierPrix.add(new Button("enregistrer"),0,2);
    }
}
