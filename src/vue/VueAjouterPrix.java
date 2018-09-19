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

public class VueAjouterPrix extends Scene {

    private Button actionCreerPrix;
    private TextField valeurNom;
    private TextField valeurDate;
    private TextField valeurTemps;
    private Skieur skieur;

    private GridPane grilleAjouterPrix;
    private Controleur controleur;

    public VueAjouterPrix() {
        super(new GridPane(),400,400);
        grilleAjouterPrix = (GridPane) this.getRoot();

        this.grilleAjouterPrix.add(new Label("Nom : "), 0, 0);
        this.grilleAjouterPrix.add(new Label("Date : "), 1, 0);
        this.grilleAjouterPrix.add(new Label("Temps : "), 2, 0);

        valeurNom = new TextField("");
        valeurDate = new TextField("");
        valeurTemps = new TextField("");

        this.grilleAjouterPrix.add(valeurNom,0,1);
        this.grilleAjouterPrix.add(valeurDate,1,1);
        this.grilleAjouterPrix.add(valeurTemps,2,1);

        this.actionCreerPrix = new Button("enregistrer");
        this.actionCreerPrix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                demanderPrix();
            }
        });

        this.grilleAjouterPrix.add(actionCreerPrix,0,2);
    }

    public void nettoyer()
    {
        this.valeurNom.setText("");
        this.valeurDate.setText("");
        this.valeurTemps.setText("");
    }

    private Prix demanderPrix()
    {
        return new Prix(Integer.toString(this.skieur.getId()),valeurNom.getText(),valeurDate.getText(),valeurTemps.getText());
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public void preparerSkieur(Skieur skieur) {
        this.skieur = skieur;
    }
}
