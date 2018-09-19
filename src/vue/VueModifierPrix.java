package vue;

import action.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Prix;
import modele.Skieur;
import sun.security.acl.GroupImpl;

public class VueModifierPrix extends Scene {

    private Button actionModifierPrix;
    private TextField valeurNom;
    private TextField valeurDate;
    private TextField valeurTemps;

    private GridPane grilleModifierPrix;
    private Controleur controleur;
    private static Skieur skieur;

    public VueModifierPrix() {
        super(new GridPane(),400,400);
        grilleModifierPrix = (GridPane) this.getRoot();

        this.actionModifierPrix = new Button("enregistrer");
        this.actionModifierPrix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Prix prix = demanderPrix();
                controleur.modifierPrix(skieur,prix);
            }
        });
    }

    public void afficherVueModifierPrix(Prix prix, Skieur skieur)
    {
        VueModifierPrix.skieur = skieur;
        this.grilleModifierPrix.getChildren().clear();
        this.grilleModifierPrix.add(new Label("Nom : "), 0, 0);
        this.grilleModifierPrix.add(new Label("Prenom : "), 1, 0);
        this.grilleModifierPrix.add(new Label("Age : "), 2, 0);

        valeurNom = new TextField(prix.getNomPrix());
        valeurDate = new TextField(prix.getDatePrix());
        valeurTemps = new TextField(prix.getTemps());

        this.grilleModifierPrix.add(valeurNom,0,1);
        this.grilleModifierPrix.add(valeurDate,1,1);
        this.grilleModifierPrix.add(valeurTemps,2,1);

        this.grilleModifierPrix.add(actionModifierPrix,0,2);


    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    private Prix demanderPrix()
    {
        return new Prix(Integer.toString(skieur.getId()),valeurNom.getText(),valeurDate.getText(),valeurTemps.getText());
    }

}
